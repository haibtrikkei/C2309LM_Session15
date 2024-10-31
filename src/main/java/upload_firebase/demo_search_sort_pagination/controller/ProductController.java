package upload_firebase.demo_search_sort_pagination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upload_firebase.demo_search_sort_pagination.model.entity.Category;
import upload_firebase.demo_search_sort_pagination.model.entity.Product;
import upload_firebase.demo_search_sort_pagination.repository.CategoryRepository;
import upload_firebase.demo_search_sort_pagination.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/initData")
    public String initData(){
        List<Product> list = new ArrayList<>();
        Category c1 = categoryRepository.findById("c01").orElseThrow(()->new NoSuchElementException("Not found!"));
        Category c2 = categoryRepository.findById("c02").orElseThrow(()->new NoSuchElementException("Not found!"));
        Category c3 = categoryRepository.findById("c03").orElseThrow(()->new NoSuchElementException("Not found!"));
        Category c4 = categoryRepository.findById("c04").orElseThrow(()->new NoSuchElementException("Not found!"));

        list.add(new Product(0,"Tivi","Toshiba",2020,7000000D,c1));
        list.add(new Product(0,"Tủ lạnh","Sanyo",2021,5000000D,c2));
        list.add(new Product(0,"Lò vi sóng","Sharp",2022,3000000D,c1));
        list.add(new Product(0,"Tủ lạnh 1","Sanyo",2021,5000000D,c2));
        list.add(new Product(0,"Tủ lạnh 2","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 3","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 4","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 5","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 6","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 7","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 8","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 8","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 9","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 10","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 11","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 12","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 13","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 14","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 15","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 16","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 17","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 18","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 19","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 20","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 21","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 22","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 23","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 24","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 25","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 26","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 27","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 28","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 29","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 30","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 31","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 32","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 33","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 34","Sanyo",2021,5000000D,c1));
        list.add(new Product(0,"Tủ lạnh 35","Sanyo",2021,5000000D,c1));

        productService.saveListProducts(list);
        return "product/success";
    }

    @GetMapping(value = {"","/list_product"})
    public String list_product(@RequestParam(name = "proName",defaultValue = "")String proName,
                               @RequestParam(name = "page",defaultValue = "1")Integer page,
                               @RequestParam(name = "pageSize",defaultValue = "10")Integer pageSize,
                               @RequestParam(name = "sortBy",defaultValue = "")String sortBy,
                               @RequestParam(name = "orderBy",defaultValue = "asc")String orderBy,
                               Model model){
        Page<Product> productPage = productService.getProductsByNameAndPagination(proName, page=page-1, pageSize, sortBy, orderBy);
        List<Product> list = productPage.getContent();

        model.addAttribute("list",list);
        model.addAttribute("proName",proName);
        model.addAttribute("page",page);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("sortBy",sortBy);
        model.addAttribute("orderBy",orderBy);

        int totalPages = productPage.getTotalPages();
        List<Integer> listTotalPages = new ArrayList<>();
        for(int i=0;i<totalPages;i++){
            listTotalPages.add(i+1);
        }
        model.addAttribute("listPage",listTotalPages);

        return "product/listProduct";
    }
}

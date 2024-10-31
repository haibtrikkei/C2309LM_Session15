package upload_firebase.demo_search_sort_pagination.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import upload_firebase.demo_search_sort_pagination.model.entity.Product;
import upload_firebase.demo_search_sort_pagination.repository.ProductRepository;
import upload_firebase.demo_search_sort_pagination.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> saveListProducts(List<Product> products) {
        return productRepository.saveAllAndFlush(products);
    }

    @Override
    public Page<Product> getProductsByNameAndPagination(String proName, Integer page, Integer pageSize, String sortBy, String orderBy) {
        Pageable pageable;

        if(sortBy!=null && sortBy.length()>0){
            //co sap xep
            Sort sort;
            switch (orderBy){
                case "asc":
                    sort = Sort.by(sortBy).ascending();
                    break;
                case "desc":
                    sort = Sort.by(sortBy).descending();
                    break;
                default:
                    sort = Sort.by(sortBy).ascending(); //mac dinh se xep tang dan
            }

            pageable = PageRequest.of(page, pageSize, sort);
        }else{
            //khong sap xep
            pageable = PageRequest.of(page, pageSize);
        }
        return productRepository.findProductsByProNameContainsIgnoreCase(proName,pageable);
    }
}

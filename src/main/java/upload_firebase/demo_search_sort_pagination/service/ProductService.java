package upload_firebase.demo_search_sort_pagination.service;

import org.springframework.data.domain.Page;
import upload_firebase.demo_search_sort_pagination.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> saveListProducts(List<Product> products);

    Page<Product> getProductsByNameAndPagination(String proName, Integer page, Integer pageSize, String sortBy, String orderBy);
}

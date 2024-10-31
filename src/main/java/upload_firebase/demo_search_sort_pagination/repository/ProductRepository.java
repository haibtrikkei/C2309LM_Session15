package upload_firebase.demo_search_sort_pagination.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upload_firebase.demo_search_sort_pagination.model.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findProductsByProNameContainsIgnoreCase(String proName, Pageable pageable);
}

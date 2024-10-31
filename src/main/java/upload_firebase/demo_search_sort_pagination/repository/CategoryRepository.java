package upload_firebase.demo_search_sort_pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upload_firebase.demo_search_sort_pagination.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}

package upload_firebase.demo_search_sort_pagination.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @Column(name = "cate_id", length = 20)
    private String cateId;
    @Column(name = "cate_name",nullable = false,unique = true, length = 100)
    private String cateName;

    @OneToMany(mappedBy = "cate")
    private List<Product> products;
}

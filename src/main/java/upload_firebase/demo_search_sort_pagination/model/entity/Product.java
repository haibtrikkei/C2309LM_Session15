package upload_firebase.demo_search_sort_pagination.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proId;
    @Column(name = "product_name",length = 100)
    private String proName;
    @Column(name = "producer",length = 100)
    private String producer;
    @Column(name = "year_making")
    private Integer yearMaking;
    @Column(name = "price")
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cate_id",referencedColumnName = "cate_id")
    private Category cate;
}

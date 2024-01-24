package al.test.exercice_alten.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int id;

    @Column(name = "product_code")
    private String code;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_price")
    private BigDecimal price;

    @Column(name = "product_quantity")
    private int quantity;

    @Column(name = "product_status")
    private String inventoryStatus;

    @Column(name = "product_category")
    private String category;

    @Column(name = "product_img")
    private String img;

    @Column(name = "product_rating")
    private int rating;
}

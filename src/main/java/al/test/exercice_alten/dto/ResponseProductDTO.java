package al.test.exercice_alten.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDTO {
    private int id;
    private String code;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private String inventoryStatus;
    private String category;
    private String img;
    private int rating;
}

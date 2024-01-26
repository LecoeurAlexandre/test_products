package al.test.exercice_alten.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductDTO {
    private int id;

    @NotEmpty
    @Size(max = 9, message = "The code must not exceed 9 characters.")
    private String code;

    @NotEmpty
    @Size(max = 100, message = "The name must not exceed 100 characters.")
    private String name;

    @NotEmpty
    @Size(max = 255, message = "The description must not exceed 255 characters.")
    private String description;

    @DecimalMin(value = "0.00", inclusive = true, message = "The price must not be less than 0.00.")
    @DecimalMax(value = "99999999.99", inclusive = true, message = "The price must not exceed 9999999.99.")
    private BigDecimal price;

    @Min(value = 0, message = "The quantity must not be less than 0.")
    private int quantity;

    @NotEmpty
    @Size(max = 24, message = "The category must not exceed 24 characters.")
    private String category;

    @NotEmpty
    @Size(max = 24, message = "The image name must not exceed 24 characters.")
    private String img;

    @Min(value = 0, message = "The rating must not be less than 0.")
    @Max(value = 10, message = "The image name must not exceed 10.")
    private int rating;
}

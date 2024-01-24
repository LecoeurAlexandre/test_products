package al.test.exercice_alten.controller;

import al.test.exercice_alten.dto.RequestProductDTO;
import al.test.exercice_alten.dto.ResponseProductDTO;
import al.test.exercice_alten.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<ResponseProductDTO> createProduct(@RequestBody RequestProductDTO requestProductDTO) {
        return new ResponseEntity<>(productService.createProduct(requestProductDTO), HttpStatus.CREATED);
    }
}

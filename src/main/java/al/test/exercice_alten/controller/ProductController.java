package al.test.exercice_alten.controller;

import al.test.exercice_alten.dto.RequestProductDTO;
import al.test.exercice_alten.dto.ResponseProductDTO;
import al.test.exercice_alten.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<ResponseProductDTO> createProduct(@RequestBody RequestProductDTO requestProductDTO) {
        return new ResponseEntity<>(productService.createProduct(requestProductDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> getProductById(@PathVariable(name="id") int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @GetMapping()
    public ResponseEntity<List<ResponseProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> updateProduct(@RequestBody RequestProductDTO requestProductDTO, @PathVariable(name="id") int id) {
        ResponseProductDTO responseProductDTO = productService.updateProduct(requestProductDTO, id);
        return new ResponseEntity<>(responseProductDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name="id") int id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>("The product has been deleted", HttpStatus.OK);
    }
}

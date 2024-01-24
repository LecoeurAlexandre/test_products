package al.test.exercice_alten.service;

import al.test.exercice_alten.dto.RequestProductDTO;
import al.test.exercice_alten.dto.ResponseProductDTO;

import java.util.List;

public interface ProductService {
    ResponseProductDTO createProduct(RequestProductDTO requestProductDTO);
    List<ResponseProductDTO> getAllProducts();
    ResponseProductDTO getProductById(int id);
    ResponseProductDTO updateProduct(RequestProductDTO requestProductDTO, int id);
    void deleteProductById(int id);
}

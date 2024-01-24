package al.test.exercice_alten.service.impl;

import al.test.exercice_alten.dto.RequestProductDTO;
import al.test.exercice_alten.dto.ResponseProductDTO;
import al.test.exercice_alten.entity.ProductEntity;
import al.test.exercice_alten.repository.ProductRepository;
import al.test.exercice_alten.service.ProductService;
import al.test.exercice_alten.utils.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ResponseProductDTO createProduct(RequestProductDTO requestProductDTO) {
        String inventoryStatus = defineInventoryStatus(requestProductDTO.getQuantity());
        ProductEntity newProduct = productMapper.mapToProductEntity(requestProductDTO);
        newProduct.setInventoryStatus(inventoryStatus);
        productRepository.save(newProduct);
        return productMapper.mapToProductDTO(newProduct);
    }

    @Override
    public List<ResponseProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public ResponseProductDTO getProductById(int id) {
        return null;
    }

    @Override
    public ResponseProductDTO updateProduct(RequestProductDTO requestProductDTO, int id) {
        return null;
    }

    @Override
    public void deleteProductById(int id) {

    }

    public String defineInventoryStatus(int quantity) {
        if(quantity == 0) {
            return  "OUTOFSTOCK";
        } else if (quantity < 10) {
            return "LOWSTOCK";
        } else {
            return "INSTOCK";
        }
    }
}

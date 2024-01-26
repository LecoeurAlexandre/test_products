package al.test.exercice_alten.service.impl;

import al.test.exercice_alten.dto.RequestProductDTO;
import al.test.exercice_alten.dto.ResponseProductDTO;
import al.test.exercice_alten.entity.ProductEntity;
import al.test.exercice_alten.exception.ResourceNotFoundException;
import al.test.exercice_alten.repository.ProductRepository;
import al.test.exercice_alten.service.ProductService;
import al.test.exercice_alten.utils.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        ProductEntity newProduct = productMapper.mapToProductEntity(requestProductDTO);
        productRepository.save(newProduct);
        ResponseProductDTO responseProductDTO = productMapper.mapToProductDTO(newProduct);
        responseProductDTO.setInventoryStatus(defineInventoryStatus(responseProductDTO.getQuantity()));
        return responseProductDTO;
    }

    @Override
    public List<ResponseProductDTO> getAllProducts() {
        List<ProductEntity> products = (List<ProductEntity>) productRepository.findAll();
        List<ResponseProductDTO> productsDTOList = products.stream().map(product->productMapper.mapToProductDTO(product)).collect(Collectors.toList());
        return productsDTOList;
    }

    @Override
    public ResponseProductDTO getProductById(int id) {
        ProductEntity product = getProductByIdInDB(id);
        return productMapper.mapToProductDTO(product);
    }

    @Override
    public ResponseProductDTO updateProduct(RequestProductDTO productDTO, int id) {
        ProductEntity product = getProductByIdInDB(id);
        product.setCode(productDTO.getCode());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategory(productDTO.getCategory());
        product.setImg(productDTO.getImg());
        product.setRating(productDTO.getRating());
        ProductEntity updatedProduct = productRepository.save(product);
        ResponseProductDTO responseProductDTO = productMapper.mapToProductDTO(updatedProduct);
        responseProductDTO.setInventoryStatus(defineInventoryStatus(responseProductDTO.getQuantity()));
        return responseProductDTO;
    }

    @Override
    public void deleteProductById(int id) {
        ProductEntity product = getProductByIdInDB(id);
        productRepository.deleteById(product.getId());
    }

    private String defineInventoryStatus(int quantity) {
        if(quantity == 0) {
            return  "OUTOFSTOCK";
        } else if (quantity < 10) {
            return "LOWSTOCK";
        } else {
            return "INSTOCK";
        }
    }

    private ProductEntity getProductByIdInDB(int id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }
}

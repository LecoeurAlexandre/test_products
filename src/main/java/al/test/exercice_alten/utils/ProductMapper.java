package al.test.exercice_alten.utils;

import al.test.exercice_alten.dto.RequestProductDTO;
import al.test.exercice_alten.dto.ResponseProductDTO;
import al.test.exercice_alten.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public ResponseProductDTO mapToProductDTO(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ResponseProductDTO.class);
    }

    public ProductEntity mapToProductEntity(RequestProductDTO requestProductDTO) {
        return modelMapper.map(requestProductDTO, ProductEntity.class);
    }
}

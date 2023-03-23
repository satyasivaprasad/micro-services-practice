package ms.learnings.productservice.mapper;

import ms.learnings.productservice.dto.ProductResponse;
import ms.learnings.productservice.model.Product;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductResponse convertToProductResponse(Product product);
    List<ProductResponse> map(List<Product> products);

}

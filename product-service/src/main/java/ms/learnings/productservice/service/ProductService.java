package ms.learnings.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.learnings.productservice.dto.ProductRequest;
import ms.learnings.productservice.dto.ProductResponse;
import ms.learnings.productservice.mapper.ProductMapper;
import ms.learnings.productservice.model.Product;
import ms.learnings.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder().name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
        productRepository.save(product);
        log.info("Product {} is saved ", product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        ProductResponse productResponse = ProductMapper.INSTANCE.convertToProductResponse(products.get(0));
        return ProductMapper.INSTANCE.map(products);
    }
}

package ms.learnings.orderservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.learnings.orderservice.client.InventoryClient;
import ms.learnings.orderservice.dto.InventoryResponse;
import ms.learnings.orderservice.dto.OrderRequest;
import ms.learnings.orderservice.mapper.OrderMapper;
import ms.learnings.orderservice.model.Order;
import ms.learnings.orderservice.model.OrderLineItems;
import ms.learnings.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final InventoryClient inventoryClient;

    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = OrderMapper.INSTANCE.mapOrderLineItems(orderRequest.getOrderLineItemsDtoList());

        order.setOrderLineItems(orderLineItems);

        Set<String> skuCodes = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .collect(Collectors.toSet());

        Set<InventoryResponse> inventoryResponses = inventoryClient.getSkuCodes(skuCodes);
        boolean allProductsInStock = inventoryResponses.stream().allMatch(InventoryResponse::isInStock);

        if (inventoryResponses.isEmpty() || !allProductsInStock) {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        } else {
            orderRepository.save(order);
        }
    }
}

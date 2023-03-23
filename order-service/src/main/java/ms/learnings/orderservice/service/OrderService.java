package ms.learnings.orderservice.service;

import lombok.RequiredArgsConstructor;
import ms.learnings.orderservice.dto.OrderRequest;
import ms.learnings.orderservice.mapper.OrderMapper;
import ms.learnings.orderservice.model.Order;
import ms.learnings.orderservice.model.OrderLineItems;
import ms.learnings.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = OrderMapper.INSTANCE.mapOrderLineItems(orderRequest.getOrderLineItemsDtoList());

        order.setOrderLineItems(orderLineItems);
        orderRepository.save(order);

    }
}

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


public interface OrderService {

    public void placeOrder(OrderRequest orderRequest);
}

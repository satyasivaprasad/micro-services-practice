package ms.learnings.orderservice.mapper;

import ms.learnings.orderservice.dto.OrderLineItemsDto;
import ms.learnings.orderservice.model.OrderLineItems;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    List<OrderLineItems> mapOrderLineItems(List<OrderLineItemsDto> orderLineItemsDtoList);
}

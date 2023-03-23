package ms.learnings.orderservice.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ms.learnings.orderservice.dto.OrderLineItemsDto;
import ms.learnings.orderservice.model.OrderLineItems;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-24T01:24:02+0530",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 19.0.1 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public List<OrderLineItems> mapOrderLineItems(List<OrderLineItemsDto> orderLineItemsDtoList) {
        if ( orderLineItemsDtoList == null ) {
            return null;
        }

        List<OrderLineItems> list = new ArrayList<OrderLineItems>( orderLineItemsDtoList.size() );
        for ( OrderLineItemsDto orderLineItemsDto : orderLineItemsDtoList ) {
            list.add( orderLineItemsDtoToOrderLineItems( orderLineItemsDto ) );
        }

        return list;
    }

    protected OrderLineItems orderLineItemsDtoToOrderLineItems(OrderLineItemsDto orderLineItemsDto) {
        if ( orderLineItemsDto == null ) {
            return null;
        }

        OrderLineItems orderLineItems = new OrderLineItems();

        orderLineItems.setId( orderLineItemsDto.getId() );
        orderLineItems.setSkuCode( orderLineItemsDto.getSkuCode() );
        orderLineItems.setPrice( orderLineItemsDto.getPrice() );
        orderLineItems.setQuantity( orderLineItemsDto.getQuantity() );

        return orderLineItems;
    }
}

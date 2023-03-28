package ms.learnings.orderservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class InventoryResponse {
    private String skuCode;
    @EqualsAndHashCode.Exclude
    private boolean isInStock;
}

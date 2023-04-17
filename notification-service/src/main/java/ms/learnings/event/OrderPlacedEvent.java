package ms.learnings.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OrderPlacedEvent {
    private String orderNumber;
}

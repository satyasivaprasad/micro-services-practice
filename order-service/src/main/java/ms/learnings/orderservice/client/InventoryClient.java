package ms.learnings.orderservice.client;

import ms.learnings.orderservice.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@FeignClient(value = "inventory-service", url = "${spring.cloud.openfeign.client.config.inventory-service.url}")
public interface InventoryClient {

    @GetMapping("/inventory")
    Set<InventoryResponse> getSkuCodes(@RequestParam("skuCode") Set<String> includes);
}
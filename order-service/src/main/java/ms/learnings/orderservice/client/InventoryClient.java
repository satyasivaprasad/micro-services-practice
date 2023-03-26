package ms.learnings.orderservice.client;

import ms.learnings.orderservice.config.ClientConfiguration;
import ms.learnings.orderservice.dto.InventoryResponse;
import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "inventory-service", url = "http://localhost:8082/api/")
public interface InventoryClient {

    @GetMapping("/inventory")
    List<InventoryResponse> getSkuCodes(@RequestParam("skuCode") List<String> includes);
}
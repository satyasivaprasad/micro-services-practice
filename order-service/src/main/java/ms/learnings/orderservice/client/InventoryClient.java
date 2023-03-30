package ms.learnings.orderservice.client;

import ms.learnings.orderservice.dto.InventoryResponse;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@FeignClient(name = "${spring.cloud.openfeign.client.config.inventory-service.name}")
public interface InventoryClient {
    String ENDPOINT = "/api/inventory";

    @RequestMapping(method = RequestMethod.GET, value = ENDPOINT)
    Set<InventoryResponse> getSkuCodes(@RequestParam("skuCode") Set<String> includes);
}
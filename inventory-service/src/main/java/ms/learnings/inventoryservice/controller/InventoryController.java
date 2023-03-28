package ms.learnings.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import ms.learnings.inventoryservice.dto.InventoryResponse;
import ms.learnings.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory/iphone-13,iphone13-red

    // http://localhost:8082/api/inventory?skuCode=iphone-13&skuCode=iphone13-red
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam Set<String> skuCode) {
        return inventoryService.isInStock(skuCode);
    }

}

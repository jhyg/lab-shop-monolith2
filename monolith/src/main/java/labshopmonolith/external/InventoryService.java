package labshopmonolith.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "inventory", url = "${api.url.inventory}")
public interface InventoryService {
    @RequestMapping(method = RequestMethod.GET, path = "/inventories/{id}")
    public Inventory getInventory(@PathVariable("id") Long id);

    @RequestMapping(
        method = RequestMethod.PUT,
        path = "/inventories/{id}/decreaseinventory"
    )
    public void decreaseInventory(
        @PathVariable("id") Long id,
        @RequestBody DecreaseInventoryCommand decreaseInventoryCommand
    );

    @RequestMapping(method = RequestMethod.GET, path = "/inventories/{id}")
    @RequestMapping(
        method = RequestMethod.PUT,
        path = "/inventories/{id}/decreaseinventory"
    )
    public void decreaseInventory(
        @PathVariable("id") Long id,
        @RequestBody DecreaseInventoryCommand decreaseInventoryCommand
    );
}

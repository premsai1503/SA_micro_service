package in.ac.iiitb.item.Controller;

import in.ac.iiitb.item.Dto.ItemDto;
import in.ac.iiitb.item.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem")
    public ResponseEntity<ItemDto> getDomains(@RequestBody ItemDto newItem) {

        ItemDto item = itemService.addItem(newItem);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping("/updateItem")
    public ResponseEntity<ItemDto> updateItem(@RequestBody ItemDto newItem) {

        ItemDto item = itemService.updateItem(newItem);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping("/getitemsfromdomainId/{id}")
    public ResponseEntity<ArrayList<ItemDto>> getItems(@PathVariable String id) {
        ArrayList<ItemDto> items = itemService.getItems(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }


}

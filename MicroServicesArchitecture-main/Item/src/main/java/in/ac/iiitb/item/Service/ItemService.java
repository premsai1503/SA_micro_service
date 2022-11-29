package in.ac.iiitb.item.Service;

import in.ac.iiitb.item.Dto.ItemDto;

import java.util.ArrayList;

public interface ItemService {

    ArrayList<ItemDto> getItems(String id);

    ItemDto addItem(ItemDto newItem);

    ItemDto updateItem(ItemDto newItem);
}

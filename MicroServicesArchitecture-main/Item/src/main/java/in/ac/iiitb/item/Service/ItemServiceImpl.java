package in.ac.iiitb.item.Service;


import in.ac.iiitb.item.Dto.ItemDto;
import in.ac.iiitb.item.Entity.Item;
import in.ac.iiitb.item.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepo;

    @Override
    public ArrayList<ItemDto> getItems(String id) {
        ArrayList<Item> items = itemRepo.findByDomainId(id);
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        for(int i=0; i<items.size(); i++){
            itemDtos.add( new ItemDto(items.get(i).getDomainId(),
                    items.get(i).getItemType(),
                    items.get(i).getItemId(),
                    items.get(i).getDescription(),
                    items.get(i).getOption1(),
                    items.get(i).getOption2(),
                    items.get(i).getOption3(),
                    items.get(i).getOption4()));
        }
        return itemDtos;
    }

    @Override
    public ItemDto addItem(ItemDto newItem) {
        Item item = new Item();
        item.setDomainId(newItem.getDomainId());
        item.setItemType(newItem.getItemType());
        item.setItemId(newItem.getItemId());
        item.setDescription(newItem.getDescription());
        item.setOption1(newItem.getOption1());
        item.setOption2(newItem.getOption2());
        item.setOption3(newItem.getOption3());
        item.setOption4(newItem.getOption4());
        try {
            itemRepo.save(item);
            return newItem;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ItemDto updateItem(ItemDto newItem) {
        itemRepo.deleteByItemId(newItem.getItemId());
        return addItem(newItem);
    }
}

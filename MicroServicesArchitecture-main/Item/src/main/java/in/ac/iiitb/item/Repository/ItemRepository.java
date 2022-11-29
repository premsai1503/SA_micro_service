package in.ac.iiitb.item.Repository;

import in.ac.iiitb.item.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    ArrayList<Item> findByDomainId(String domainId);

    @Transactional
    int deleteByItemId(String itemId);
}
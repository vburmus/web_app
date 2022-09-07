package com.my.dao;

import com.my.db.DBManager;
import com.my.db.Fields;
import com.my.model.Category;
import com.my.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemDAOTest {
ItemDAO itemDAO = new ItemDAO(true);
CategoryDAO categoryDAO = new CategoryDAO(true);
    @BeforeEach
     void clearTable(){
        DBManager dbManager = DBManager.getTestInstance();
        dbManager.clearTable("items_has_transaction");
        dbManager.clearTable("order_has_transaction");
        dbManager.clearTable("category_has_items");
        dbManager.clearTable("category");
        dbManager.clearTable("items");
        dbManager.clearTable("transaction");
        dbManager.clearTable("orders");
        dbManager.clearTable("users");
    }
    @Test
    void addAndFindProduct() {
        Item item = new Item();
        item.setName("asdf");
        item.setQuantity(34);
        item.setTitle("qwerty");
        item.setPrice(300);
        Category category = new Category("3","3");
        categoryDAO.add(category);
        item.setCategory(category);
        itemDAO.add(item);
        Item foundItem = itemDAO.find("asdf");
        Assertions.assertEquals(item.getId(), foundItem.getId());
        Assertions.assertEquals(item.getName(), foundItem.getName());


    }

    @Test
    void getList() {
        ArrayList<Item> items = new ArrayList<>();
        Category category = new Category("3","3");
        categoryDAO.add(category);
        for(int i = 0;i < 10;i++) {
            Item item = new Item();
            item.setName("asdf" +i);
            item.setQuantity(34);
            item.setTitle("qwerty");
            item.setPrice(300);
            item.setCategory(category);
            itemDAO.add(item);
            items.add(item);
        }
        Item storedItem =null;
        Item foundItem =null;
        List<Item> foundItems = itemDAO.getList();
        for(int i = 0; i < 10;i++){
            storedItem = items.get(i);
            foundItem = foundItems.get(i);
            Assertions.assertEquals(storedItem.getId(), foundItem.getId());
            Assertions.assertEquals(storedItem.getName(), foundItem.getName());
            Assertions.assertEquals(storedItem.getTitle(), foundItem.getTitle());
        }
        Assertions.assertEquals(items.size(), itemDAO.getCountOfItems());
    }


}
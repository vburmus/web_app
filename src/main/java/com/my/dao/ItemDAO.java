package com.my.dao;

import com.my.db.DBManager;
import com.my.db.Fields;
import com.my.model.Item;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.my.db.Constants.*;
import static com.my.db.DBManager.LOGGER;


public class ItemDAO implements IDAO<Item> {
private static DBManager manager = DBManager.getInstance();

    public void add(@NotNull Item item) {
        LOGGER.info("Adding item..");


        try(Connection con = manager.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT_ITEM, PreparedStatement.RETURN_GENERATED_KEYS);
            PreparedStatement ps2 = con.prepareStatement(SQL_ADD_CATEGORY_ITEM)){
            int k = 1;
            preparedStatement.setString(k++, item.getName());
            preparedStatement.setInt(k++, item.getQuantity());
            preparedStatement.setString(k++, item.getTitle());
            preparedStatement.setFloat(k++, item.getPrice());
            preparedStatement.setString(k++, item.getPhoto());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next())
                item.setId(rs.getInt(1));
            k=1;
            ps2.setInt(k++,item.getCategory().getId());
            ps2.setInt(k++, item.getId());
            ps2.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public List getList() {
        return null;
    }

    public  List getList(int offset){
        List<Item> items = new ArrayList<>();

        try {
            ResultSet rs = manager.getRSFromSql("SELECT * FROM items LIMIT 4 OFFSET " + offset);
            while (rs.next()) {
                items.add(extract(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public  Item extract(@NotNull ResultSet rs) {
        Item item = new Item();
        try {
            item.setId(rs.getInt(Fields.ITEM_ID));
            item.setName(rs.getString(Fields.ITEM_NAME));
            item.setQuantity(rs.getInt(Fields.ITEM_QUANTITY));
            item.setTitle(rs.getString(Fields.ITEM_TITLE));
            item.setPrice(rs.getFloat(Fields.ITEM_PRICE));
            item.setPhoto(rs.getString(Fields.ITEM_PHOTO));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    public  Item find(String item){
        LOGGER.info("Finding item...");

        try(Connection con = manager.getConnection()){
            PreparedStatement preparedStatement = null;
            try {
                int id = Integer.parseInt(item);
                preparedStatement = con.prepareStatement(SQL_SELECT_ITEM_BY_ID);
                preparedStatement.setInt(1, id);
                }catch (NumberFormatException e){
                    preparedStatement = con.prepareStatement(SQL_SELECT_ITEM_BY_NAME);
                    preparedStatement.setString(1,item);
                }
            ResultSet rs = preparedStatement.executeQuery();
            Item extractedItem = null;
            if(rs.next()){
               extractedItem = extract(rs);
            }
            return extractedItem;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    /**
     * Method getCountOfItems() is used to return count of items in table.
     *
     */
    public int getCountOfItems(){

        int count = 0;
        try(Connection con = manager.getConnection()){
            ResultSet rs = manager.getRSFromSql(SQL_GET_TOTAL_ITEMS);
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    /**
     * Method updateItemQuantity() is used to update the quantity of item.
     * @params item - item to update
     */
    public void updateItemQuantity(@NotNull Item item){
        try(Connection con = manager.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL_UPDATE_ITEM_QUANTITY)){
            ps.setInt(1,item.getQuantity());
            ps.setInt(2,item.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

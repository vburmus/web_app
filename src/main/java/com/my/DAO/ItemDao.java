package com.my.DAO;

import com.my.DAO.DB.Fields;
import com.my.Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.my.DAO.DB.Constants.*;


public class ItemDao {
private static DBManager manager = DBManager.getInstance();
    public void addItem(Item item) throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");


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
    public static List getItemsList(int offset){
        List<Item> items = new ArrayList<>();

        try {
            ResultSet rs = manager.getRSFromSql("SELECT * FROM items LIMIT 4 OFFSET " + offset);
            while (rs.next()) {
                items.add(extractItem(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public static Item extractItem(ResultSet rs) {
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
    public static Item findItem(String item){

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
               extractedItem = extractItem(rs);
            }
            return extractedItem;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public int getCount(){

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
    public void updateItemQuantity(Item item){
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

package com.my.dao;

import com.my.db.DBManager;
import com.my.model.Item;
import com.my.model.Order;
import com.my.model.Transaction;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.my.db.Constants.*;
import static com.my.db.DBManager.LOGGER;

public class OrderDAO implements IDAO<Order>{
    private static DBManager manager;
    private ItemDAO itemDao;

    public OrderDAO() {
        manager = DBManager.getInstance();
        itemDao = new ItemDAO();
    }
    public OrderDAO(boolean test) {
        manager = DBManager.getTestInstance();
        itemDao = new ItemDAO(true);
    }
    public void add(@NotNull Order order){
        LOGGER.info("Adding order...");

        int res = 0;
        try(Connection con = manager.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT_ORDER, PreparedStatement.RETURN_GENERATED_KEYS);
            PreparedStatement orderStmt = con.prepareStatement(SQL_ORDER_TRANSACTION);){

            int k =1;
            preparedStatement.setInt(1, order.getUsers_id());
            preparedStatement.setString(2, order.getDate());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next())
                order.setId(rs.getInt(1));
            for (Transaction transaction:order.getTransactions()) {
                 k = 1;
                orderStmt.setInt(k++, order.getId());
                orderStmt.setInt(k++, transaction.getId());
                orderStmt.executeUpdate();
            }

            updateOrder(order);

              } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  List getList(){
        List<Order> orders = new ArrayList<>();

        try {
            ResultSet rs = manager.getRSFromSql(SQL_SELECT_ORDERS);
            while (rs.next()) {
                orders.add(extract(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
    public int getCountOfItems(){

        int count = 0;
        try(Connection con = manager.getConnection()){
            ResultSet rs = manager.getRSFromSql(SQL_GET_TOTAL_ORDERS);
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    public  Order extract(@NotNull ResultSet rs) {
        Order order = new Order();
        try {
           order.setId(rs.getInt("id"));
           order.setUsers_id(rs.getInt("user"));
           order.setDate(rs.getString("created"));
           order.setSummary(rs.getFloat("summary"));
           order.setTransactions(extractOrderTransactions(order.getId()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    public  Order find(String id){
        Order order = null;
        try(Connection con = manager.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL_SELECT_ORDER)){
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                order = extract(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return order;
    }

    public List getList(int offset) {
        List<Order> orders = new ArrayList<>();

        try {
            ResultSet rs = manager.getRSFromSql("SELECT * FROM orders LIMIT 4 OFFSET " + offset);
            while (rs.next()) {
                orders.add(extract(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    /**
     * this method returns transaction from order list
     * @param transactionId
     * @param orderId
     * @return Transaction object
     */
    private @NotNull Transaction extractTransactionFromOrdersList(int transactionId, int orderId) {
        Transaction transaction = new Transaction();
        try(Connection con = manager.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_EXECUTE_TRANSACTION)){

            ps.setInt(1,transactionId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                transaction.setId(rs.getInt("id"));
                transaction.setItem(itemDao.find(String.valueOf(rs.getInt("item_id"))));
                transaction.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transaction;
    }

    /**
     * This method returns list of order transactions
     * @param orderId
     * @return List of transactions
     */
    public ArrayList<Transaction> extractOrderTransactions(int orderId) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try(Connection con = manager.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT_ORDER_TRANSACTIONS)) {
            ps.setInt(1,orderId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                transactions.add(extractTransactionFromOrdersList(rs.getInt("transaction_id"),orderId));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return transactions;

    }

    /**
     * This method updates an order
     * @param order
     */
    public void updateOrder(@NotNull Order order){
        LOGGER.info("Updating order...");
        try(Connection con = manager.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_UPDATE_ORDER, PreparedStatement.RETURN_GENERATED_KEYS);){
            float summary = 0;

            order.setTransactions(extractOrderTransactions(order.getId()));
            for (Transaction transaction:order.getTransactions()) {
                summary += transaction.getQuantity() * transaction.getItem().getPrice();

            }
            int k = 1;
            ps.setFloat(k++, summary);
            ps.setInt(k++,order.getId());
            ps.executeUpdate();
            ResultSet rs  = ps.getGeneratedKeys();
            if(rs.next())
                order.setSummary(rs.getFloat(4));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method deletes an order
     * @param order
     */
    public void deleteOrder(@NotNull Order order){

        Connection con = null;
        try{

            con = manager.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_DELETE_ORDER);

            ps.setInt(1,order.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
          e.printStackTrace();
        }finally {
            manager.close(con);
        }
        for (Transaction transaction: order.getTransactions()){
            Item item = transaction.getItem();
            item.setQuantity(item.getQuantity()+transaction.getQuantity());
            itemDao.updateItemQuantity(item);
        }
    }

}

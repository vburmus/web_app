package com.my.DAO;

import com.my.Model.Item;
import com.my.Model.Order;
import com.my.Model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.my.DAO.DB.Constants.*;

public class OrderDAO {
    private static DBManager manager = DBManager.getInstance();
    private ItemDao itemDao = new ItemDao();
    public void addOrder(Order order){


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
    public void updateOrder(Order order){

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
    public  List getOrders(){
        List<Order> orders = new ArrayList<>();

        try {
            ResultSet rs = manager.getRSFromSql(SQL_SELECT_ORDERS);
            while (rs.next()) {
                orders.add(extractOrder(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
    public  Order extractOrder(ResultSet rs) {
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
    public  ArrayList<Transaction> extractOrderTransactions(int orderId) {
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

    private  Transaction extractTransactionFromOrdersList(int transactionId, int orderId) {
        Transaction transaction = new Transaction();
        try(Connection con = manager.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL_EXECUTE_TRANSACTION)){

            ps.setInt(1,transactionId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                transaction.setId(rs.getInt("id"));
                transaction.setItem(ItemDao.findItem(String.valueOf(rs.getInt("item_id"))));
                transaction.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transaction;
    }
    public  Order findOrderById(String id){
        Order order = new Order();
        try(Connection con = manager.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL_SELECT_ORDER)){
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                order = extractOrder(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return order;
    }
    public void deleteOrder(Order order){

        Connection con = null;
        try{
            con = manager.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_DELETE_ORDER);
            con.setAutoCommit(false);
            ps.setInt(1,order.getId());
            ps.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
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

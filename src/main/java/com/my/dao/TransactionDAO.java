package com.my.dao;

import com.my.db.DBManager;
import com.my.model.Item;
import com.my.model.Order;
import com.my.model.Transaction;
import com.my.services.exception.MyException;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.my.db.Constants.*;

public class TransactionDAO implements IDAO<Transaction> {
    private static DBManager manager;
    private OrderDAO orderDAO;
    private ItemDAO itemDao;
    public TransactionDAO(){
        manager = DBManager.getInstance();
        orderDAO = new OrderDAO();
        itemDao = new ItemDAO();
    }
    public TransactionDAO(boolean test){
        manager = DBManager.getTestInstance();
        orderDAO = new OrderDAO(true);
        itemDao = new ItemDAO(true);
    }
    public void add(@NotNull Transaction transaction) throws MyException {
        int res = 0;
        Connection con = null;
        ResultSet rs  = null;
        try {
            con = manager.getConnection();
            PreparedStatement transactionStmt = con.prepareStatement(SQL_INSERT_TRANSACTION, PreparedStatement.RETURN_GENERATED_KEYS);

            con.setAutoCommit(false);

            int k = 1;
            transactionStmt.setInt(k++, transaction.getItem().getId());
            transactionStmt.setInt(k++, transaction.getQuantity());
            res = transactionStmt.executeUpdate();
            rs = transactionStmt.getGeneratedKeys();
            if (rs.next())
                transaction.setId(rs.getInt(1));
            con.commit();
            Item item = transaction.getItem();
            item.setQuantity(item.getQuantity() - transaction.getQuantity());
            itemDao.updateItemQuantity(transaction.getItem());
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new MyException();
            }
        } finally {
            manager.close(con);
        }
    }

    public  Transaction find(String id) throws MyException {
        Transaction transaction = null;

        try (Connection con = manager.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_SELECT_TRANSACTION)) {
            ps.setString(1,id);
            ResultSet rs  = ps.executeQuery();
            if(rs.next()){
               transaction = extract(rs);
            }
            return transaction;
        } catch (Exception e) {
            throw new MyException();
        }

    }

    public  Transaction extract(@NotNull ResultSet rs) throws MyException {
        Transaction transaction = new Transaction();
        try {
           transaction.setQuantity(rs.getInt(3));
           transaction.setItem(itemDao.find(String.valueOf(rs.getInt(2))));
           transaction.setId(rs.getInt(1));
           transaction.setOrder(findTransactionsOrder(transaction.getId()));
        } catch (SQLException e) {
            throw new MyException();
        }
        return transaction;
    }

    /**
     * This method finds order by transaction
     * @param transactionId
     * @return Order
     */
    public Order findTransactionsOrder(int transactionId) throws MyException {

        Order order = null;
        try(Connection con = manager.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_SELECT_TRANSACTIONS_ORDER)){
            ps.setInt(1,transactionId);
            ResultSet rs  = ps.executeQuery();
            if(rs.next()){
                order = orderDAO.find(String.valueOf(rs.getInt(1)));
            }
        } catch (SQLException e) {
            throw new MyException();
        }
        return order;
    }

    /**
     * This method changes quantity of item in transaction
     * @param transaction
     * @param changedQuantity
     * @param addPcs
     */
    public void changeQuantity(@NotNull Transaction transaction, int changedQuantity, boolean addPcs) throws MyException {
        int unchangedQuantity = transaction.getQuantity();

            Connection con = null;
                try{
                    con = manager.getConnection();
                    PreparedStatement ps = con.prepareStatement(SQL_UPDATE_QUANTITY_TRANSACTION);
                    PreparedStatement ps2 = con.prepareStatement(SQL_UPDATE_QUANTITY_ITEM);
                    //add num in trans
                    con.setAutoCommit(false);
                    transaction.setQuantity(changedQuantity);
                    int k = 1;
                    ps.setInt(k++,changedQuantity);
                    ps.setInt(k++,transaction.getId());
                    ps.executeUpdate();
                    //remove from item
                    int change = Math.abs(changedQuantity  - unchangedQuantity);
                    Item item = transaction.getItem();
                    if(addPcs){
                    item.setQuantity(item.getQuantity() + change);
                    k = 1;
                    ps2.setInt(k++, item.getQuantity());
                    ps2.setInt(k++, item.getId());
                    ps2.executeUpdate();
                    }else{
                        item.setQuantity(item.getQuantity() - change);

                        k = 1;
                        ps2.setInt(k++, item.getQuantity());
                        ps2.setInt(k++, item.getId());
                        ps2.executeUpdate();
                    }

                    con.commit();
                    itemDao.updateItemQuantity(item);
                } catch (SQLException e) {
                    try {
                        con.rollback();
                    } catch (SQLException ex) {
                        throw new MyException();
                    }
                }finally {
                    manager.close(con);
                }

        }

    /**
     * This method deletes a transaction
     * @param transaction
     */
    public void deleteTransaction(@NotNull Transaction transaction) throws MyException {
            Connection con = null;
        try{
            con = manager.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_DELETE_ORDER_TRANSACTION);
            PreparedStatement ps2 = con.prepareStatement(SQL_DELETE_TRANSACTION);
            con.setAutoCommit(false);
            //remove polaczenie
            ps.setInt(1,transaction.getId());
            ps.executeUpdate();

            ps2.setInt(1,transaction.getId());
            ps2.executeUpdate();
            con.commit();

            Order order = transaction.getOrder();
            for(int i = 0; i < order.getTransactions().size(); i++){
                if(order.getTransactions().get(i).getId() == transaction.getId())
                    order.getTransactions().remove(order.getTransactions().get(i));
            }

            } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new MyException();
            }
        }finally {
            manager.close(con);
        }
        }


}

package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.ItemDAO;
import com.my.DAO.OrderDAO;
import com.my.DAO.TransactionDAO;
import com.my.Model.Item;
import com.my.Model.Order;
import com.my.Model.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.my.DB.DBManager.LOGGER;

public class DeleteTransactionCommand implements ICommand {
    private TransactionDAO transactionDAO = new TransactionDAO();
    private ItemDAO itemDao = new ItemDAO();
    OrderDAO orderDao = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        LOGGER.info("User is trying to delete transaction.");
        Transaction transaction = transactionDAO.find(req.getParameter("transactionId"));
        if(transaction!=null) {
            Item item = transaction.getItem();
            item.setQuantity(item.getQuantity() + transaction.getQuantity());
            itemDao.updateItemQuantity(item);
            transactionDAO.deleteTransaction(transaction);

            Order order = transaction.getOrder();
            orderDao.updateOrder(order);
            LOGGER.info("Success.");
            if (order.getTransactions().size() == 0) {
                orderDao.deleteOrder(order);
                return req.getContextPath() + "/controller?command=ORDERS_PAGE";
            } else {
                return req.getContextPath() + "/controller?command=ORDER_PAGE&orderId=" + order.getId();
            }

        }else{
            try {
                res.sendError(HttpServletResponse.SC_NOT_FOUND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }
}

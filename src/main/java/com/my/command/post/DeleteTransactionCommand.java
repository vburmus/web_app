package com.my.command.post;

import com.my.command.ICommand;
import com.my.dao.ItemDAO;
import com.my.dao.OrderDAO;
import com.my.dao.TransactionDAO;
import com.my.model.Item;
import com.my.model.Order;
import com.my.model.Transaction;
import com.my.services.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static com.my.db.DBManager.LOGGER;

public class DeleteTransactionCommand implements ICommand {
    private TransactionDAO transactionDAO = new TransactionDAO();
    private ItemDAO itemDao = new ItemDAO();
    OrderDAO orderDao = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws MyException {
        LOGGER.info("User is trying to delete transaction.");
        HttpSession session = req.getSession();
        String errorMessagePage = "order";
        session.setAttribute("errorPage",errorMessagePage);

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
                return req.getContextPath() + "/controller?command=ORDERS_PAGE&page=1";
            } else {
                return req.getContextPath() + "/controller?command=ORDER_PAGE&orderId=" + order.getId();
            }

        }else{
            try {
                res.sendError(HttpServletResponse.SC_NOT_FOUND);
            } catch (IOException e) {
                throw new MyException();
            }
            return null;
        }
    }
}

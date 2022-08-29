package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.ItemDao;
import com.my.DAO.OrderDAO;
import com.my.DAO.TransactionDAO;
import com.my.Model.Item;
import com.my.Model.Order;
import com.my.Model.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteTransactionCommand implements ICommand {
    private TransactionDAO transactionDAO = new TransactionDAO();
    private ItemDao itemDao = new ItemDao();
    OrderDAO orderDao = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        Transaction transaction = transactionDAO.findTransaction(req.getParameter("transactionId"));
        Item item = transaction.getItem();
        item.setQuantity(item.getQuantity()+ transaction.getQuantity());
        itemDao.updateItemQuantity(item);
        transactionDAO.deleteTransaction(transaction);

        Order order = transaction.getOrder();
        orderDao.updateOrder(order);
        if(order.getTransactions().size() == 0) {
           orderDao.deleteOrder(order);
            return  req.getContextPath() + "/controller?command=ORDERS_PAGE";
        }else{
            return  req.getContextPath() + "/controller?command=ORDER_PAGE&orderId=" + order.getId();
        }
    }
}

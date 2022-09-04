package com.my.command.post;

import com.my.command.ICommand;

import com.my.dao.OrderDAO;
import com.my.dao.TransactionDAO;
import com.my.model.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.db.DBManager.LOGGER;

public class ChangeQuantityCommand implements ICommand {
    TransactionDAO transactionDAO = new TransactionDAO();
    OrderDAO orderDAO = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        Transaction transaction = transactionDAO.find(req.getParameter("transactionId"));
            LOGGER.info("User is trying to change quantity.");

            int changedQuantity = Integer.parseInt(req.getParameter("changedQuantity"));
             if(transaction.getItem().getQuantity() >= changedQuantity- transaction.getQuantity()) {
                 if (transaction.getQuantity() < changedQuantity) {
                     transactionDAO.changeQuantity(transaction, changedQuantity, false);
                 } else if (transaction.getQuantity() > changedQuantity) {
                     transactionDAO.changeQuantity(transaction, changedQuantity, true);
                 }
                 orderDAO.updateOrder(transaction.getOrder());
                 req.getSession().removeAttribute("errorMessage");
                 LOGGER.info("Success!");
             }else{
                 LOGGER.error("User entered a wrong quantity!");
                 req.getSession().setAttribute("errorMessage", "You entered a wrong quantity!");

             }

            return req.getContextPath() + "/controller?command=ORDER_PAGE&orderId=" + transaction.getOrder().getId()  ;
    }
}

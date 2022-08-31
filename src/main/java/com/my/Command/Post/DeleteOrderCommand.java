package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.OrderDAO;
import com.my.Model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.my.DB.DBManager.LOGGER;

public class DeleteOrderCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        LOGGER.info("User is trying to close order.");
        Order order = orderDAO.find(req.getParameter("orderId"));
        if(order!=null) {
            orderDAO.deleteOrder(order);
            LOGGER.info("Success.");
            return req.getContextPath() + "/controller?command=ORDERS_PAGE";
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

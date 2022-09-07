package com.my.command.post;

import com.my.command.ICommand;
import com.my.dao.OrderDAO;
import com.my.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.my.db.DBManager.LOGGER;

public class DeleteOrderCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        LOGGER.info("User is trying to close order.");
        Order order = orderDAO.find(req.getParameter("orderId"));
        if(order!=null) {
            orderDAO.deleteOrder(order);
            LOGGER.info("Success.");
            return req.getContextPath() + "/controller?command=ORDERS_PAGE&page=1";
        }else{
            try {
                res.sendError(HttpServletResponse.SC_NOT_FOUND);
            } catch (IOException e) {
                throw new RuntimeException("Error send");
            }
            return null;
        }
    }
}

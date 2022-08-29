package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.OrderDAO;
import com.my.Model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteOrderCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        Order order = orderDAO.findOrderById(req.getParameter("orderId"));

        orderDAO.deleteOrder(order);
        return  req.getContextPath() + "/controller?command=ORDERS_PAGE";
    }
}

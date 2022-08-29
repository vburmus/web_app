package com.my.Command.Get;

import com.my.Command.ICommand;
import com.my.DAO.OrderDAO;
import com.my.Model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderPageCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        Order order = null;
        order = orderDAO.findOrderById(String.valueOf(req.getParameter("orderId")));
        req.setAttribute("order",order);
        return "order";
    }
}

package com.my.command.get;

import com.my.command.ICommand;
import com.my.dao.OrderDAO;
import com.my.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.db.DBManager.LOGGER;

public class OrderPageCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        Order order = null;
        order = orderDAO.find(String.valueOf(req.getParameter("orderId")));
        req.setAttribute("order",order);
        LOGGER.info("Order page.");
        return "order";
    }
}

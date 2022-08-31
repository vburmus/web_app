package com.my.Command.Get;

import com.my.Command.ICommand;
import com.my.DAO.OrderDAO;
import com.my.Model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.my.DB.DBManager.LOGGER;

public class OrdersPageCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        List<Order> orders = orderDAO.getList();
        req.setAttribute("orders", orders);
        LOGGER.info("Orders page. Orders" + orders.size() + "pcs.");
        return "orders";
    }
}

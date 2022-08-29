package com.my.Command.Get;

import com.my.Command.ICommand;
import com.my.DAO.EmployeeDao;
import com.my.DAO.OrderDAO;
import com.my.Model.Employee;
import com.my.Model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OrdersPageCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        List<Order> orders = orderDAO.getOrders();
        req.setAttribute("orders", orders);
        return "orders";
    }
}

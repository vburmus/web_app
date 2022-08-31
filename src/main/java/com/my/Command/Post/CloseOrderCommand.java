package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.EmployeeDAO;
import com.my.DAO.OrderDAO;
import com.my.Model.Employee;
import com.my.Model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.DB.DBManager.LOGGER;

public class CloseOrderCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    EmployeeDAO employeeDao = new EmployeeDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        LOGGER.info("User is trying to close order.");
        Order order = (Order) req.getSession().getAttribute("nowOrder");
        if(order!=null ) {

                orderDAO.add(order);
                Employee employee = employeeDao.find(String.valueOf(order.getUsers_id()));

                employeeDao.updateEmployeeOrders(employee);
                req.getSession().removeAttribute("nowOrder");
            LOGGER.info("Success! Order " + order.getId() + "was closed!");
            } else{
            LOGGER.error("Order is empty!");
            req.getSession().setAttribute("errorMessage", "Your order is empty!");

        }
        return req.getContextPath() + "/controller?command=TRANSACTION_PAGE";

    }
}

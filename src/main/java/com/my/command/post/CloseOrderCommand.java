package com.my.command.post;

import com.my.command.ICommand;
import com.my.dao.EmployeeDAO;
import com.my.dao.OrderDAO;
import com.my.model.Employee;
import com.my.model.Order;
import com.my.services.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.my.db.DBManager.LOGGER;

public class CloseOrderCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    EmployeeDAO employeeDao = new EmployeeDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws MyException {
        HttpSession session = req.getSession();
        String errorMessagePage = "transaction";
        session.setAttribute("errorPage",errorMessagePage);
        LOGGER.info("User is trying to close order.");
        Order order = (Order) req.getSession().getAttribute("nowOrder");
        if(order!=null ) {

                orderDAO.add(order);
                Employee employee = employeeDao.find(String.valueOf(order.getUsers_id()));

                employeeDao.updateEmployeeOrders(employee);
                session.removeAttribute("nowOrder");
            LOGGER.info("Success! Order " + order.getId() + "was closed!");
            } else{
            LOGGER.error("Order is empty!");
            session.setAttribute("errorMessage", "Your order is empty!");

        }

        return req.getContextPath() + "/controller?command=TRANSACTION_PAGE";

    }
}

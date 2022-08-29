package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.EmployeeDao;
import com.my.DAO.OrderDAO;
import com.my.DAO.TransactionDAO;
import com.my.Model.Employee;
import com.my.Model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CloseOrderCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    EmployeeDao employeeDao = new EmployeeDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        Order order = (Order) req.getSession().getAttribute("nowOrder");
        if(order!=null ) {

                orderDAO.addOrder(order);
                Employee employee = employeeDao.findEmployee(order.getUsers_id());

                employeeDao.updateEmployeeOrders(employee);
                req.getSession().removeAttribute("nowOrder");
                System.out.println("#FINISH" + req.getSession().getAttribute("nowOrder"));
            } else{
            req.getSession().setAttribute("errorMessage", "Your order is emptyQ");

        }
        return req.getContextPath() + "/controller?command=TRANSACTION_PAGE";

    }
}

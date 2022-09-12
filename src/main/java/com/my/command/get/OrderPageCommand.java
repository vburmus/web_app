package com.my.command.get;

import com.my.command.ICommand;
import com.my.dao.OrderDAO;
import com.my.model.Order;
import com.my.services.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.db.DBManager.LOGGER;

public class OrderPageCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws MyException {
        if(req.getSession().getAttribute("errorPage")!=null) {
            if (!req.getSession().getAttribute("errorPage").equals("order")) {
                req.getSession().removeAttribute("errorMessage");
                req.getSession().removeAttribute("errorPage");
            }
        }
        Order order = null;
        order = orderDAO.find(String.valueOf(req.getParameter("orderId")));
        req.setAttribute("order",order);
        LOGGER.info("Order page.");
        return "order";
    }
}

package com.my.command.post;

import com.my.command.ICommand;
import com.my.dao.ItemDAO;
import com.my.model.Employee;
import com.my.model.Item;
import com.my.model.Order;
import com.my.model.Transaction;
import com.my.services.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.my.db.DBManager.LOGGER;

public class AddProductCommand implements ICommand {
   ItemDAO itemDao = new ItemDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws MyException {
        LOGGER.info("User is trying to add product.");
        HttpSession session = req.getSession();
        String itemVar = req.getParameter("item");
        Item item = itemDao.find(itemVar);
        String errorMessage = "errorMessage";
        String errorMessagePage = "transaction";
        session.setAttribute("errorPage",errorMessagePage);
        if(item==null){
            req.getSession().setAttribute(errorMessage, "You entered a wrong name!");
            LOGGER.error("User entered a wrong name!");
        }else{
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));
        if(quantity<=item.getQuantity()) {
            Employee user = (Employee) session.getAttribute("user");
            Order order = (Order) session.getAttribute("nowOrder");
            if ( order== null) {
                order = new Order(user.getId());
                session.setAttribute("nowOrder", order);
                LOGGER.info("Order was inserted in session.");
            } else {
                LOGGER.info("Order was in session.");
            }

            if(order!=null) {

                order.addTransaction(new Transaction(item, quantity, order));
                req.getSession().removeAttribute(errorMessage);
                LOGGER.info("Success!");
            }
        }else{
            req.getSession().setAttribute(errorMessage, "You entered a wrong quantity!");
            LOGGER.error("User entered a wrong quantity!");
        }
        }
         return req.getContextPath() + "/controller?command=TRANSACTION_PAGE";
    }
}

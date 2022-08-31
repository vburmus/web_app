package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.ItemDAO;
import com.my.Model.Employee;
import com.my.Model.Item;
import com.my.Model.Order;
import com.my.Model.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.my.DB.DBManager.LOGGER;

public class AddProductCommand implements ICommand {
   ItemDAO itemDao = new ItemDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        LOGGER.info("User is trying to add product.");
        HttpSession session = req.getSession();
        String itemVar = req.getParameter("item");
        Item item = itemDao.find(itemVar);
        if(item==null){
            req.getSession().setAttribute("errorMessage", "You entered a wrong name!");
            LOGGER.error("User entered a wrong name!");
        }else{
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));
        if(quantity<=item.getQuantity()) {
            Employee user = (Employee) session.getAttribute("user");
            Order order = null;
            if (session.getAttribute("nowOrder") == null) {
                order = new Order(user.getId());
                session.setAttribute("nowOrder", order);
                LOGGER.info("Order was inserted in session.");
            } else {
                order = (Order) session.getAttribute("nowOrder");
                LOGGER.info("Order was in session.");
            }


            item.setQuantity(item.getQuantity() - quantity);
            itemDao.updateItemQuantity(item);
            order.addTransaction(new Transaction(item, quantity, order));
            req.getSession().removeAttribute("errorMessage");
            LOGGER.info("Success!");
        }else{
            req.getSession().setAttribute("errorMessage", "You entered a wrong quantity!");
            LOGGER.error("User entered a wrong quantity!");
        }
        }
         return req.getContextPath() + "/controller?command=TRANSACTION_PAGE";
    }
}

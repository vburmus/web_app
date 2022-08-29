package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.ItemDao;
import com.my.DAO.OrderDAO;
import com.my.Model.Employee;
import com.my.Model.Item;
import com.my.Model.Order;
import com.my.Model.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddProductCommand implements ICommand {
   ItemDao itemDao = new ItemDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {

        HttpSession session = req.getSession();
        String itemVar = req.getParameter("item");
        Item item = ItemDao.findItem(itemVar);
        if(item==null){
            req.getSession().setAttribute("errorMessage", "You entered a wrong name!");
        }else{
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));
        if(quantity<=item.getQuantity()) {
            Employee user = (Employee) session.getAttribute("user");
            Order order = null;
            if (session.getAttribute("nowOrder") == null) {
                order = new Order(user.getId());
                session.setAttribute("nowOrder", order);
                System.out.println("#SET" + order);
            } else {
                order = (Order) session.getAttribute("nowOrder");
                System.out.println("#GET" + order);
            }


            item.setQuantity(item.getQuantity() - quantity);
            itemDao.updateItemQuantity(item);
            order.addTransaction(new Transaction(item, quantity, order));
            req.getSession().removeAttribute("errorMessage");
        }else{
            req.getSession().setAttribute("errorMessage", "You entered a wrong quantity!");

        }
        }
         return req.getContextPath() + "/controller?command=TRANSACTION_PAGE";
    }
}

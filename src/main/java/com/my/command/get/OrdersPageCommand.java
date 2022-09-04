package com.my.command.get;

import com.my.command.ICommand;
import com.my.dao.OrderDAO;
import com.my.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.my.db.DBManager.LOGGER;

public class OrdersPageCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    int offset = 4;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        int page = Integer.parseInt(req.getParameter("page"));
        double pages= orderDAO.getCountOfItems();
        pages/=offset;
        req.setAttribute("page",page);
        req.setAttribute("pages",pages );
        List<Order> orders = orderDAO.getList(offset*(page-1));
        req.setAttribute("orders", orders);
        LOGGER.info("Orders page. Orders" + orders.size() + "pcs.");
        return "orders";
    }
}

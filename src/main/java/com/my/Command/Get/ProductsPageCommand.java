package com.my.Command.Get;

import com.my.Command.ICommand;
import com.my.DAO.DBManager;
import com.my.DAO.EmployeeDao;
import com.my.DAO.ItemDao;
import com.my.Model.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ProductsPageCommand implements ICommand {
    DBManager manager = DBManager.getInstance();
    ItemDao itemDao = new ItemDao();
    int offset = 4;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        int page = Integer.parseInt(req.getParameter("page"));
        double pages= itemDao.getCount();
        pages/=offset;
        req.setAttribute("page",page);
        req.setAttribute("pages",pages );
        List<Item> items = ItemDao.getItemsList(offset*(page-1));
        req.setAttribute("items", items);
        return "products";
    }
}

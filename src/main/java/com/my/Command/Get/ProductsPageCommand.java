package com.my.Command.Get;

import com.my.Command.ICommand;
import com.my.DB.DBManager;
import com.my.DAO.ItemDAO;
import com.my.Model.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.my.DB.DBManager.LOGGER;

public class ProductsPageCommand implements ICommand {
    DBManager manager = DBManager.getInstance();
    ItemDAO itemDao = new ItemDAO();
    int offset = 4;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        int page = Integer.parseInt(req.getParameter("page"));
        LOGGER.info("Products page #" + page + "!");
        double pages= itemDao.getCountOfItems();
        pages/=offset;
        req.setAttribute("page",page);
        req.setAttribute("pages",pages );
        List<Item> items = itemDao.getList(offset*(page-1));
        req.setAttribute("items", items);
        return "products";
    }
}

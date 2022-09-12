package com.my.command.get;

import com.my.command.ICommand;
import com.my.dao.CategoryDAO;
import com.my.db.DBManager;
import com.my.dao.ItemDAO;
import com.my.model.Item;
import com.my.services.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.my.db.DBManager.LOGGER;

public class ProductsPageCommand implements ICommand {

    ItemDAO itemDao = new ItemDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    int offset = 4;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws MyException {
        if(req.getSession().getAttribute("errorPage")!=null) {
            if (!req.getSession().getAttribute("errorPage").equals("products")) {
                req.getSession().removeAttribute("errorMessage");
                req.getSession().removeAttribute("errorPage");
            }
        }
        int page = Integer.parseInt(req.getParameter("page"));
        LOGGER.info("Products page #" + page + "!");
        double pages= itemDao.getCountOfItems();
        pages/=offset;

        List<Item> items;
        if(req.getParameter("selectCategory")==null || req.getParameter("selectCategory").equals("None")) {
             items = itemDao.getList(offset * (page - 1));

        }else{
                page = 1;
                items = itemDao.getList(offset * (page - 1),req.getParameter("selectCategory"));

        }
        req.setAttribute("page",page);
        req.setAttribute("pages",pages );
        req.setAttribute("items", items);
        req.setAttribute("categories", categoryDAO.getList());
        return "products";
    }
}

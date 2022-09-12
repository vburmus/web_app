package com.my.command.get;

import com.my.command.ICommand;
import com.my.dao.CategoryDAO;
import com.my.services.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.db.DBManager.LOGGER;

public class NewProductPageCommand implements ICommand {
    CategoryDAO categoryDao = new CategoryDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws MyException {
        if(req.getSession().getAttribute("errorPage")!=null) {
            if (!req.getSession().getAttribute("errorPage").equals("newProduct")) {
                req.getSession().removeAttribute("errorMessage");
                req.getSession().removeAttribute("errorPage");
            }
        }
        req.setAttribute("categories", categoryDao.getList());
        LOGGER.info("New product page.");
        return "newProduct";
    }
}

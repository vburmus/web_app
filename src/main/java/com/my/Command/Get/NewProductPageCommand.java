package com.my.Command.Get;

import com.my.Command.ICommand;
import com.my.DAO.CategoryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.DB.DBManager.LOGGER;

public class NewProductPageCommand implements ICommand {
    CategoryDAO categoryDao = new CategoryDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        req.setAttribute("categories", categoryDao.getList());
        LOGGER.info("New product page.");
        return "newProduct";
    }
}

package com.my.command.get;

import com.my.command.ICommand;
import com.my.dao.CategoryDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.db.DBManager.LOGGER;

public class NewProductPageCommand implements ICommand {
    CategoryDAO categoryDao = new CategoryDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        req.setAttribute("categories", categoryDao.getList());
        LOGGER.info("New product page.");
        return "newProduct";
    }
}
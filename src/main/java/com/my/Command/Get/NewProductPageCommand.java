package com.my.Command.Get;

import com.my.Command.ICommand;
import com.my.DAO.CategoryDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewProductPageCommand implements ICommand {
    CategoryDao categoryDao = new CategoryDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        req.setAttribute("categories", categoryDao.getCategories());
        return "newProduct";
    }
}

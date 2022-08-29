package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.CategoryDao;
import com.my.DAO.ItemDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewCategoryCommand implements ICommand {
    CategoryDao categoryDao = new CategoryDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
         String name = req.getParameter("categoryName");
         String title = req.getParameter("categoryTitle");
         if(name==null){
             req.getSession().setAttribute("errorMessage", "Your category name is null!");
         }else{
             categoryDao.addCategory(name, title);
         }


        return  req.getContextPath() + "/controller?command=NEW_PRODUCT_PAGE";
    }
}

package com.my.command.post;

import com.my.command.ICommand;
import com.my.dao.CategoryDAO;
import com.my.model.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.db.DBManager.LOGGER;

public class NewCategoryCommand implements ICommand {
    CategoryDAO categoryDao = new CategoryDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        LOGGER.info("User is trying to add new category.");
         String name = req.getParameter("categoryName");
         String title = req.getParameter("categoryTitle");
         if(name==null){
             req.getSession().setAttribute("errorMessage", "Your category name is null!");
         }else if(categoryDao.find(name)!=null){
             req.getSession().setAttribute("errorMessage", "This category already exists!");
        }else{
             Category category = new Category();
             category.setName(name);
             category.setTitle(title);
             categoryDao.add(category);
             LOGGER.info("Success.");
         }


        return  req.getContextPath() + "/controller?command=NEW_PRODUCT_PAGE";
    }
}

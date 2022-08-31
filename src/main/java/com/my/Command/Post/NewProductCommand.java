package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.CategoryDAO;
import com.my.Model.Category;
import com.my.Model.Item;
import com.my.DAO.ItemDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

import static com.my.DB.DBManager.LOGGER;

public class NewProductCommand implements ICommand {
    private int id = 0;
    private ItemDAO itemDao;
    private CategoryDAO categoryDao = new CategoryDAO();
    public NewProductCommand(){
        this.itemDao = new ItemDAO();
    }

    @Override

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("USer is trying to make a product.");
        String name = request.getParameter("productName");
        String quantity = request.getParameter("quantity");
        String productDescription = request.getParameter("productDescription");
        String price = request.getParameter("price");
        String categoryName = request.getParameter("selectCategory");
        System.out.println("category -" + categoryName);
        if(name.equals("")||quantity.equals("")||price.equals("")){
            request.getSession().setAttribute("errorMessage", "Items parameters are wrong!");

        }else {
            Item item = new Item();
            System.out.println(request.getParameter("selectCategory"));
            if ( !categoryName.equals("")) {
                Category category = categoryDao.find(request.getParameter("selectCategory"));
                if(category!=null) {
                    item.setCategory(category);
                }
                item.setName(name);
                item.setQuantity(Integer.valueOf(quantity));
                item.setTitle(productDescription);
                item.setPrice(Float.parseFloat(price));

                try {
                    Collection<Part> parts = request.getParts();

                    String realPath = request.getServletContext().getRealPath("assets/img/items");
                    String fileName = null;
                    for (Part part : parts) {
                        try {

                            if (part.getSubmittedFileName() != null) {

                                fileName = "item_" + id++ + "_" + part.getSubmittedFileName();
                                part.write(realPath + "\\" + fileName);

                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (fileName == null) {
                        fileName = "default.png";
                    }
                    item.setPhoto(fileName);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                this.itemDao.add(item);
                LOGGER.info("Success.");
            }else{
                request.getSession().setAttribute("errorMessage", "Category is wrong!");

            }
        }
        return request.getContextPath() + "/controller?command=NEW_PRODUCT_PAGE";
    }
}

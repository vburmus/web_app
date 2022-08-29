package com.my.DAO;

import com.my.Model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.my.DAO.DB.Constants.*;

public class CategoryDao {
    DBManager manager = DBManager.getInstance();
    public void addCategory(String name, String title){
        try(Connection con = manager.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_ADD_CATEGORY)) {
            ps.setString(1,name);
            ps.setString(2,title);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Category>  getCategories() {
        List<Category> categories = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = manager.getRSFromSql(SQL_SELECT_CATEGORIES);
            while (rs.next()) {
                categories.add(extractCategory(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
    public  Category extractCategory(ResultSet rs) {
        Category category = new Category();
        try {
            category.setId(rs.getInt(1));
            category.setName(rs.getString(2));
            category.setTitle(rs.getString(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }
    public Category findCategory(String category){
        Category extractedCategory = null;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            con = manager.getConnection();
            try {
                int id = Integer.parseInt(category);
                preparedStatement = con.prepareStatement(SQL_SELECT_CATEGORY_BY_ID);
                preparedStatement.setInt(1, id);
            }catch (NumberFormatException e){
                preparedStatement = con.prepareStatement(SQL_SELECT_CATEGORY_BY_NAME);
                preparedStatement.setString(1,category);
            }
            rs = preparedStatement.executeQuery();

            if(rs.next()){
                extractedCategory = extractCategory(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            manager.close(con);
            manager.close(preparedStatement);
            manager.close(rs);
        }
        return extractedCategory;

    }
}

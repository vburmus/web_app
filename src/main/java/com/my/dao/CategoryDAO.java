package com.my.dao;

import com.my.db.DBManager;
import com.my.model.Category;
import com.my.services.exception.MyException;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.my.db.Constants.*;
import static com.my.db.DBManager.LOGGER;

public class CategoryDAO implements IDAO<Category>{
    private DBManager manager;
    public CategoryDAO() {
        manager = DBManager.getInstance();
    }
    public CategoryDAO(boolean test) {
        manager = DBManager.getTestInstance();
    }

    public void add(@NotNull Category category) throws MyException {
        LOGGER.info("Adding category..");
        try(Connection con = manager.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_ADD_CATEGORY,PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1,category.getName());
            ps.setString(2, category.getTitle());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
                category.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new MyException();
        }
    }

    public List<Category> getList() throws MyException {
        LOGGER.info("Getting categories...");
        List<Category> categories = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = manager.getRSFromSql(SQL_SELECT_CATEGORIES);
            while (rs.next()) {
                categories.add(extract(rs));
            }
        } catch (SQLException | MyException e) {
            throw new MyException();
        }
        return categories;
    }

    public List getList(int offset) {
        return null;
    }

    public  Category extract(@NotNull ResultSet rs) throws MyException {
        Category category = new Category();
        try {
            category.setId(rs.getInt(1));
            category.setName(rs.getString(2));
            category.setTitle(rs.getString(3));
        } catch (SQLException e) {
            throw new MyException();
        }
        return category;
    }

    public Category find(String category) throws MyException {
        LOGGER.info("Finding category...");
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
                extractedCategory = extract(rs);
            }
        } catch (SQLException  e) {
            throw new MyException();
        }finally{
            manager.close(con);
            manager.close(preparedStatement);
            manager.close(rs);
        }
        return extractedCategory;

    }
}

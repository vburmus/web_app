package com.my.dao;

import com.my.db.DBManager;
import com.my.model.Category;
import com.my.services.exception.MyException;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryDAOTest {
    CategoryDAO categoryDAO = new CategoryDAO(true);

    @BeforeEach
     void clearTable(){
        DBManager dbManager = DBManager.getTestInstance();
        dbManager.clearTable("items_has_transaction");
        dbManager.clearTable("order_has_transaction");
        dbManager.clearTable("category_has_items");
        dbManager.clearTable("category");
        dbManager.clearTable("items");
        dbManager.clearTable("transaction");
        dbManager.clearTable("orders");
        dbManager.clearTable("users");
    }
    @Test
    void addAndFindProduct() throws SQLException, NamingException, MyException {
            Category category = new Category();
            category.setName("name");
            category.setTitle("asdf");
            categoryDAO.add(category);
            Category foundCategory = categoryDAO.find("name");
            Assertions.assertEquals(category.getName(), foundCategory.getName());
            Assertions.assertEquals(category.getTitle(), foundCategory.getTitle());
    }

    @Test
    void getList() throws MyException {
        ArrayList<Category> categories = new ArrayList<>();

        for(int i = 0;i < 10;i++) {
            Category category = new Category("name" + i, "title");
            categoryDAO.add(category);
            categories.add(category);
        }
        Category storedCategory =null;
        Category foundCategory =null;
        List<Category> foundCategories = categoryDAO.getList();
        for(int i = 0; i < 10;i++){
            storedCategory = categories.get(i);
            foundCategory = foundCategories.get(i);
            Assertions.assertEquals(storedCategory.getName(), foundCategory.getName());
            Assertions.assertEquals(storedCategory.getTitle(), foundCategory.getTitle());
        }
    }



}
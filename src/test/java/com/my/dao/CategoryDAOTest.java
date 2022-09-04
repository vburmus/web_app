package com.my.dao;

import com.my.db.DBManager;
import com.my.model.Category;
import org.junit.jupiter.api.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryDAOTest {


    @Test
    void addProduct() throws SQLException, NamingException {
        Context context = mock(InitialContext.class);
        Context context1 = new InitialContext();
        DataSource ds = (DataSource)context1.lookup("java:comp/env/jdbc/test_db") ;
        when(context.lookup("java:comp/env/jdbc/my_db")).thenReturn(ds);
        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = new Category();
        category.setName("name");
        category.setTitle("asdf");
        categoryDAO.add(category);
    }

    @Test
    void getList() {
    }

    @Test
    void testGetList() {
    }

    @Test
    void extract() {
    }

    @Test
    void find() {
    }
}
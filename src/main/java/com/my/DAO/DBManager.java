package com.my.DAO;

import com.my.DAO.DB.UserKeys;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

    private static DBManager instance;
    private DataSource ds;

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
        try {

            Context context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/my_db");
            System.out.println("DS ====> " + ds);
            System.out.println(UserKeys.ID.ordinal());
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    //END_OF_SINGLETON

    public Connection getConnection() {
        Connection con = null;
        try {
            con = ds.getConnection();
            System.out.println(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

    public ResultSet getRSFromSql(String query) {
        ResultSet rs = null;
        Connection connection = getConnection();
        try {

            rs = connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            close(connection);
            close(rs);
        }
        return rs;
    }
    public void close(AutoCloseable con){
        if(con!=null) {
            try {
                con.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


}


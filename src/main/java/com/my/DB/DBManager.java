package com.my.DB;


import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
    public final static Logger LOGGER = Logger.getLogger(DBManager.class);
    private static DBManager instance;
    private DataSource ds;

    /**
     * This method is a main singleton method
     * @return An instance of DBManager
     */
    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    /**
     * This is a constructor for DBManager,which initialise DataSource from context
     */
    private DBManager() {
        try {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/my_db");
            LOGGER.info("DataSource was made.");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    //END_OF_SINGLETON

    /**
     * This method is used to get Connection from DataSource
     * @return Connection
     */
    public Connection getConnection() {
        Connection con = null;
        try {
            con = ds.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

    /**
     * This method returns rs from SQL SELECT query
     * @param query
     * @return
     */
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


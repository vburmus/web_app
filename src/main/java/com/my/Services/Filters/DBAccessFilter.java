
package com.my.Services.Filters;

import com.my.DAO.DBManager;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public class DBAccessFilter implements Filter {
    Connection con;
    ServletContext ctx;
    DBManager dbManager = DBManager.getInstance();
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        boolean access = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("#Access");
            con = dbManager.getConnection();
            ctx = req.getServletContext();
            if(con!=null)
                access=true;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            dbManager.close(con);
        }
            request.getServletContext().setAttribute("access", access);
        if(access){
           chain.doFilter(request, response);
        }else{
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request,response);
        }

    }
}


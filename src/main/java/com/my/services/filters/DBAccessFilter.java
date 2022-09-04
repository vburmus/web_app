
package com.my.services.filters;

import com.my.db.DBManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import static com.my.db.DBManager.LOGGER;

public class DBAccessFilter implements Filter {
    Connection con;
    ServletContext ctx;
    DBManager dbManager = DBManager.getInstance();


    /**
     * This filters checks the access to database
     * @param request  the <code>ServletRequest</code> object contains the client's request
     * @param response the <code>ServletResponse</code> object contains the filter's response
     * @param chain    the <code>FilterChain</code> for invoking the next filter or the resource
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        boolean access = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            LOGGER.info("Checking access...");
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
            LOGGER.info("Access true");
           chain.doFilter(request, response);
        }else{
            LOGGER.info("Access denied");
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request,response);
        }

    }
}


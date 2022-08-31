package com.my.Services.Filters;

import com.my.DB.DBManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

import static com.my.DB.DBManager.LOGGER;


public class MainPageFilter implements Filter {


    /**
     * This method forwards to the main page
     * @param request  the <code>ServletRequest</code> object contains the client's request
     * @param response the <code>ServletResponse</code> object contains the filter's response
     * @param chain    the <code>FilterChain</code> for invoking the next filter or the resource
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request,response);
        LOGGER.info("Index page.");

        chain.doFilter(request,response);
    }
}

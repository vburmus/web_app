package com.my.Services.Filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;


public class MainPageFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request,response);
        chain.doFilter(request,response);
    }
}

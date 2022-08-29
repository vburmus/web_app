package com.my.Command.FrontController;

import com.my.Command.CommandFactory;
import com.my.Command.IFilterCommand;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/controller")
public class FrontFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("#doFilter");

        handleFilter((HttpServletRequest) request, (HttpServletResponse) response);
        chain.doFilter(request, response);
    }
    private void handleFilter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IFilterCommand iFilterCommand = CommandFactory.getFilter(req,resp);
        boolean pageAccess = iFilterCommand.getAccess(req,resp);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("pageAccess",pageAccess);
    }
}

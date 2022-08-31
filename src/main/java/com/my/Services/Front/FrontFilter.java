package com.my.Services.Front;

import com.my.Command.CommandFactory;
import com.my.Command.IFilterCommand;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.my.DB.DBManager.LOGGER;

@WebFilter("/controller")
public class FrontFilter implements Filter {

    /**
     * Method which use filter commands to build a filter
     * @param request  the <code>ServletRequest</code> object contains the client's request
     * @param response the <code>ServletResponse</code> object contains the filter's response
     * @param chain    the <code>FilterChain</code> for invoking the next filter or the resource
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        LOGGER.info("#DoFilter");

        handleFilter((HttpServletRequest) request, (HttpServletResponse) response);
        chain.doFilter(request, response);
    }

    /**
     * this method is used to handle filter commands
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void handleFilter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IFilterCommand iFilterCommand = CommandFactory.getFilter(req,resp);
        boolean pageAccess = iFilterCommand.getAccess(req,resp);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("pageAccess",pageAccess);
    }
}

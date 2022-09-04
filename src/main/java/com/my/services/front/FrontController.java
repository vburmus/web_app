package com.my.services.front;

import com.my.command.CommandFactory;
import com.my.command.ICommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.my.db.DBManager.LOGGER;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
@WebServlet("/controller")
public class FrontController extends HttpServlet{

    /**
     * Realises all commands with doGet
     * @param req  an {@link HttpServletRequest} object that
     *             contains the request the client has made
     *             of the servlet
     * @param resp an {@link HttpServletResponse} object that
     *             contains the response the servlet sends
     *             to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("#GET");

            boolean pageAccess = (boolean) req.getSession().getAttribute("pageAccess");
            String forward = "/WEB-INF/view/" +handleRequest(req, resp) ;
            if (pageAccess) {
                req.getRequestDispatcher(forward + ".jsp").forward(req, resp);
            }

    }

    /**
     * Realises all commands with doPost
     * @param req  an {@link HttpServletRequest} object that
     *             contains the request the client has made
     *             of the servlet
     * @param resp an {@link HttpServletResponse} object that
     *             contains the response the servlet sends
     *             to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("#POST");
        String redirect = handleRequest(req, resp);
        resp.sendRedirect(redirect);

    }

    /**
     * Method is used to handle request and to find a command
     * @param req
     * @param resp
     * @return
     */
    private String handleRequest(HttpServletRequest req, HttpServletResponse resp){
        ICommand iCommand = CommandFactory.getCommand(req,resp);
        return iCommand.execute(req,resp);
    }
}
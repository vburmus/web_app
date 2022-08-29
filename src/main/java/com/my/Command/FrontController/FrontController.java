package com.my.Command.FrontController;

import com.my.Command.CommandFactory;
import com.my.Command.ICommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
@WebServlet("/controller")
public class FrontController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("#doGet");
        String forward = "/WEB-INF/view/" +handleRequest(req, resp) ;
        req.getRequestDispatcher(forward + ".jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("#doPost");
        String redirect = handleRequest(req, resp);
        resp.sendRedirect(redirect);

    }
    private String handleRequest(HttpServletRequest req, HttpServletResponse resp){
        ICommand iCommand = CommandFactory.getCommand(req,resp);
        return iCommand.execute(req,resp);
    }
}
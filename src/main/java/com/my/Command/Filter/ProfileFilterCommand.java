package com.my.Command.Filter;

import com.my.Command.IFilterCommand;
import com.my.Model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.my.DB.DBManager.LOGGER;
/**
 * This filter is made to check, if user is logged in or not
 */
public class ProfileFilterCommand implements IFilterCommand {
    @Override
    public boolean getAccess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Employee employee = (Employee) httpSession.getAttribute("user");
        if(employee==null){
            LOGGER.warn("To have access to this page, user must sign in.");
            res.sendRedirect(req.getContextPath() + "/controller?command=LOGIN_PAGE");
            return false;
        }else {
            LOGGER.info("User have access to this page.");
            return true;
        }
    }
}

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
 * This filter is made to check, if user has logged in or not
 */
public class LoginFilterCommand implements IFilterCommand {


    @Override
    public boolean getAccess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Employee employee = (Employee) httpSession.getAttribute("user");
        if(employee!=null){
            LOGGER.warn("User" + employee.getEmail() + "has already logged in.");
            res.sendRedirect(req.getContextPath() + "/controller?command=PROFILE_PAGE");
           return false;
        }else{
            LOGGER.warn("User has access to page.");
            return true;
        }
    }
}

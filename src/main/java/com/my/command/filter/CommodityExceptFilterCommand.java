package com.my.command.filter;

import com.my.command.IFilterCommand;
import com.my.db.Fields;
import com.my.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.my.db.DBManager.LOGGER;

/**
 * If users role is commodity expert, then access is opened, else - denied
 */
public class CommodityExceptFilterCommand implements IFilterCommand {

    @Override
    public boolean getAccess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Employee employee = (Employee) httpSession.getAttribute("user");
        if(employee==null ) {
            LOGGER.warn("To have access to this page, user must sign in.");
            res.sendRedirect(req.getContextPath() + "/controller?command=LOGIN_PAGE");
            return false;
        }
        /*else if (employee.getRole()== Fields.COMMODITY_EXERT){
            LOGGER.warn("To have access to this page, user must be CASHIER.");
            res.sendRedirect(req.getContextPath() + "/controller?command=PROFILE_PAGE");
            return false;
        }*/else {
            LOGGER.info("User have access to this page.");
            return true;
        }
    }
}

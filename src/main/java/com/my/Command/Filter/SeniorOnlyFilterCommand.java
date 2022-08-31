package com.my.Command.Filter;

import com.my.Command.IFilterCommand;
import com.my.DB.Fields;
import com.my.Model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.my.DB.DBManager.LOGGER;
/**
 * This filter is made to check, if user has role - Senior
 */
public class SeniorOnlyFilterCommand implements IFilterCommand {
    @Override
    public boolean getAccess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Employee employee = (Employee) httpSession.getAttribute("user");
        if(employee==null ) {
            LOGGER.warn("To have access to this page, user must sign in.");
            res.sendRedirect(req.getContextPath() + "/controller?command=LOGIN_PAGE");

            return false;
        }
        else if (employee.getRole()!= Fields.SENIOR_CASHIER){
            LOGGER.warn("To have access to this page, user must be SENIOR_CASHIER.");
            res.sendRedirect(req.getContextPath() + "/controller?command=PROFILE_PAGE");
            return false;
        }else {
            LOGGER.info("User have access to this page.");
            return true;
        }
}
}

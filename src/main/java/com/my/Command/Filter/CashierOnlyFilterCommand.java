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
 * If users role is cashier, then access is opened, else - denied
 */
public class CashierOnlyFilterCommand implements IFilterCommand {

    @Override
    public boolean getAccess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Employee employee = (Employee) httpSession.getAttribute("user");
        if(employee==null ) {
            res.sendRedirect(req.getContextPath() + "/controller?command=LOGIN_PAGE");
            LOGGER.warn("To have access to this page, user must sign in.");
            return false;
        }
        else if (employee.getRole()!= Fields.CASHIER){
            res.sendRedirect(req.getContextPath() + "/controller?command=PROFILE_PAGE");
            LOGGER.warn("To have access to this page, user must be CASHIER.");
            return false;
        }else {
            LOGGER.info("User has access to page.");
            return true;
        }
        }

}

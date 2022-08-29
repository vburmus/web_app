package com.my.Command.doFilter;

import com.my.Command.ICommand;
import com.my.Command.IFilterCommand;
import com.my.Model.Employee;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilterCommand implements IFilterCommand {


    @Override
    public boolean getAccess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Employee employee = (Employee) httpSession.getAttribute("user");
        if(employee!=null){
            res.sendRedirect(req.getContextPath() + "/controller?command=PROFILE_PAGE");
           return false;
        }
        return true;
    }
}

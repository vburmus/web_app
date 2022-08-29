package com.my.Command.Get;

import com.my.Command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        if((boolean)req.getSession().getAttribute("pageAccess")) {
            req.getSession().invalidate();
            return "index";
        }else{
            return "login";
        }
    }
}

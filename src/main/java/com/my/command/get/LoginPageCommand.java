package com.my.command.get;

import com.my.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.db.DBManager.LOGGER;

public class LoginPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        if(req.getSession().getAttribute("errorPage")!=null) {
            if (!req.getSession().getAttribute("errorPage").equals("login")) {
                req.getSession().removeAttribute("errorMessage");
                req.getSession().removeAttribute("errorPage");
            }
        }
        LOGGER.info("Login page.");
        return "login";
    }
}

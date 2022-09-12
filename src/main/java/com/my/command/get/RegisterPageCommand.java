package com.my.command.get;

import com.my.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.db.DBManager.LOGGER;

public class RegisterPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        if(req.getSession().getAttribute("errorPage")!=null) {
            if (!req.getSession().getAttribute("errorPage").equals("register")) {
                req.getSession().removeAttribute("errorMessage");
                req.getSession().removeAttribute("errorPage");
            }
        }
        LOGGER.info("Register page.");
        return "register";
    }
}

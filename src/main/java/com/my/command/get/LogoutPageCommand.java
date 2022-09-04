package com.my.command.get;

import com.my.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.db.DBManager.LOGGER;

public class LogoutPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        if((boolean)req.getSession().getAttribute("pageAccess")) {
            LOGGER.info(req.getSession().getId() + "session was removed!");
            req.getSession().invalidate();
            return "index";
        }else{
            return "login";
        }
    }
}

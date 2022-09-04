package com.my.command.post;

import com.my.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LangSetUpCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {

        String referer = req.getHeader("referer");
        String replace = referer.replace("http://localhost:8080/cashregister", "");
        req.getSession().setAttribute("locale", req.getParameter("lang"));
        return req.getContextPath() + replace;
    }
}

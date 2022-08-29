package com.my.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    public interface ICommand {
        String execute(HttpServletRequest req, HttpServletResponse res);

    }


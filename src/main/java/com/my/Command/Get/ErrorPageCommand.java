package com.my.Command.Get;

import com.my.Command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        return "error";
    }
}

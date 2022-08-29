package com.my.Command.doFilter;

import com.my.Command.IFilterCommand;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorFilterCommand implements IFilterCommand {
    @Override
    public boolean getAccess(HttpServletRequest req, HttpServletResponse res) {
        return true;
    }
}

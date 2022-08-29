package com.my.Command.doFilter;

import com.my.Command.IFilterCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductsFilterCommand implements IFilterCommand {
    @Override
    public boolean getAccess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        return true;
    }
}

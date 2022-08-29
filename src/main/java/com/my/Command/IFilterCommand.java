package com.my.Command;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IFilterCommand {

     boolean getAccess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;

}


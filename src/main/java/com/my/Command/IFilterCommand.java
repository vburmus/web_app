package com.my.Command;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IFilterCommand {
     /**
      * This filter method must give or not give
      * access to visit pages.
      * If user in session equals to null,
      * then method send user to login page,
      * else open access or close.
      */
     boolean getAccess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;

}


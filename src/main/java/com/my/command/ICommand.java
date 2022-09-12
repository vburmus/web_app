package com.my.command;

import com.my.services.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    public interface ICommand {
        /**
         * This method is made to choose command for front controller
         */
        String execute(HttpServletRequest req, HttpServletResponse res) throws MyException;

    }


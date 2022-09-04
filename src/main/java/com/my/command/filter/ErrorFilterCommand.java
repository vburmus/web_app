package com.my.command.filter;

import com.my.command.IFilterCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.db.DBManager.LOGGER;

/**
 * Filter for error page
 */
public class ErrorFilterCommand implements IFilterCommand {

    @Override
    public boolean getAccess(HttpServletRequest req, HttpServletResponse res) {
            LOGGER.error("An error has occurred!");
        return true;
    }
}

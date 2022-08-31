package com.my.Command.Filter;

import com.my.Command.IFilterCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.DB.DBManager.LOGGER;

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

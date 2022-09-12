package com.my.command.filter;

import com.my.command.IFilterCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.my.db.DBManager.LOGGER;


/**
 * If users role is admin, then access is opened, else - denied
 */
public class LangFilterCommand implements IFilterCommand {

    @Override
    public boolean getAccess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            LOGGER.info("Language has been changed.");
            return true;
    }
}

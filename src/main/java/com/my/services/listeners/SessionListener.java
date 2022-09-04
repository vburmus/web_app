package com.my.services.listeners;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

import static com.my.db.DBManager.LOGGER;

@WebListener
public class SessionListener implements  HttpSessionListener{
    public void
    sessionCreated(HttpSessionEvent sessionEvent)
    {
        LOGGER.info(
                "Session Created:: ID="
                        + sessionEvent.getSession().getId());
    }
    public void
    sessionDestroyed(HttpSessionEvent sessionEvent)
    {
        LOGGER.info(
                "Session Destroyed:: ID="
                        + sessionEvent.getSession().getId());
    }

}

package com.my.Services.Listeners;

import javax.servlet.*;
import javax.servlet.annotation.*;

import static com.my.DB.DBManager.LOGGER;

@WebListener
public class AppContextListener implements ServletContextAttributeListener {
    public void
    attributeAdded(ServletContextAttributeEvent
                           servletContextAttributeEvent)
    {
        LOGGER.info(
                "ServletContext attribute added::{"
                        + servletContextAttributeEvent.getName() + ","
                        + servletContextAttributeEvent.getValue()
                        + "}");
    }
    public void
    attributeReplaced(ServletContextAttributeEvent
                              servletContextAttributeEvent)
    {
        LOGGER.info(
                "ServletContext attribute replaced::{"
                        + servletContextAttributeEvent.getName() + ","
                        + servletContextAttributeEvent.getValue()
                        + "}");
    }
    public void
    attributeRemoved(ServletContextAttributeEvent
                             servletContextAttributeEvent)
    {
        LOGGER.info(
                "ServletContext attribute removed::{"
                        + servletContextAttributeEvent.getName() + ","
                        + servletContextAttributeEvent.getValue()
                        + "}");
    }

}

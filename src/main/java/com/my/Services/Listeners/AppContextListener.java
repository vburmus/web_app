package com.my.Services.Listeners;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class AppContextListener implements ServletContextAttributeListener {
    public void
    attributeAdded(ServletContextAttributeEvent
                           servletContextAttributeEvent)
    {
        System.out.println(
                "ServletContext attribute added::{"
                        + servletContextAttributeEvent.getName() + ","
                        + servletContextAttributeEvent.getValue()
                        + "}");
    }
    public void
    attributeReplaced(ServletContextAttributeEvent
                              servletContextAttributeEvent)
    {
        System.out.println(
                "ServletContext attribute replaced::{"
                        + servletContextAttributeEvent.getName() + ","
                        + servletContextAttributeEvent.getValue()
                        + "}");
    }
    public void
    attributeRemoved(ServletContextAttributeEvent
                             servletContextAttributeEvent)
    {
        System.out.println(
                "ServletContext attribute removed::{"
                        + servletContextAttributeEvent.getName() + ","
                        + servletContextAttributeEvent.getValue()
                        + "}");
    }

}

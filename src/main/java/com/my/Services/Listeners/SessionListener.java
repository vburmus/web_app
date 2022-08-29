package com.my.Services.Listeners;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class SessionListener implements  HttpSessionListener{
    public void
    sessionCreated(HttpSessionEvent sessionEvent)
    {
        System.out.println(
                "Session Created:: ID="
                        + sessionEvent.getSession().getId());
    }
    public void
    sessionDestroyed(HttpSessionEvent sessionEvent)
    {
        System.out.println(
                "Session Destroyed:: ID="
                        + sessionEvent.getSession().getId());
    }
}

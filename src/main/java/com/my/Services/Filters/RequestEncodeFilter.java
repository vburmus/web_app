package com.my.Services.Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;



public class RequestEncodeFilter implements Filter
{
    //FilterConfig object
    private FilterConfig filterConfig=null;

    //Default constructor
    public RequestEncodeFilter()
    {
        System.out.println("Request response encoder Filter object has been created");
    }

    //Intitialization method
    public void init(FilterConfig filterConfig)
    {
        this.filterConfig=filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        //Setting the character set for the request
        request.setCharacterEncoding("UTF-8");

        // pass the request on
        chain.doFilter(request, response);

        //Setting the character set for the response
        response.setContentType("text/html; charset=UTF-8");
    }

    public void destroy() {
        this.filterConfig=null;
    }
}
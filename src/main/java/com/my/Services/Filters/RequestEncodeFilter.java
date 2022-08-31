package com.my.Services.Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import static com.my.DB.DBManager.LOGGER;


public class RequestEncodeFilter implements Filter
{

    private FilterConfig filterConfig=null;

    /**
     *Default constructor
     */

    public RequestEncodeFilter()
    {
        LOGGER.info("Request response encoder Filter object has been created");
    }


    /**
     * Initialise method
     * @param filterConfig a <code>FilterConfig</code> object containing the
     *                     filter's configuration and initialization parameters
     */
    @Override
    public void init(FilterConfig filterConfig)
    {
        this.filterConfig=filterConfig;
    }

    /**
     * Method which sets the encoding to UTF-8
     * @param request  the <code>ServletRequest</code> object contains the client's request
     * @param response the <code>ServletResponse</code> object contains the filter's response
     * @param chain    the <code>FilterChain</code> for invoking the next filter or the resource
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        //Setting the character set for the request
        request.setCharacterEncoding("UTF-8");

        // pass the request on
        chain.doFilter(request, response);

        //Setting the character set for the response
        response.setContentType("text/html; charset=UTF-8");
    }

    /**
     * Destroy method
     */
    public void destroy() {
        this.filterConfig=null;
    }
}
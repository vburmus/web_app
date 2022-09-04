package com.my.command;

import com.my.command.enums.FilterEnum;
import com.my.command.enums.PageEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandFactory {
    /**
     * Command factory constructor
     */
    private CommandFactory(){}
    /**
     * Method getCommand() is used to find command in PageEnum.
     * @params req - httpServletRequest
     * @params resp - httpServletResponse
     *
     */
    public static ICommand getCommand(HttpServletRequest req, HttpServletResponse resp){
        String command = req.getParameter("command");
        ICommand iCommand = null;
        if(command!=null){
            try{
                iCommand = PageEnum.valueOf(command).getCommand();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                iCommand = PageEnum.ERROR_PAGE.getCommand();
            }
        }
        else
            iCommand = PageEnum.ERROR_PAGE.getCommand();
        return iCommand;
    }
    /**
     * Method getFilter() is used to find command in FilterEnum.
     * @params req - httpServletRequest
     * @params resp - httpServletResponse
     *
     */
    public static IFilterCommand getFilter(HttpServletRequest req, HttpServletResponse resp){
        String command = req.getParameter("command");
        IFilterCommand iFilterCommand = null;
        if(command!=null){
            try{
                iFilterCommand = FilterEnum.valueOf(command).getCommand();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                iFilterCommand = FilterEnum.ERROR_PAGE.getCommand();
            }
        }
        else
            iFilterCommand = FilterEnum.ERROR_PAGE.getCommand();
        return iFilterCommand;
    }

}

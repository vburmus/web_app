package com.my.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandFactory {
    private CommandFactory(){}
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

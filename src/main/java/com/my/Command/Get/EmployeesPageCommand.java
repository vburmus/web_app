package com.my.Command.Get;

import com.my.Command.ICommand;
import com.my.DAO.EmployeeDao;
import com.my.DAO.DBManager;
import com.my.Model.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EmployeesPageCommand implements ICommand {
    DBManager manager = DBManager.getInstance();
    EmployeeDao employeeDao = new EmployeeDao();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        int page = Integer.parseInt(req.getParameter("page"));

       req.setAttribute("page",page);
       req.setAttribute("pages", employeeDao.getCountOfUsers());
        Employee employee = employeeDao.getEmployee((page-1));

        List<String> roles = employeeDao.getRoles();

        req.setAttribute("employee", employee );
        req.setAttribute("roles", roles );
        return "employees";
    }
}

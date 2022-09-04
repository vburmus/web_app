package com.my.command.get;

import com.my.command.ICommand;
import com.my.dao.EmployeeDAO;
import com.my.db.DBManager;
import com.my.model.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.my.db.DBManager.LOGGER;
public class EmployeesPageCommand implements ICommand {
    DBManager manager = DBManager.getInstance();
    EmployeeDAO employeeDao = new EmployeeDAO();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        int page = Integer.parseInt(req.getParameter("page"));
        LOGGER.info("Employees page #" + page + "!");
        req.setAttribute("page",page);
        req.setAttribute("pages", employeeDao.getCountOfUsers());
        Employee employee = employeeDao.getEmployee((page-1));

        List<String> roles = employeeDao.getList();

        req.setAttribute("employee", employee );
        req.setAttribute("roles", roles );

        return "employees";
    }
}

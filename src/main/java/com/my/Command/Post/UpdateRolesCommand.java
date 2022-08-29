package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.DB.Constants;
import com.my.DAO.DBManager;
import com.my.DAO.EmployeeDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UpdateRolesCommand implements ICommand {
EmployeeDao employeeDao = new EmployeeDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String role = req.getParameter("selectRole");
        String email = req.getParameter("email");
        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(Constants.SQL_UPDATE_ROLES);
        ) {
            List<String> roles = employeeDao.getRoles();
            int insertionIndex = roles.indexOf(role) +1;
            ps.setInt(1,insertionIndex);
            ps.setString(2,email);
            ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  req.getContextPath() + "/controller?command=EMPLOYEES_PAGE&page=" + req.getParameter("page");
    }
}

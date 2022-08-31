package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DB.Constants;
import com.my.DB.DBManager;
import com.my.DAO.EmployeeDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.my.DB.DBManager.LOGGER;

public class UpdateRolesCommand implements ICommand {
EmployeeDAO employeeDao = new EmployeeDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        LOGGER.info("User is trying to update roles");
        String role = req.getParameter("selectRole");
        String email = req.getParameter("email");
        try(Connection con = DBManager.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(Constants.SQL_UPDATE_ROLES);
        ) {
            List<String> roles = employeeDao.getList();
            int insertionIndex = roles.indexOf(role) +1;
            ps.setInt(1,insertionIndex);
            ps.setString(2,email);
            ps.executeUpdate();

            LOGGER.info("Success.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  req.getContextPath() + "/controller?command=EMPLOYEES_PAGE&page=" + req.getParameter("page");
    }
}

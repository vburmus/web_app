package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DB.DBManager;
import com.my.DAO.EmployeeDAO;
import com.my.Model.Employee;
import com.my.Model.Passwords.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.my.DB.DBManager.LOGGER;

public class LoginCommand implements ICommand {
    EmployeeDAO employeeDao = new EmployeeDAO();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("User is trying to log in.");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(email.equals("")||password.equals("")){
            request.getSession().setAttribute("errorMessage", "Your email or password is null!");
            return request.getContextPath() + "/controller?command=LOGIN_PAGE";
        }else {
            HttpSession hs = request.getSession();
            ResultSet rs = null;
            try {

                rs = DBManager.getInstance().getRSFromSql("SELECT * FROM users WHERE email ='" + email + "'");
                String dbPasssword = null;
                try {
                    if (rs.next())
                        dbPasssword = rs.getString(6);
                } catch (SQLException e) {
                    e.printStackTrace();
                   }
                if(dbPasssword==null){
                    request.getSession().setAttribute("errorMessage", "No such user found!");
                    return request.getContextPath() + "/controller?command=LOGIN_PAGE";
                }
                boolean validatedPassword = Validation.validatePassword(password, dbPasssword);
                if (validatedPassword) {
                    Employee employee = employeeDao.extract(rs);
                    hs.setAttribute("user", employee);
                    System.out.println(hs.getAttribute("user"));
                    LOGGER.info("Success.");
                    return request.getContextPath() + "/controller?command=PROFILE_PAGE";
                } else {
                    request.getSession().setAttribute("errorMessage", "Your password is wrong!");

                    return request.getContextPath() + "/controller?command=LOGIN_PAGE";
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        }

}

package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.DBManager;
import com.my.DAO.EmployeeDao;
import com.my.Model.Employee;
import com.my.Passwords.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginCommand implements ICommand {
    EmployeeDao employeeDao = new EmployeeDao();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

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
                    Employee employee = employeeDao.extractEmployee(rs);
                    hs.setAttribute("user", employee);
                    System.out.println(hs.getAttribute("user"));
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

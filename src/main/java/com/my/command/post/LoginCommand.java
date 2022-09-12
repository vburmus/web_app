package com.my.command.post;

import com.my.command.ICommand;
import com.my.db.DBManager;
import com.my.dao.EmployeeDAO;
import com.my.model.Employee;
import com.my.model.password.Validation;
import com.my.services.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.my.db.DBManager.LOGGER;

public class LoginCommand implements ICommand {
    EmployeeDAO employeeDao = new EmployeeDAO();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws MyException {
        LOGGER.info("User is trying to log in.");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String errorMessage = "errorMessage";
        String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";
        String loginPath = request.getContextPath() + "/controller?command=LOGIN_PAGE";
        request.getSession().setAttribute("errorPage", "login");
        if(email.equals("")||password.equals("")){
            request.getSession().setAttribute(errorMessage, "Your email or password is null!");


            return loginPath;
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
                    request.getSession().setAttribute(errorMessage, "No such user found!");
                    return loginPath;
                }
                boolean validatedPassword = Validation.validatePassword(password, dbPasssword);
                if (validatedPassword) {
                    Employee employee = employeeDao.extract(rs);
                    hs.setAttribute("user", employee);
                    LOGGER.info("Success.");
                     return profilePath;
                } else {
                    request.getSession().setAttribute(errorMessage, "Your password is wrong!");
                    return loginPath;
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new MyException();
            }
        }
        }

}

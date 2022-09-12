package com.my.command.post;

import com.my.command.ICommand;
import com.my.dao.EmployeeDAO;
import com.my.model.Employee;
import com.my.model.password.KeyDerivator;
import com.my.services.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collection;

import static com.my.db.DBManager.LOGGER;

public class RegisterCommand implements ICommand {
    private EmployeeDAO employeeDao;

    public RegisterCommand() {
        this.employeeDao = new EmployeeDAO();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws MyException {
        LOGGER.info("User is trying to register.");
        String name = request.getParameter("name");
        System.out.println(name);
        System.out.println(request.getCharacterEncoding());
        String surname = request.getParameter("surname");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String text = request.getParameter("text");
        request.getSession().setAttribute("errorPage", "register");

        if (name.equals("") || surname.equals("") || email.equals("") || mobile.equals("") || password.equals("")) {

            request.getSession().setAttribute("errorMessage", "You entered wrong parameters!");
            return request.getContextPath() + "/controller?command=REGISTER_PAGE";
        }else if(employeeDao.find(email)!=null){
            request.getSession().setAttribute("errorMessage", "User with this email has already been registered!");
            return request.getContextPath() + "/controller?command=REGISTER_PAGE";
        }else {

            Employee employee = new Employee();
            employee.setName(name);
            employee.setSurname(surname);
            employee.setMobile(mobile);
            employee.setEmail(email);
            try {
                Collection<Part> parts = request.getParts();
                String realPath = request.getServletContext().getRealPath("assets/img/users");
                String imgName = null;
                for (Part part : parts) {
                    try {

                        if (part.getSubmittedFileName() != null) {

                            imgName = employee.getSurname() + "_" + part.getSubmittedFileName();
                            part.write(realPath + "\\" + imgName);

                        }
                    } catch (IOException e) {
                        throw new MyException();
                    }
                }
                if (imgName == null) {
                    imgName = "default.png";
                }
                employee.setImageName(imgName);

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                employee.setPassword(KeyDerivator.generateStorngPasswordHash(password));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                throw new MyException();
            }

            employee.setProfile(text);
            this.employeeDao.add(employee);
            LOGGER.info("Success.");
            return request.getContextPath() + "/controller?command=LOGIN_PAGE";
        }
    }
}

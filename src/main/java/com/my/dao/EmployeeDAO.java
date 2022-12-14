package com.my.dao;

import com.my.db.DBManager;
import com.my.model.Employee;
import com.my.services.exception.MyException;
import org.jetbrains.annotations.NotNull;

import static com.my.db.Constants.*;
import static com.my.db.Fields.*;
import static com.my.db.Fields.USER_IMG;
import static com.my.db.DBManager.LOGGER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IDAO<Employee> {
    private static DBManager manager;

    public EmployeeDAO() {
        manager = DBManager.getInstance();
    }
    public EmployeeDAO(boolean test) {
        manager = DBManager.getTestInstance();
    }

    public void add(@NotNull Employee employee) throws MyException {
        LOGGER.info("registration employee...");
               int result = 0;



        try(Connection con = manager.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT_USERS,PreparedStatement.RETURN_GENERATED_KEYS);){
                int k = 1;
                preparedStatement.setString(k++, employee.getName());
                preparedStatement.setString(k++, employee.getSurname());
                preparedStatement.setString(k++, employee.getEmail());
                preparedStatement.setString(k++, employee.getMobile());
                preparedStatement.setString(k++, employee.getPassword());
                preparedStatement.setString(k++, employee.getProfile());
                preparedStatement.setString(k++, employee.getImageName());
            preparedStatement.setInt(k++, 0);
                result = preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if(rs.next())
                    employee.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new MyException();
        }
    }

    public List<String> getList() throws MyException {
        LOGGER.info("Getting roles...");
        List<String> roles = new ArrayList<>();
        try {
            ResultSet rs = manager.getRSFromSql(SQL_SELECT_ROLES);
            while (rs.next()) {
                roles.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new MyException();
        }
        return roles;
    }

    public Employee extract(@NotNull ResultSet rs) throws MyException {
        Employee employee = new Employee();
        try {
            employee.setId(rs.getInt(USER_ID));
            employee.setName(rs.getString(USER_NAME));
            employee.setSurname(rs.getString(USER_SURNAME));
            employee.setEmail(rs.getString(USER_EMAIL));
            employee.setMobile(rs.getString(USER_MOBILE));
            employee.setRole(rs.getInt(USER_ROLE));
            employee.setProfile(rs.getString(USER_PROFILE));
            employee.setImageName(rs.getString(USER_IMG));
            employee.setOrders(rs.getInt("orders"));
        } catch (SQLException e) {
            throw new MyException();
        }
        return employee;
    }

    public  Employee find(String employee) throws MyException {
        LOGGER.info("Finding employee...");

        try(Connection con = manager.getConnection()){
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
            if(employee.contains("@")){
                preparedStatement = con.prepareStatement(SQL_SELECT_USER_BY_EMAIL);
                preparedStatement.setString(1, employee);
            }else {
                preparedStatement = con.prepareStatement(SQL_SELECT_USER_BY_ID);
                preparedStatement.setInt(1, Integer.parseInt(employee));
            }
            rs = preparedStatement.executeQuery();
            Employee extractedEmployee = null;
            if(rs.next()){
                extractedEmployee = extract(rs);
            }
            return extractedEmployee;
        } catch (Exception e) {
            throw new MyException();
        }

    }
    /**
     * Method getEmployee() is used to return Employee from the table.
     * @params offset - start point in SQL limit.
     *
     */
    public Employee getEmployee( int offset) throws MyException {
        LOGGER.info("Getting employee...");
        Employee employee = new Employee();

        try {
            ResultSet rs = manager.getRSFromSql("SELECT * FROM users LIMIT 1 OFFSET " + offset);
            if (rs.next()) {
                employee = extract(rs);
            }
        } catch (SQLException e) {
            throw new MyException();
        }
        return employee;
    }
    /**
     * Method updateEmployeeOrders() is used to update orders count.
     * @params employee - employee, which need to update orders count
     *
     */
    public void updateEmployeeOrders(@NotNull Employee employee){

        try(Connection con = manager.getConnection();
        PreparedStatement ps = con.prepareStatement(SQL_UPDATE_EMPLOYEE_ORDERS)) {
            employee.addOneOrder();
            ps.setInt(1,employee.getOrders());
            ps.setInt(2,employee.getId());
            ps.executeUpdate();
            System.out.println(employee.getOrders());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Method getCountOfUsers() is used to get number of users in the table.
     *
     */
    public int getCountOfUsers(){
        int count = 0;
        try(Connection con = manager.getConnection()){
            ResultSet rs = manager.getRSFromSql(SQL_GET_TOTAL_USERS);
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

}

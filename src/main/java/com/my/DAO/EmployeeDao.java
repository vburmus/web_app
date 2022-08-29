package com.my.DAO;

import com.my.Model.Employee;

import static com.my.DAO.DB.Constants.*;
import static com.my.DAO.DB.Fields.*;
import static com.my.DAO.DB.Fields.USER_IMG;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static DBManager manager = DBManager.getInstance();
    private CategoryDao categoryDao = new CategoryDao();

    public void registerEmployee(Employee employee) throws ClassNotFoundException {
               int result = 0;
        Class.forName("com.mysql.jdbc.Driver");


        try(Connection con = manager.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT_USERS);){
                int k = 1;
                preparedStatement.setString(k++, employee.getName());
                preparedStatement.setString(k++, employee.getSurname());
                preparedStatement.setString(k++, employee.getEmail());
                preparedStatement.setString(k++, employee.getMobile());
                preparedStatement.setString(k++, employee.getPassword());
                preparedStatement.setString(k++, employee.getProfile());
                preparedStatement.setString(k++, employee.getImageName());
                result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  Employee getEmployee( int offset){
        Employee employee = new Employee();

        try {
            ResultSet rs = manager.getRSFromSql("SELECT * FROM users LIMIT 1 OFFSET " + offset);
            if (rs.next()) {
                employee = extractEmployee(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
    public List getRoles(){
        List<String> roles = new ArrayList<>();
        try {
            ResultSet rs = manager.getRSFromSql(SQL_SELECT_ROLES);
            while (rs.next()) {
                roles.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }
    public Employee extractEmployee(ResultSet rs) {
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
            throw new RuntimeException(e);
        }
        return employee;
    }
    public  Employee findEmployee(int id){

        try(Connection con = manager.getConnection()){
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
                preparedStatement = con.prepareStatement(SQL_SELECT_USER_BY_ID);
                preparedStatement.setInt(1, id);

            rs = preparedStatement.executeQuery();
            Employee extractedEmployee = null;
            if(rs.next()){
                extractedEmployee = extractEmployee(rs);
            }
            return extractedEmployee;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void updateEmployeeOrders(Employee employee){
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

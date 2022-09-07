package com.my.dao;

import com.my.db.DBManager;
import com.my.model.Category;
import com.my.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.my.db.Fields.*;
import static com.my.db.Fields.USER_IMG;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest {
    EmployeeDAO employeeDAO = new EmployeeDAO(true);

    @BeforeEach
     void clearTable(){
        DBManager dbManager = DBManager.getTestInstance();
        dbManager.clearTable("items_has_transaction");
        dbManager.clearTable("order_has_transaction");
        dbManager.clearTable("category_has_items");
        dbManager.clearTable("category");
        dbManager.clearTable("items");
        dbManager.clearTable("transaction");
        dbManager.clearTable("orders");
        dbManager.clearTable("users");
    }
    @Test
    void addEmployee(){
        Employee employee = new Employee();
        employee.setName("asdf");
        employee.setSurname("QWERTY");
        employee.setEmail("asdf@asdf.com");
        employee.setMobile("77777777777");
        employee.setRole(2);
        employeeDAO.add(employee);
        Employee foundEmployee = employeeDAO.find(String.valueOf(employee.getId()));
        Assertions.assertEquals(foundEmployee.getName(), employee.getName());
    }
    @Test
    void getEmployeeList(){
        List<String> roles = employeeDAO.getList();
        Assertions.assertEquals(roles.size(),5);

    }
    @Test
    void compareCountOf(){
        for(int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setName("asdf");
            employee.setSurname("QWERTY");
            employee.setEmail("asdf@asdf.com" + i);
            employee.setMobile("77777777777");
            employee.setRole(2);
            employeeDAO.add(employee);
        }
        Assertions.assertEquals(10, employeeDAO.getCountOfUsers());
    }
}
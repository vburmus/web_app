package com.my.dao;

import com.my.db.DBManager;
import com.my.model.Employee;
import com.my.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {
    EmployeeDAO employeeDAO = new EmployeeDAO(true);
    OrderDAO orderDAO = new OrderDAO(true);
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
    void addFindDelete() {
        Employee employee = new Employee();
        employee.setName("asdf");
        employee.setSurname("QWERTY");
        employee.setEmail("asdf@asdf.com");
        employee.setMobile("77777777777");
        employee.setRole(2);
        employeeDAO.add(employee);

        Order order = new Order(true);
        order.setUsers_id(employee.getId());
        orderDAO.add(order);
        Order foundOrder = orderDAO.find(String.valueOf(order.getId()));
        Assertions.assertEquals(foundOrder.getId(), order.getId());
        orderDAO.deleteOrder(order);
        Assertions.assertNull(orderDAO.find(String.valueOf(order.getId())));
    }

}
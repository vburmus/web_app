package com.my.dao;

import com.my.db.DBManager;
import com.my.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionDAOTest {
    ItemDAO itemDAO = new ItemDAO(true);
    CategoryDAO categoryDAO = new CategoryDAO(true);
    OrderDAO orderDAO = new OrderDAO(true);
    TransactionDAO transactionDAO = new TransactionDAO(true);
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
    void addFindDelete() {
        Item item = new Item();
        item.setName("asdf");
        item.setQuantity(34);
        item.setTitle("qwerty");
        item.setPrice(300);
        Category category = new Category("3","3");
        categoryDAO.add(category);
        item.setCategory(category);
        itemDAO.add(item);

        Employee employee = new Employee();
        employee.setName("asdf");
        employee.setSurname("QWERTY");
        employee.setEmail("asdf@qwerty.com");
        employee.setMobile("77777777777");
        employee.setRole(2);
        employeeDAO.add(employee);

        Order order = new Order(true);
        order.setUsers_id(employee.getId());
        orderDAO.add(order);

        Transaction transaction = new Transaction();
        transaction.setQuantity(10);
        transaction.setItem(item);

        transaction.setOrder(order);
        transactionDAO.add(transaction);

        Transaction foundTransaction = transactionDAO.find(String.valueOf(transaction.getId()));
        Assertions.assertEquals(foundTransaction.getId(), transaction.getId());

        transactionDAO.changeQuantity(transaction, 1,true);

        Assertions.assertEquals(1,transactionDAO.find(String.valueOf(transaction.getId())).getQuantity());
        Assertions.assertEquals(33,itemDAO.find(String.valueOf(item.getId())).getQuantity());
        transactionDAO.deleteTransaction(transaction);
        Assertions.assertNull(transactionDAO.find(String.valueOf(transaction.getId())));
    }


}
package com.my.db;

public class Constants {
    public static final String SQL_INSERT_USERS =
            "INSERT INTO users  ( id, name, surname, email, mobile, password, profile,img,role) " +
                    "VALUES  ( default, ?, ?, ?, ?, ?, ?,?,?);";

    public static final String SQL_SELECT_ROLES =
            "SELECT * FROM roles ORDER BY ID";
    public static final String SQL_UPDATE_ROLES =
            "UPDATE users SET role = ? WHERE email = ?";
    public static final String SQL_SELECT_ITEM_BY_ID =
            "SELECT * FROM items WHERE id = ? ";
    public static final String SQL_SELECT_USER_BY_ID =
            "SELECT * FROM users WHERE id = ? ";
    public static final String SQL_SELECT_USER_BY_EMAIL =
            "SELECT * FROM users WHERE email = ? ";
    public static final String SQL_SELECT_ITEM_BY_NAME =
            "SELECT * FROM items WHERE name = ? ";
    public static final String SQL_UPDATE_EMPLOYEE_ORDERS =
"UPDATE users SET  orders = ?  WHERE id = ?;";
    public static final String SQL_INSERT_ITEM =
            "INSERT INTO items  ( id, name, quantity, title, price,photo,unit) " +
                    "VALUES  ( default, ?, ?, ?, ?, ?,?);";
    public static final String SQL_SELECT_ITEMS =
            "SELECT * FROM items ORDER BY ID";
    public static final String SQL_INSERT_TRANSACTION =
            "INSERT INTO transaction ( id, item_id, quantity) " +
                                        "VALUES (default,?,?)";
    public static final String SQL_INSERT_ORDER =
            "INSERT INTO orders (id,user, created,summary) VALUES (default,?,?,0);";
    public static final String SQL_ORDER_TRANSACTION =
            "INSERT INTO order_has_transaction ( order_id, transaction_id) " +
                    "VALUES (?,?)";
    public static final String SQL_UPDATE_ORDER =
            "UPDATE orders SET summary = ? WHERE id = ?";
    public static final String SQL_SELECT_ORDERS =
            "SELECT * FROM orders ORDER BY ID";
    public static final String SQL_SELECT_ORDER =
            "SELECT * FROM orders WHERE id = ?";
    public static final String SQL_SELECT_ORDER_TRANSACTIONS =
            "SELECT * FROM order_has_transaction WHERE order_id = ?";
    public static final String SQL_SELECT_TRANSACTIONS_ORDER =
            "SELECT * FROM order_has_transaction WHERE transaction_id = ?";
    public static final String SQL_EXECUTE_TRANSACTION =
            "SELECT * FROM transaction WHERE id = ?";
    public static final String SQL_SELECT_TRANSACTION =
            "SELECT * FROM transaction WHERE id = ?";
    public static final String SQL_UPDATE_QUANTITY_TRANSACTION =
    "UPDATE transaction SET quantity = ? WHERE id=?";
    public static final String SQL_UPDATE_QUANTITY_ITEM =
            "UPDATE items SET quantity = ? WHERE id=?";
    public static final String SQL_DELETE_ORDER_TRANSACTION =
    "DELETE FROM order_has_transaction WHERE transaction_id = ?";
    public static final String SQL_DELETE_TRANSACTION =
            "DELETE FROM transaction WHERE id = ?";
    public static final String SQL_DELETE_ORDER_TRANSACTIONS =
            "DELETE FROM order_has_transaction WHERE transaction_id = ?";
    public static final String SQL_DELETE_ORDER =
            "DELETE FROM orders WHERE id = ?";
    public static final String SQL_READY_ORDER =
            "UPDATE orders SET isReady=1 WHERE id = ?";
    public static final String SQL_ADD_CATEGORY =
            "INSERT INTO category (name,title) VALUES (?,?)";
    public static final String SQL_ADD_CATEGORY_ITEM =
            "INSERT INTO category_has_items (category_id,items_id) VALUES (?,?)";
    public static final String SQL_CATEGORIES =
            "SELECT *  FROM category_has_items";
    public static final String SQL_SELECT_CATEGORIES =
            "SELECT * FROM category";
    public static final String SQL_SELECT_CATEGORY_BY_ID =
            "SELECT * FROM category WHERE id=?";
    public static final String SQL_SELECT_CATEGORY_BY_NAME =
            "SELECT * FROM category WHERE name=?";
    public static final String SQL_GET_TOTAL_USERS =
            "SELECT count(*) FROM users";
    public static final String SQL_GET_TOTAL_ITEMS =
            "SELECT count(*) FROM items";
    public static final String SQL_GET_TOTAL_ORDERS =
            "SELECT count(*) FROM orders";
    public static final String SQL_UPDATE_ITEM_QUANTITY =
            "UPDATE items SET quantity = ? WHERE id=?";
}

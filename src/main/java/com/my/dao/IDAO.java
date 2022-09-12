package com.my.dao;

import com.my.services.exception.MyException;

import javax.naming.OperationNotSupportedException;
import java.sql.ResultSet;
import java.util.List;

public interface IDAO<T> {
    /**
     * Method add() is used add object in table.
     * @params T t - generic type object, which you want to add in  table
     *
     */
    void add(T t) throws MyException;
    /**
     * Method getList() is used to return a list of Objects from table.
     * @return List of objects
     */
    default List getList() throws MyException {
        try {
            throw new OperationNotSupportedException();
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Method getList(int offset) is used to return a list of Objects from table.
     * @params offset - parameter for SQL request, which shows the place of start
     * @return List of objects
     *
     */
    default List getList(int offset) throws MyException {
        try {
            throw new OperationNotSupportedException();
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Method extract() is uset to extract an object during the SQL requests.
     * @params rs - ResultSet,from which we want to extract a generic type object
     *@return T object
     */
    T extract(ResultSet rs) throws MyException;
    /**
     * Method find() is used to find an object in tables.
     * @params name - String,which contains id or name, which is unique in table.
     *@return T object
     */
    T find(String name) throws MyException;
}

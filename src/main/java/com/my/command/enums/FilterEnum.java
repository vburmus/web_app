package com.my.command.enums;

import com.my.command.filter.*;
import com.my.command.IFilterCommand;

public enum FilterEnum {
    LOGIN_PAGE(new LoginFilterCommand()),
    LOGIN(new LoginFilterCommand()),
    ERROR_PAGE(new ErrorFilterCommand()),
    LOGOUT(new LogoutFilterCommand()),
    REGISTER_PAGE(new RegisterFilterCommand()),
    REGISTER(new RegisterFilterCommand()),
    PROFILE_PAGE(new ProfileFilterCommand()),
    NEW_PRODUCT(new NewProductFilterCommand()),
    NEW_PRODUCT_PAGE(new NewProductFilterCommand()),
    PRODUCTS_PAGE(new ProductsFilterCommand()),
    UPDATE_ROLES(new AdminOnlyFilterCommand()),
    ADD_PRODUCT(new CashierOnlyFilterCommand()),
    CLOSE_ORDER(new CashierOnlyFilterCommand()),
    TRANSACTION_PAGE(new CashierOnlyFilterCommand()),
    ORDERS_PAGE(new CommodityExceptFilterCommand()),
    ORDER_PAGE(new CommodityExceptFilterCommand()),
    CHANGE_QUANTITY(new CashierOnlyFilterCommand()),
    DELETE_ORDER(new SeniorOnlyFilterCommand()),
    REPORT_PAGE(new SeniorOnlyFilterCommand()),
    X_REPORT(new SeniorOnlyFilterCommand()),
    Z_REPORT(new SeniorOnlyFilterCommand()),
    DELETE_TRANSACTION(new SeniorOnlyFilterCommand()),
    ADD_CATEGORY(new CommodityExceptFilterCommand()),
    EMPLOYEES_PAGE(new AdminOnlyFilterCommand());

    private IFilterCommand command;

    FilterEnum(IFilterCommand command){
        this.command = command;
    }
    public IFilterCommand getCommand(){
        return command;
    }
}

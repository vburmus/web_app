package com.my.Command;

import com.my.Command.Get.*;
import com.my.Command.Post.*;
import com.my.Command.doFilter.*;

public enum FilterEnum {
    LOGIN_PAGE(new LoginFilterCommand()),
    ERROR_PAGE(new ErrorFilterCommand()),
    LOGOUT(new LogoutFilterCommand()),
    REGISTER_PAGE(new RegisterFilterCommand()),
    PROFILE_PAGE(new ProfileFilterCommand()),
    NEW_PRODUCT_PAGE(new NewProductFilterCommand()),
    PRODUCTS_PAGE(new ProductsFilterCommand()),
    EMPLOYEES_PAGE(new EmployeesFilterCommand());
    /*
    NEW_PRODUCT(new NewProductCommand()),
    LOGIN(new LoginCommand()),
    REGISTER(new RegisterCommand()),
    UPDATE_ROLES(new UpdateRolesCommand()),
    TRANSACTION_PAGE(new TransactionPageCommand()),
    ADD_PRODUCT(new AddProductCommand()),
    CLOSE_ORDER(new CloseOrderCommand()),
    ORDERS_PAGE(new OrdersPageCommand()),
    ORDER_PAGE(new OrderPageCommand()),
    CHANGE_QUANTITY(new ChangeQuantityCommand()),
    DELETE_ORDER(new DeleteOrderCommand()),
    DELETE_TRANSACTION(new DeleteTransactionCommand()),
    REPORT_PAGE(new ReportPageCommand()),
    X_REPORT(new XReportCommand()),
    Z_REPORT(new ZReportCommand()),

    ADD_CATEGORY(new NewCategoryCommand());*/
    private IFilterCommand command;

    FilterEnum(IFilterCommand command){
        this.command = command;
    }
    public IFilterCommand getCommand(){
        return command;
    }
}

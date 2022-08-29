package com.my.Command;

import com.my.Command.Get.*;

import com.my.Command.Post.*;

public enum PageEnum {
    LOGIN_PAGE(new LoginPageCommand()),
    ERROR_PAGE(new ErrorPageCommand()),
    EMPLOYEES_PAGE(new EmployeesPageCommand()),
    REGISTER_PAGE(new RegisterPageCommand()),
    PROFILE_PAGE(new ProfilePageCommand()),
    NEW_PRODUCT_PAGE(new NewProductPageCommand()),
    LOGOUT(new LogoutPageCommand()),
    PRODUCTS_PAGE(new ProductsPageCommand()),
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

    ADD_CATEGORY(new NewCategoryCommand());


    private ICommand command;

    PageEnum(ICommand command){
        this.command = command;
    }
    public ICommand getCommand(){
        return command;
    }

}

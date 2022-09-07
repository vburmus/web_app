package com.my.command.enums;

import com.my.command.get.*;

import com.my.command.ICommand;
import com.my.command.post.*;

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
    LANG_SETUP(new LangSetUpCommand()),
    ADD_CATEGORY(new NewCategoryCommand()),
    READY_ORDER(new ReadyOrderCommand());


    private ICommand command;

    PageEnum(ICommand command){
        this.command = command;
    }
    public ICommand getCommand(){
        return command;
    }

}

package com.my.command.get;

import com.my.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.db.DBManager.LOGGER;

public class TransactionPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        LOGGER.info("Transaction page.");
        return "transaction";
    }
}

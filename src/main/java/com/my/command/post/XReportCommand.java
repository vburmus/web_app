package com.my.command.post;

import com.my.command.ICommand;
import com.my.dao.EmployeeDAO;
import com.my.dao.OrderDAO;
import com.my.model.Employee;
import com.my.model.Order;
import com.my.services.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class XReportCommand implements ICommand {
    private OrderDAO orderDAO = new OrderDAO();
    private EmployeeDAO employeeDao = new EmployeeDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws MyException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        if(req.getParameter("fromDay")!=""||req.getParameter("toDay")!="") {
            LocalDate fromDate = LocalDate.parse(req.getParameter("fromDay").replace("-", "."), formatter);
            LocalDate toDay = LocalDate.parse(req.getParameter("toDay").replace("-", "."), formatter);

            List<Order> orders = orderDAO.getList();
            List<Order> dayOrders = new ArrayList<>();
            for (int i = 0; i < orders.size(); i++) {

                String[] dateTime = (orders.get(i).getDate()).split("\\s");
                LocalDate ordersDate = LocalDate.parse(dateTime[0], formatter2);
                if ((ordersDate.isBefore(toDay) && ordersDate.isAfter(fromDate)) || ordersDate.equals(fromDate) || ordersDate.equals(toDay)) {
                    dayOrders.add(orders.get(i));
                }

            }
            Order maxOrder = orders.get(0);
            for (Order o : dayOrders) {
                if (o.getSummary() > maxOrder.getSummary())
                    maxOrder = o;
            }

            Employee maxEmp = employeeDao.find(String.valueOf(maxOrder.getUsers_id()));
            float summary = 0;
            summary = (dayOrders.stream().map(x -> x.getSummary())
                    .reduce((float) 0, Float::sum));

            if (dayOrders.size() == 0) {
                req.getSession().setAttribute("errorMessage", "No orders found!");
                req.getSession().setAttribute("errorPage", "report");
            } else {
                req.getSession().setAttribute("summary", summary);
                req.getSession().setAttribute("orders", dayOrders);
                req.getSession().setAttribute("biggestOrder", maxOrder);
                req.getSession().setAttribute("maxEmployee", maxEmp);
            }
            req.getSession().setAttribute("date", fromDate + " - " + toDay);
        }else{
            req.getSession().setAttribute("errorMessage", "Wrong date!");
            req.getSession().setAttribute("errorPage", "report");
        }
        return  req.getContextPath() + "/controller?command=REPORT_PAGE";
    }
}

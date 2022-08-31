package com.my.Command.Post;

import com.my.Command.ICommand;
import com.my.DAO.EmployeeDAO;
import com.my.DAO.OrderDAO;
import com.my.Model.Employee;
import com.my.Model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ZReportCommand implements ICommand {
    OrderDAO orderDAO = new OrderDAO();
    EmployeeDAO employeeDao = new EmployeeDAO();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(req.getParameter("selectedDay").replace("-","."),formatter);
        List<Order> orders  = orderDAO.getList();

        List<Order> dayOrders =  new ArrayList<>();
        for(int i = 0; i < orders.size(); i++){

            String[] dateTime = (orders.get(i).getDate()).split("\\s");
            LocalDate ordersDate = LocalDate.parse(dateTime[0],formatter2);
            if(date.equals(ordersDate)){
                dayOrders.add(orders.get(i));
            }

        }
        Order maxOrder = orders.get(0);
        for(Order o: dayOrders){
            if(o.getSummary()>maxOrder.getSummary())
                maxOrder = o;
        }
        Employee maxEmp = employeeDao.find(String.valueOf(maxOrder.getUsers_id()));
        float summary = 0;
        summary = (dayOrders.stream().map(x -> x.getSummary())
                .reduce((float) 0,  Float::sum));

        req.getSession().setAttribute("summary" , summary);
        req.getSession().setAttribute("orders" , orders);
        req.getSession().setAttribute("biggestOrder" , maxOrder);
        req.getSession().setAttribute("maxEmployee" , maxEmp);
        req.getSession().setAttribute("date", date);
        return  req.getContextPath() + "/controller?command=REPORT_PAGE";
    }
}

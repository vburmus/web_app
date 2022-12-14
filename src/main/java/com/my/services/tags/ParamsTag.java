package com.my.services.tags;

import com.my.db.Fields;
import com.my.dao.EmployeeDAO;
import com.my.dao.OrderDAO;
import com.my.model.Employee;
import com.my.model.Order;
import com.my.services.exception.MyException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class ParamsTag extends TagSupport {
    private String orderId;
    private String userId;
    private String location;
    private OrderDAO orderDAO = new OrderDAO();
    private EmployeeDAO employeeDao = new EmployeeDAO();
    @Override
    public int doStartTag() throws JspException {
        Order order = null;
        try {
            order = orderDAO.find(orderId);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        Employee user = null;
        try {
            user = employeeDao.find(userId);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        JspWriter out = pageContext.getOut();
        try {
            String button;
            String delete;
            String close;
            String orderStr;
            if(location.equals("ua")){
                button = "Переглянути";
                delete = "Видалити";
                close = "Закрити";
                orderStr = "Замовлення №:";
            }else{
                button = "Check";
                delete = "Delete";
                close = "Close";
                orderStr = "Order №:";
            }
           out.print("<div class=\"card-body\">" +
                   " <h4 class=\"card-title\">"+orderStr + order.getId() +"</h4> " +"<hr>"+
                   "<p class=\"card-text\">"+ order.getSummary()+"$</p> " +
                   "<div class=\"row\"> ");
            if(order.getIsReady()==0) {
                out.print("<div class=\"col-3\">" +
                        " <form method=\"get\" action=\"controller\"> " +
                        "<input type=\"hidden\" name=\"orderId\" value=\""+  order.getId() + "\"> " +
                        "<input type=\"hidden\" name=\"command\" value=\"ORDER_PAGE\">" +
                        " <button type=\"submit\" class=\"btn-light\" >" + button + "</button>" +
                        " </form> " +
                        "</div>");

                if (user.getRole() == Fields.SENIOR_CASHIER) {

                    out.print("<div class=\"col-3\"> <form method=\"post\" action=\"controller\"> " +
                            "<input type=\"hidden\" name=\"orderId\" value=\"" + order.getId() + "\"> " +
                            "<input type=\"hidden\" name=\"command\" value=\"DELETE_ORDER\"/> " +
                            "<button type=\"submit\" class=\"btn-light align-bottom\">" + delete + "</button> </form></div> ");


                    out.print("<div class=\"col-3\"> <form method=\"post\" action=\"controller\"> " +
                            "<input type=\"hidden\" name=\"orderId\" value=\"" + order.getId() + "\"> " +
                            "<input type=\"hidden\" name=\"command\" value=\"READY_ORDER\"/> " +
                            "<button type=\"submit\" class=\"btn-light align-bottom\">" + close + "</button> </form> </div>");
                }
            }
                    out.print(
                   " </div> " +
                   "</div> " +
                   "<div class=\"row\">");
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    public String getUserId() {
        return userId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

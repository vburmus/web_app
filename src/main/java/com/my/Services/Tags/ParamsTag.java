package com.my.Services.Tags;

import com.my.DB.Fields;
import com.my.DAO.EmployeeDAO;
import com.my.DAO.OrderDAO;
import com.my.Model.Employee;
import com.my.Model.Order;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ParamsTag extends TagSupport {
    private String orderId;
    private String userId;
    private String location;
    private OrderDAO orderDAO = new OrderDAO();
    private EmployeeDAO employeeDao = new EmployeeDAO();
    @Override
    public int doStartTag() throws JspException {
      Order order = orderDAO.find(orderId);
        Employee user = employeeDao.find(userId);
        JspWriter out = pageContext.getOut();
        try {
            String button;
            if(location.equals("ua")){
                button = "Переглянути";
            }else{
                button = "Check";
            }
           out.print("<div class=\"card-body\">" +
                   " <h4 class=\"card-title\">№:" + order.getId() +"</h4> " +
                   "<p class=\"card-text\">"+ order.getSummary()+"$</p> " +
                   "<div class=\"row\"> " +
                   "<div class=\"col-3\">" +
                   " <form method=\"get\" action=\"controller\"> " +
                   "<input type=\"hidden\" name=\"orderId\" value=\"" + order.getId() +"\"> " +
                   "<input type=\"hidden\" name=\"command\" value=\"ORDER_PAGE\">" +
                   " <button type=\"submit\" class=\"btn-light\" >"+button+"</button>" +
                   " </form> " +
                   "</div> " +
                   "<div class=\"col-3\"> ");
                    if(user.getRole() == Fields.SENIOR_CASHIER) {
                       out.print("<form method=\"post\" action=\"controller\"> " +
                                "<input type=\"hidden\" name=\"orderId\" value=\""+ order.getId()+"\"> " +
                                "<input type=\"hidden\" name=\"command\" value=\"DELETE_ORDER\"/> " +
                                "<button type=\"submit\" class=\"btn-light align-bottom\"><fmt:message key=\"delete_order\" /></button> </form> ");

                    }
                    out.print(
                   " </div> </div> " +
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

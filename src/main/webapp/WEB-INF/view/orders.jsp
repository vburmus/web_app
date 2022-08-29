<%@ page import="com.my.Model.Order" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.my.DAO.DB.Fields" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <jsp:useBean id="orders" scope="request" type="java.util.ArrayList"/>
    <jsp:useBean id="user" scope="session" type="com.my.Model.Employee"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/order.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>

</head>
<body>
<jsp:include page="header.jsp"/>
<c:if test="${orders.size()==0}">
    <div class="message">
    <div class="row ">
    <div class="bg-warning rounded-3 col-8 offset-2">
    <h3 class="text-white">Please add orders!</h3>
    </div>
    </div>
    </div>
</c:if>
<c:forEach items="${orders}" var="order">

<div class="order w-50">
    <div class="card mb-3">
            <div class="card-body">
                <h4 class="card-title">Order nr:${order.getId()}</h4>
                <p class="card-text">Summary:${order.getSummary()}</p>
                <div class="row">
                    <div class="col-3">
                <form method="get" action="controller">
                    <input type="hidden" name="orderId" value="${order.getId()}">
                    <input type="hidden" name="command" value="ORDER_PAGE">

                    <button type="submit" class="btn-light" >Edit order</button>
                </form>
                    </div>
                    <div class="col-3">
                <c:if test="${user.role==Fields.SENIOR_CASHIER}">

                    <form method="post" action="controller">
                        <input type="hidden" name="orderId" value="${order.getId()}">
                    <input type="hidden" name="command" value="DELETE_ORDER"/>
                        <button type="submit" class="btn-light align-bottom">Delete order</button>
                    </form>

                </c:if>
                    </div>
            </div>
            </div>
            <div class="row">
        <c:forEach items="${order.getTransactions()}" var="transaction">
            <div class="col-2">
                <img src="${pageContext.request.contextPath}/assets/img/items/${transaction.getItem().getPhoto()}" class="orderImg" alt="..."/>
            </div>
        </c:forEach>
            </div>
        <div class="card-footer">
        <p class="card-text"><small class="text-muted">Created:${order.getDate()}</small></p>
        </div>
</div>
</div>

</c:forEach>

</body>
</html>

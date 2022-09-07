<%@ page import="com.my.model.Order" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mtl" uri="cash-register" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.my.db.Fields" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <jsp:useBean id="orders" scope="request" type="java.util.ArrayList"/>
    <jsp:useBean id="user" scope="session" type="com.my.model.Employee"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/order.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>

</head>
<body>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="language"/>
<jsp:include page="header.jsp"/>
<c:if test="${orders.size()==0}">
    <div class="message">
    <div class="row ">
    <div class="bg-warning rounded-3 col-8 offset-2">
    <h3 class="text-white"><fmt:message key="orders_message"/></h3>
    </div>
    </div>
    </div>
</c:if>
<c:forEach items="${orders}" var="order">
    <div class="order w-50">
<mtl:order userId="${user.id}" orderId="${order.getId()}" location="${locale}" />

    <div class="card mb-3">
        <div class="row">
        <c:forEach items="${order.getTransactions()}" var="transaction">
            <div class="col-2">
                <img src="${pageContext.request.contextPath}/assets/img/items/${transaction.getItem().getPhoto()}" class="orderImg" alt="..."/>
            </div>
        </c:forEach>
        </div>
            </div>
        <div class="card-footer">
        <p class="card-text"><small class="text-muted"><fmt:message key="orders_created"/>:${order.getDate()}</small></p>
        </div>
</div>
</div>


</c:forEach>
<div class="scroller">
    <div class="row">
        <div class="col-2">
        </div>
        <div class="col-3 justify-content-start">
            <c:if test="${page==1}">
                <a  hidden class="page-link text-center" href="${pageContext.request.contextPath}/controller?command=ORDERS_PAGE&page=${page-1}" tabindex="-1"><fmt:message key="previousButton"/></a>
            </c:if>
            <c:if test="${page!=1}">
                <a class="page-link text-center" href="${pageContext.request.contextPath}/controller?command=ORDERS_PAGE&page=${page-1}" tabindex="-1"><fmt:message key="previousButton"/></a>
            </c:if>


        </div>
        <div class="col-2">
        </div>
        <div class="col-3 justify-content-end">
            <c:if test="${page<pages}">
                <a class="page-link text-center" href="${pageContext.request.contextPath}/controller?command=ORDERS_PAGE&page=${page+1}"><fmt:message key="nextButton"/></a>
            </c:if>
        </div>
        <div class="col-2">
        </div>
    </div>
</div>
</body>
</html>

<%@ page import="com.my.Model.Order" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mtl" uri="cash-register" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.my.DB.Fields" %>
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
<mtl:order userId="${user.id}" orderId="${order.getId()}" location="${locale}" />
    <div class="order w-50">
    <div class="card mb-3">
        <c:forEach items="${order.getTransactions()}" var="transaction">
            <div class="col-2">
                <img src="${pageContext.request.contextPath}/assets/img/items/${transaction.getItem().getPhoto()}" class="orderImg" alt="..."/>
            </div>
        </c:forEach>
            </div>
        <div class="card-footer">
        <p class="card-text"><small class="text-muted"><fmt:message key="orders_created"/>:${order.getDate()}</small></p>
        </div>
</div>
</div>


</c:forEach>

</body>
</html>

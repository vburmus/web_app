<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: burmus
  Date: 8/26/2022
  Time: 9:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/z-report.css"/>
<jsp:useBean id="maxEmployee" type="com.my.Model.Employee" scope="session"/>
    <jsp:useBean id="biggestOrder" type="com.my.Model.Order" scope="session"/>
</head>
<body>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="language"/>
<jsp:include page="header.jsp"/>
<div class="container col-8 mx-auto ">


<div class="report">
    <h1 class="text-center">${date} Report </h1>
    <hr>
    <hr>
    <table class="table">
    <thead>
    <tr>
    <th scope="col">#</th>
    <th scope="col"><fmt:message key="_date"/></th>
    <th scope="col"><fmt:message key="_user"/></th>
    <th scope="col"><fmt:message key="_summary"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order">
   <tr>
    <th scope="row">${order.id}</th>
    <td>${order.date}</td>
    <td>${order.users_id}</td>
    <td>${order.summary}$</td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>
<hr>
<hr>
<hr>
<div class="maxOrder">
    <h3><fmt:message key="_maxOrder"/> ${maxEmployee.name} ${maxEmployee.surname}!</h3>
    <hr>
    <p><fmt:message key="_madeBy1"/> ${biggestOrder.date}, <fmt:message key="_madeBy2"/>- ${biggestOrder.summary}$</p>
    <hr>
    <p><fmt:message key="emp_id"/> ${maxEmployee.id}</p>
    <p><fmt:message key="emp_mail"/> ${maxEmployee.email}</p>
    <p><fmt:message key="emp_mobile"/> ${maxEmployee.mobile}</p>
</div>
<div class="summarise">
    <fmt:message key="income"/>  - ${summary}$
</div>
</div>
</body>
</html>

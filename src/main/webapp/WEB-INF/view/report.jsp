<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <th scope="col">Date</th>
    <th scope="col">User</th>
    <th scope="col">Summary</th>
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
    <h3>Max order was made by ${maxEmployee.name} ${maxEmployee.surname}!</h3>
    <hr>
    <p>It was made ${biggestOrder.date}, and this order`s summary - ${biggestOrder.summary}</p>
    <hr>
    <p>Employee id: ${maxEmployee.id}</p>
    <p>Employee email: ${maxEmployee.email}</p>
    <p>Employee mobile: ${maxEmployee.mobile}</p>
</div>
<div class="summarise">
    Total income for this day is  - ${summary}$
</div>
</div>
</body>
</html>

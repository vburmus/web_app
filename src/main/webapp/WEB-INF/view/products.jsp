<%--
  Created by IntelliJ IDEA.
  User: burmus
  Date: 8/9/2022
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/products.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>
<jsp:useBean id="items" scope="request" type="java.util.List"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<c:if test="${items.size()==0}">
  <div class="message">
    <div class="row ">
      <div class="bg-warning rounded-3 col-8 offset-2">
        <h3 class="text-white">Please add items!</h3>
      </div>
    </div>
  </div>
</c:if>
<div class="prod">
  <div class="row">


    <c:forEach var="item" items="${items}">
<div class="card-group col-3">

    <div class="card">
      <img class="card-img-top" src="${pageContext.request.contextPath}/assets/img/items/${item.getPhoto()}">
      <div class="card-body">
        <h5 class="card-title">${item.getName()}</h5>
        <p class="card-text">${item.getTitle()}</p>
      </div>
      <div class="card-footer">
        <h6 class="card-text">Price: ${item.getPrice()}</h6>
        <small class="text-muted">Quantity: ${item.getQuantity()}</small>
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
          <a  hidden class="page-link text-center" href="${pageContext.request.contextPath}/controller?command=PRODUCTS_PAGE&page=${page-1}" tabindex="-1">1Previous</a>
        </c:if>
        <c:if test="${page!=1}">
          <a class="page-link text-center" href="${pageContext.request.contextPath}/controller?command=PRODUCTS_PAGE&page=${page-1}" tabindex="-1">Previous</a>
        </c:if>


      </div>
      <div class="col-2">
      </div>
      <div class="col-3 justify-content-end">
        <c:if test="${page<pages}">
          <a class="page-link text-center" href="${pageContext.request.contextPath}/controller?command=PRODUCTS_PAGE&page=${page+1}">Next</a>
        </c:if>
      </div>
      <div class="col-2">
      </div>
    </div>
</div>
  </div>

</div>
</body>
</html>

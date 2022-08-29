<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css"/>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>

</head>

<body>
<jsp:include page="header.jsp"/>
<div class="form">
<div class="col-12">
<form action="controller" method="post">
  <input type="hidden" name="command" value="ADD_PRODUCT">

  <!-- Password input -->

<div class="form-outline mb-4">
    <c:if test="${errorMessage!=null}">
        <p class="text-danger" >${errorMessage}</p>
    </c:if>
<label class="form-label" for="item">Product id or name</label>
    <input type="text" name="item" id="item" class="form-control" />


    <label class="form-label" for="quantity">Quantity</label>
    <input type="number" name="quantity" id="quantity" class="form-control" />



  </div>
  <!-- 2 column grid layout for inline styling -->

  <!-- Submit button -->
  <button type="submit" class="btn btn-primary btn-block">Add product</button>

</form>
  <form action="controller" method="post">
    <input type="hidden" name="command" value="CLOSE_ORDER">
    <button type="submit" class="btn btn-primary btn-block">Close order</button>
  </form>
</div>
</div>
</body>
</html>

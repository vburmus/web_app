<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/products.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>
<jsp:useBean id="items" scope="request" type="java.util.List"/>
</head>
<body>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="language"/>
<jsp:include page="header.jsp"/>
<c:if test="${items.size()==0}">
  <div class="message">
    <div class="row ">
      <div class="bg-warning rounded-3 col-8 offset-2">
        <h3 class="text-white"><fmt:message key="products_message"/></h3>
      </div>
    </div>
  </div>
</c:if>
<div class="prod">
    <div id="chooseCategoryDiv" >
      <script type="text/javascript">
        function submitForm()
        {
          let select  = document.getElementById('selectCategory');
          select.submit();
        }
      </script>
      <form action="controller" method="get" id="selectCategory">
        <input type="hidden" name="command" value="PRODUCTS_PAGE">
        <input type="hidden" name="page" value="1">
      <select class="form-control"  name="selectCategory" onchange="submitForm()">
        <option></option>
        <option>None</option>
        <c:forEach var="category" items="${categories}">
          <option>${category.name}</option>
        </c:forEach>
      </select>
      </form>
  </div>
  <div class="chooseUnit">
    <form action="controller" method="get" id="selectUnit">
      <input type="hidden" name="command" value="PRODUCTS_PAGE">
      <input type="hidden" name="page" value="1">
      <select class="form-control" name="selectUnit" >
        <option>None</option>
        <option>kg</option>
        <option>g</option>
        <option>pcs</option>
      </select>
      <button type="submit">asdf</button>
    </form>
  </div>
  <div class="row">
    <c:forEach var="item" items="${items}">
<div class="card-group col-3">

    <div class="card">
      <div class="card-image">
      <img class="card-img-top" src="${pageContext.request.contextPath}/assets/img/items/${item.getPhoto()}">
      </div>
      <div class="card-footer">
        <div class="card-body">
        <h5 class="card-title">${item.getName()}</h5>
        <p class="card-text">${item.getTitle()}</p>
          <p class="card-text">${item.getCategory()}</p>
      </div>

        <h6 class="card-text"><fmt:message key="_price"/>: ${item.getPrice()}$</h6>
        <small class="text-muted"><fmt:message key="_quantity"/>: ${item.getQuantity()} ${item.getUnit()}</small>
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
          <a  hidden class="page-link text-center" href="${pageContext.request.contextPath}/controller?command=PRODUCTS_PAGE&page=${page-1}" tabindex="-1"><fmt:message key="previousButton"/></a>
        </c:if>
        <c:if test="${page!=1}">
          <a class="page-link text-center" href="${pageContext.request.contextPath}/controller?command=PRODUCTS_PAGE&page=${page-1}" tabindex="-1"><fmt:message key="previousButton"/></a>
        </c:if>


      </div>
      <div class="col-2">
      </div>
      <div class="col-3 justify-content-end">
        <c:if test="${page<pages}">
          <a class="page-link text-center" href="${pageContext.request.contextPath}/controller?command=PRODUCTS_PAGE&page=${page+1}"><fmt:message key="nextButton"/></a>
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

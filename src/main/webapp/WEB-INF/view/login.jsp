<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>

</head>
<body>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="language"/>
<div class="form">
<div class="col-12">

      <form action="controller" method="post">
<input type="hidden" name="command" value="LOGIN">

          <div class="form-outline mb-4">

              <label class="form-label" for="email"><fmt:message key="_email"/></label>
              <input type="email" name="email" id="email" class="form-control" />
          </div>

          <!-- Password input -->
          <div class="form-outline mb-4">
              <label class="form-label" for="passwordLog"><fmt:message key="_password"/></label>
              <input type="password" name="password" id="passwordLog" class="form-control" />
              <tf:error message="${errorMessage}"/>
          </div>
          <!-- 2 column grid layout for inline styling -->
          <div class="row mb-4">
              <div class="col d-flex justify-content-center">
    </div>
   <div class="col">
      <!-- Simple link -->
      <a href="${pageContext.request.contextPath}/controller?command=REGISTER_PAGE"><fmt:message key="_register"/></a>
    </div>
  </div>

  <!-- Submit button -->
  <button id="submit" type="submit" disabled  class="btn btn-primary btn-block"><fmt:message key="signIn"/></button>
</form>

  </div>
</div>
<script src="${pageContext.request.contextPath}/assets/js/validation.js"></script>
</body>
</html>
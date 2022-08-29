<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>

</head>
<body>
<div class="form">
<div class="col-12">
<jsp:include page="header.jsp"/>
      <form action="controller" method="post">
<input type="hidden" name="command" value="LOGIN">

          <div class="form-outline mb-4">

              <label class="form-label" for="email">Email address</label>
              <input type="email" name="email" id="email" class="form-control" />
          </div>

          <!-- Password input -->
          <div class="form-outline mb-4">
              <label class="form-label" for="passwordLog">Password</label>
              <input type="password" name="password" id="passwordLog" class="form-control" />
              <c:if test="${errorMessage!=null}">
                  <p class="text-danger " >${errorMessage}</p>
              </c:if>
          </div>
          <!-- 2 column grid layout for inline styling -->
          <div class="row mb-4">
              <div class="col d-flex justify-content-center">
      <!-- Checkbox -->
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked />
        <label class="form-check-label" for="form1Example3"> Remember me </label>
      </div>
    </div>
   <div class="col">
      <!-- Simple link -->
      <a href="${pageContext.request.contextPath}/controller?command=REGISTER_PAGE">Make an account</a>
    </div>
  </div>

  <!-- Submit button -->
  <button id="submit" type="submit" disabled  class="btn btn-primary btn-block">Sign in</button>
</form>
            
            
<!--<form name="registerForm" action="">
    <p>Insert your email: <input type="email" name="users_email"></p>
    <p>Insert your password: <input type="number" name="users_password" onchange="CheckPass(document.registerForm.users_password,document.registerForm.password_check)"></p>
    <p>Reinsert password : <input type="number" name="password_check"
                                  onchange="CheckPass(document.registerForm.users_password,document.registerForm.password_check)">
    </p>
    <p id="checker">
    </p>
    <input onclick="" type="submit">
    <script>
        function CheckPass(input, inputcheck) {
            if (input.value ===(inputcheck.value)) {
                document.getElementById("checker").innerHTML = "KORRECT";
                return true;
            } else {
                document.getElementById("checker").innerHTML = "UNKORRECT";
                return false;
            }
        }

    </script>
</form>-->
  </div>
</div>
<script src="${pageContext.request.contextPath}/assets/js/validation.js"></script>
</body>
</html>
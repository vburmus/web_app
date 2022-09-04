<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
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

      <form method="post" action="controller" enctype="multipart/form-data" >
          <input type="hidden" name="command" value="REGISTER"/>
        <div class="form-outline mb-4">
            <label class="form-label" for="name"><fmt:message key="_name"/></label>
            <input type="name" id="name" name="name" class="form-control" />
        </div>
          <div class="form-outline mb-4">
              <label class="form-label" for="surname"><fmt:message key="_surname"/></label>
              <input type="surname" id="surname"  name="surname" class="form-control" />
          </div>
          <div class="form-outline mb-4">
              <label class="form-label" for="mobile"><fmt:message key="_mobile"/></label>
              <input type="mobile" id="mobile" name="mobile" class="form-control" />
          </div>

          <!-- Email input -->
          <div class="form-outline mb-4">
              <label class="form-label" for="email"><fmt:message key="_email"/></label>
              <input type="email" id="email" name="email"  class="form-control" />
          </div>
          <div class="form-outline mb-4">
              <label class="form-label" for="password"><fmt:message key="_password"/></label>
              <input type="password" id="password" name="password" class="form-control" />
          </div>
          <div class="form-outline mb-4">
              <label class="form-label" for="text"><fmt:message key="_about"/></label>
              <textarea type="text" id="text" name="text" class="form-control" rows="3" ></textarea>
          </div>
          <div class="form-outline mb-4">
              <label class="form-label" for="photo"><fmt:message key="_img"/></label>
              <input type="file" id="photo" name="photo" class="form-control" />
              <tf:error message="${errorMessage}"/>
          </div>
          <div class="row mb-4">
              <div class="col d-flex justify-content-center">
    </div>
    <div class="col">
      <!-- Simple link -->
      <a href="controller?command=LOGIN_PAGE"><fmt:message key="_signIn"/></a>
    </div>
  </div>

  <!-- Submit button -->
  <button id="submit" type="submit" class="btn btn-primary btn-block"><fmt:message key="signUp"/></button>
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
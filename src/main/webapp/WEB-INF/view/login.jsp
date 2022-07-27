

<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        <%@include file="../../assets/css/bootstrap.min.css" %>
        <%@include file="../../assets/css/animate.css"%>
        <%@include file="../../assets/css/login.css"%>
    </style>

</head>
<body>
<div class="login-form">
<div class="col-12">

      <form>
        <div class="form-outline mb-4">
            <label class="form-label" for="name">Name</label>
            <input type="email" id="name" class="form-control" />
        </div>
          <div class="form-outline mb-4">
              <label class="form-label" for="surname">Surname</label>
              <input type="email" id="surname" class="form-control" />
          </div>
          <div class="form-outline mb-4">
              <label class="form-label" for="mobile">Mobile</label>
              <input type="email" id="mobile" class="form-control" />
          </div>

          <!-- Email input -->
          <div class="form-outline mb-4">
              <label class="form-label" for="email">Email address</label>
              <input type="email" id="email" class="form-control" />
          </div>

          <!-- Password input -->
          <div class="form-outline mb-4">
              <label class="form-label" for="password">Password</label>
              <input type="password" id="password" class="form-control" />
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
      <a href="#!">Forgot password?</a>
    </div>
  </div>

  <!-- Submit button -->
  <button type="submit" class="btn btn-primary btn-block">Sign in</button>
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
</body>
</html>
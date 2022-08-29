<%@ page import="com.my.Model.Employee" %>
<%@ page import="com.my.DAO.DB.Fields" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css"/>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous"/>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>

</head>
<body>
<header>
  <div class="navbar-area">
    <div class="container">
      <div class="row align-items-center">
        <div class="w-100">
          <nav class="navbar navbar-expand-lg">
            <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
              <span class="toggler-icon"></span>
              <span class="toggler-icon"></span>
              <span class="toggler-icon"></span>
            </button>

            <div
                    class="collapse navbar-collapse sub-menu-bar"
                    id="navbarSupportedContent"
            >

              <ul id="nav" class="navbar-nav ms-auto">
                <li class="nav-item">

                  <c:choose>
                  <c:when test="${(pageContext.session.getAttribute('user')==null) }">

                    <a class="page-scroll active" href="#home">Home</a>
                  </c:when>
                    <c:when test="${pageContext.session.getAttribute('user')!=null}">
                      <a  href="${pageContext.request.contextPath}/controller?command=PROFILE_PAGE">Profile</a>
                    </c:when>
                  </c:choose>

                </li>
                <li class="nav-item">
                  <c:choose>
                    <c:when test="${(pageContext.session.getAttribute('user')==null)}">
                      <a class="page-scroll" href="#features">Features</a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.ADMIN)}">
                      <a  class="" href="${pageContext.request.contextPath}/controller?command=EMPLOYEES_PAGE&page=1">Employees</a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.COMMODITY_EXERT)}">
                      <a  href="${pageContext.request.contextPath}/controller?command=PRODUCTS_PAGE&page=1">Products</a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.CASHIER||(pageContext.session.getAttribute('user').role==Fields.SENIOR_CASHIER))}">
                      <a  href="${pageContext.request.contextPath}/controller?command=ORDERS_PAGE">Orders</a>
                    </c:when>
                  </c:choose>

                </li>
                <li class="nav-item">
                  <c:choose>
                    <c:when test="${(pageContext.session.getAttribute('user')==null)}">
                      <a class="page-scroll" href="#about">About</a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.ADMIN)}">
                      <a  href="${pageContext.request.contextPath}/controller?command=ORDERS_PAGE">Orders</a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.COMMODITY_EXERT)}">
                      <a  href="${pageContext.request.contextPath}/controller?command=NEW_PRODUCT_PAGE">Add product</a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.CASHIER)}">
                      <a  href="${pageContext.request.contextPath}/controller?command=TRANSACTION_PAGE">Create order</a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.SENIOR_CASHIER)}">
                        <a href="javascript:void(0)" data-backdrop="false"  data-bs-toggle="modal" data-bs-target="#exampleModal">
                          Reports
                        </a>
                    </c:when>
                  </c:choose>

                </li>

                <li class="nav-item">
                  <c:choose>
                    <c:when test="${(pageContext.session.getAttribute('user')==null)}">
                      <a class="page-scroll" href="#why">Why</a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.ADMIN)}">
                      <a  href="${pageContext.request.contextPath}/controller?command=CATEGORY_PAGE">Categorie</a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role!=Fields.ADMIN)}">
                      <a  href="${pageContext.request.contextPath}/controller?command=MESSAGE_TO_ADMIN">Message to admin</a>
                    </c:when>
                  </c:choose>

                </li>
                <li class="nav-item">

                  <c:choose>
                    <c:when test="${(pageContext.session.getAttribute('user')==null)}">
                      <a id="navbarSignIn" href="${pageContext.request.contextPath}/controller?command=LOGIN_PAGE">Sign in</a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user')!=null)}">
                      <a href="${pageContext.request.contextPath}/controller?command=LOGOUT">Logout</a>
                    </c:when>
                  </c:choose>

                </li>
                <c:if test="${(pageContext.session.getAttribute('user').role==Fields.ADMIN)}">
                <li class="nav-item">
                      <a class="page-scroll" href="${pageContext.request.contextPath}/controller?command=ADMINS_MESSAGES_PAGE">Messages</a>
                </li>
                </c:if>

              </ul>
            </div>
            <!-- navbar collapse -->
          </nav>
          <!-- navbar -->
        </div>
      </div>
      <!-- row -->
    </div>
    <!-- container -->
  </div>
  <!-- navbar area -->

  <!-- Modal -->
  <div class="modal fade" data-backdrop="false" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header ">
          <h5>Reports</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="row">

            <div class="col-6  d-flex align-items-center justify-content-center " >
          <button type="button" id="x-submit" class="btn btn-primary " >X-Report</button>
            </div>
            <div class="col-6  d-flex align-items-center justify-content-center">
          <button type="button" id="z-submit" class="btn btn-primary">Z-Report</button>
            </div>
            <div class="col-12 mt-5">
              <div id="z-report_form" hidden>
              <form  method="post" action="controller">
                <input type="hidden" name="command" value="Z_REPORT">
                <input placeholder="Selected date" name="selectedDay" type="date"  class="form-control datepicker" >
                <button  type="submit">Create report</button>
              </form>
              </div>
              <div id="x-report_form" hidden>
                <form  method="post" action="controller">
                  <input type="hidden" name="command" value="X_REPORT">
                  <input placeholder="Selected date" name="fromDay" type="date" class="form-control datepicker" >
                  <input placeholder="Selected date" name="toDay" type="date" class="form-control datepicker" >
                  <button  type="submit">Create report</button>
                </form>
              </div>
            </div>
        </div>

      </div>
    </div>
    </div>
  </div>
  <script type="text/javascript">
    let z_counter = 0;
    document.getElementById('z-submit').addEventListener('click',()=> {
      document.getElementById('x-report_form').hidden = true;
      if(z_counter==0) {

        document.getElementById('z-report_form').hidden = false;
        z_counter=1;
        x_counter = 0;
      }else {
        document.getElementById('z-report_form').hidden = true;

        z_counter = 0;
      }
    });
    let x_counter = 0;
    document.getElementById('x-submit').addEventListener('click',()=> {
      document.getElementById('z-report_form').hidden = true;
      if(x_counter==0) {
        document.getElementById('x-report_form').hidden = false;

        x_counter=1;
        z_counter=0;
      }else {
        document.getElementById('x-report_form').hidden = true;

        x_counter = 0;
      }
    });

  </script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>

  <script src="${pageContext.request.contextPath}/assets/js/wow.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</header>
</body>
</html>
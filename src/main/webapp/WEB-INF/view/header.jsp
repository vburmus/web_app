<%@ page import="com.my.model.Employee" %>
<%@ page import="com.my.db.Fields" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css"/>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous"/>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>

</head>
<body>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="language"/>
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
              <ul  class="navbar-nav">
                <li class="nav-item">

                  <form method="post" action="controller">
                  <input type="hidden" name="lang" value="en">
                  <input type="hidden" name="command" value="LANG_SETUP">
                    <button class="btr bg-transparent text-white border-0" type="submit"><a><fmt:message key="_en"/></a></button>
                  </form>
                </li>
                <li class="nav-item">
                  <form method="post" action="controller">
                    <input type="hidden" name="lang" value="ua">
                    <input type="hidden" name="command" value="LANG_SETUP">
                    <button class="btr bg-transparent text-white border-0" type="submit"><a ><fmt:message key="_ua"/></a></button>
                  </form>
                </li>
              </ul>
              <ul  class="navbar-nav ms-auto">
                <li class="nav-item">

                  <c:choose>
                  <c:when test="${(pageContext.session.getAttribute('user')==null) }">

                    <a class="page-scroll active" href="#home"><fmt:message key="header_home"/></a>
                  </c:when>
                    <c:when test="${pageContext.session.getAttribute('user')!=null}">
                      <a  href="${pageContext.request.contextPath}/controller?command=PROFILE_PAGE"><fmt:message key="header_profile"/></a>
                    </c:when>
                  </c:choose>

                </li>
                <li class="nav-item">
                  <c:choose>
                    <c:when test="${(pageContext.session.getAttribute('user')==null)}">
                      <a class="page-scroll" href="#features"><fmt:message key="features"/></a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.ADMIN)}">
                      <a  class="" href="${pageContext.request.contextPath}/controller?command=EMPLOYEES_PAGE&page=1"><fmt:message key="header_employees"/></a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.COMMODITY_EXERT)}">
                      <a  href="${pageContext.request.contextPath}/controller?command=PRODUCTS_PAGE&page=1"><fmt:message key="header_products"/></a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.CASHIER||(pageContext.session.getAttribute('user').role==Fields.SENIOR_CASHIER))}">
                      <a  href="${pageContext.request.contextPath}/controller?command=ORDERS_PAGE&page=1"><fmt:message key="header_orders"/></a>
                    </c:when>
                  </c:choose>

                </li>
                <li class="nav-item">
                  <c:choose>
                    <c:when test="${(pageContext.session.getAttribute('user')==null)}">
                      <a class="page-scroll" href="#about"><fmt:message key="_about"/></a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.ADMIN)}">
                      <a  href="${pageContext.request.contextPath}/controller?command=ORDERS_PAGE&page=1"><fmt:message key="header_orders"/></a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.COMMODITY_EXERT)}">
                      <a  href="${pageContext.request.contextPath}/controller?command=NEW_PRODUCT_PAGE"><fmt:message key="header_addProduct"/></a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.CASHIER)}">
                      <a  href="${pageContext.request.contextPath}/controller?command=TRANSACTION_PAGE"><fmt:message key="header_createOrder"/></a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.SENIOR_CASHIER)}">
                        <a href="javascript:void(0)" data-backdrop="false"  data-bs-toggle="modal" data-bs-target="#exampleModal">
                          <fmt:message key="header_reports"/>
                        </a>
                    </c:when>
                  </c:choose>

                </li>

                <li class="nav-item">
                  <c:choose>
                    <c:when test="${(pageContext.session.getAttribute('user')==null)}">
                      <a class="page-scroll" href="#why"><fmt:message key="why"/></a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user').role==Fields.CASHIER)}">
                      <a  href="${pageContext.request.contextPath}/controller?command=PRODUCTS_PAGE&page=1"><fmt:message key="header_products"/></a>
                    </c:when>
                  </c:choose>

                </li>
                <li class="nav-item">

                  <c:choose>
                    <c:when test="${(pageContext.session.getAttribute('user')==null)}">
                      <a id="navbarSignIn" href="${pageContext.request.contextPath}/controller?command=LOGIN_PAGE"><fmt:message key="signIn"/> </a>
                    </c:when>
                    <c:when test="${(pageContext.session.getAttribute('user')!=null)}">
                      <a href="${pageContext.request.contextPath}/controller?command=LOGOUT"><fmt:message key="header_logOut"/></a>
                    </c:when>
                  </c:choose>

                </li>
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
                <button  type="submit"><fmt:message key="header_createReport"/></button>
              </form>
              </div>
              <div id="x-report_form" hidden>
                <form  method="post" action="controller">
                  <input type="hidden" name="command" value="X_REPORT">
                  <input placeholder="Selected date" name="fromDay" type="date" class="form-control datepicker" >
                  <input placeholder="Selected date" name="toDay" type="date" class="form-control datepicker" >
                  <button  type="submit"><fmt:message key="header_createReport"/></button>
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
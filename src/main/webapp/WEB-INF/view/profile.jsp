
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "com.my.DAO.DB.Fields" %>
<%@ page import="com.my.Model.Employee" %>
<%@ page import="com.my.Command.PageEnum" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/lineicons.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/profile.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>
<jsp:useBean id="user" type="com.my.Model.Employee" scope="session"/>
</head>
<body>
<%
    System.out.println(((Employee)pageContext.getSession().getAttribute("user")).getRole());
%>
<jsp:include page="header.jsp"/>


    <div class="row d-flex align-items-center justify-content-center">
        <div class="col-12">
            <div class="hero-content text-center ">
                <img src="${pageContext.request.contextPath}/assets/img/users/${user.imageName}" class="hero-img rounded-3">

                <div class="row justify-content-center mt-4">
                    <div class="col-2">
                        <c:choose>
                        <c:when test="${user.role==Fields.ADMIN}">
                        <h5  class="">Your id</h5>
                            <p>${user.id}</p>
                        </c:when>
                            <c:when test="${user.role!=Fields.ADMIN}">
                                <h5  class="">Orders</h5>
                                <p>${user.orders}</p>
                            </c:when>

                        </c:choose>

                    </div>
                    <div class="col-4">
                        <h5  class="">Role</h5>
                        <p class="">${user.roleName}</p>
                    </div>
                    <div class="col-2">
                        <h5  class="">Email</h5>
                        <p class="">${user.email}</p>
                    </div>
                </div>
            </div>


            <div class="row text-start mt-4  justify-content-center">

                <div class="col-10 ">
                    <p>${user.profile}</p>
                </div>


            </div>
        </div>
    </div>

</section>
</body>
</html>

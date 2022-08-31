
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "com.my.DB.Fields" %>
<%@ page import="com.my.Model.Employee" %>
<%@ page import="com.my.Command.Enums.PageEnum" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="language"/>
<jsp:include page="header.jsp"/>


    <div class="row d-flex align-items-center justify-content-center">
        <div class="col-12">
            <div class="hero-content text-center ">
                <img src="${pageContext.request.contextPath}/assets/img/users/${user.imageName}" class="hero-img rounded-3">

                <div class="row justify-content-center mt-4">
                    <div class="col-2">
                        <c:choose>
                        <c:when test="${user.role==Fields.ADMIN}">
                        <h5  class=""><fmt:message key="profile_id"/></h5>
                            <p>${user.id}</p>
                        </c:when>
                            <c:when test="${user.role!=Fields.ADMIN}">
                                <h5  class=""><fmt:message key="profile_orders"/></h5>
                                <p>${user.orders}</p>
                            </c:when>

                        </c:choose>

                    </div>
                    <div class="col-4">
                        <h5  class=""><fmt:message key="_role"/></h5>
                        <p class="">${user.roleName}</p>
                    </div>
                    <div class="col-2">
                        <h5  class=""><fmt:message key="_email"/></h5>
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

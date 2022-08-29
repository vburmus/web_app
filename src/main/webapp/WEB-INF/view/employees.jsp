<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/employees.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>
<jsp:useBean id="employee" scope="request" type="com.my.Model.Employee"/>
    <jsp:useBean id="user" scope="session" type="com.my.Model.Employee"/>
</head>
<body>
<jsp:include page="header.jsp" />
<c:choose>
<c:when test="${employee==null}">
    <div class="message">
        <div class="row ">
            <div class="bg-warning rounded-3 col-8 offset-2">
                <h3 class="text-white">Please add orders!</h3>
            </div>
        </div>
    </div>
</c:when>
<c:when test="${employee!=null}">
<div class="row">

        <div class="col-12">
        <section class="vh-100" >
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-lg-9 ">
                        <div class="card mb-3" style="border-radius: .5rem;">
                            <div class="row g-0">
                                <div class="col-md-4 gradient-custom text-center text-white"
                                     style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
                                    <img src="${pageContext.request.contextPath}/assets/img/users/${employee.imageName}"
                                         alt="Avatar" class="img-fluid my-5" style="width: 150px;" />
                                    <h5>${employee.name} ${employee.surname}</h5>
                                    <p>${employee.roleName}</p>
                                    <i class="far fa-edit mb-5"></i>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body p-4">
                                        <h6>Information</h6>
                                        <hr class="mt-0 mb-4">
                                        <div class="row pt-1">
                                            <div class="col-6 mb-3">
                                                <h6>Email</h6>
                                                <p class="text-muted tex">${employee.email}</p>
                                            </div>
                                            <div class="col-6 mb-3">
                                                <h6>Phone</h6>
                                                <p class="text-muted">${employee.mobile}</p>
                                            </div>
                                        </div>

                                        <hr class="mt-0 mb-4">
                                        <div class="row pt-1">
                                            <div class="col-6 mb-3">
                                                <form action="controller" method="post">
                                                    <input type="hidden" name="email" value="${employee.email}">
                                                    <input type="hidden" name="command" value="UPDATE_ROLES">
                                                    <input type="hidden" name="page" value="${page}">
                                                    <div class="form-group">
                                                        <h6 >Role:</h6>
                                                        <p>${employee.roleName}</p>
                                                        <c:if test="${user.role==1 && employee.role!=1}">
                                                        <label for="selectRole">Change Role</label>
                                                        <select class="form-control" id="selectRole" name="selectRole">
                                                            <c:forEach var="role" items="${roles}">
                                                                <option>${role}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
                                                    </c:if>
                                                </form>
                                            </div>
                                            <div class="col-6 mb-3">
                                                <h6>Orders</h6>
                                                <p class="text-muted">${employee.orders}</p>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                            </div>
                    <div class="scroller">
                        <div class="row">
                            <div class="col-3 justify-content-start">
                                <c:if test="${page!=1}">
                                    <a id="prev" class="page-link text-center" href="${pageContext.request.contextPath}/controller?command=EMPLOYEES_PAGE&page=${page-1}" tabindex="-1">Previous</a>
                                </c:if>
                            </div>
                            <div class="col-6">
                            </div>

                            <div class="col-3 justify-content-end">
                                <c:if test="${page!=pages}">
                                    <a class="page-link text-center" href="${pageContext.request.contextPath}/controller?command=EMPLOYEES_PAGE&page=${page+1}">Next</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        </div >
    </div>
</c:when>
</c:choose>
      <%--  <c:if test="${user.getRole()!=1}">
        <div class="card mb-3" style="max-width: 540px;">
            <div class="row no-gutters">
                <div class="col-md-4">
                    <p>${user.getImageName()}</p>
                    <img src="${pageContext.request.contextPath}/assets/img/users/${user.getImageName()}" class="card-img" alt="...">
                </div>
                <div class="col-md-8">
                    <c class="card-body">

                        <h5 class="card-title">${user.getName()} ${user.getSurname()}</h5>
                        <p class="card-text">${user.getRole()}</p>
                        <p class="card-text" >${user.getEmail()}</p>
                        <c:choose>
                        <c:when test="${user.getRole()==0}">

                        </c:when>
                        <c:when test="${user.getRole()!=0}">
                            <p class="card-text">${user.getRole()}</p>
                        </c:when>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
        </c:if>--%>





</body>
</html>

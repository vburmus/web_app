<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.my.DAO.DB.Fields" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:useBean id="order" scope="request" type="com.my.Model.Order"/>
    <jsp:useBean id="user" scope="session" type="com.my.Model.Employee"/>
    <title>Title</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/order.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>
</head>
    <body>
    <jsp:include page="header.jsp"/>
    <div class="order w-75 ">
        <div class="order-section">

            <h2>Order number: ${order.id}</h2>
            <hr>
            <h6>Order summary: ${order.summary}</h6>
            <h6>Made by user: #${order.users_id} </h6>
            <h6>${order.date} </h6>
        </div>
        <hr>
        <div class="mt-1 text-center">
            <h3>Items in order:</h3>
            <c:forEach items="${order.transactions}" var="transaction">
            <div class="card mb-3">
                <div class="card-body">
                    <div class="row">
                    <div class="col-3">
                        <img class="orderImg" src="${pageContext.request.contextPath}/assets/img/items/${transaction.item.photo}"/>
                    </div>
                    <div class="col-9 text-start">
                        <p>${transaction.id}</p>
                        <p>${transaction.item.name}</p>
                        <hr>
                        <p>${transaction.quantity}pcs x ${transaction.item.price}$</p>
                        <c:choose>
                        <c:when test="${user.role==Fields.CASHIER}">
                        <form name="changePcs" method="post" action="controller">
                            <input type="hidden" name="command" value="CHANGE_QUANTITY">
                            <input type="hidden" name="transactionId" value="${transaction.id}">

                            <input class="quantityInput" class="col-2"  name="changedQuantity" type="number" min="1" placeholder="${transaction.quantity}pcs"/>
                            <c:if test="${errorMessage!=null}">
                                <p class="text-danger" >${errorMessage}</p>
                            </c:if>
                            <button class="quantitySubmit" type="submit" disabled  class="btn-light"> Submit</button>


                        </form>
                        </c:when>
                            <c:when test="${user.role==Fields.SENIOR_CASHIER}">
                                <form name="changePcs" method="post" action="controller">
                                    <input type="hidden" name="command" value="DELETE_TRANSACTION">
                                    <input type="hidden" name="transactionId" value="${transaction.id}">
                                    <button class="deleteSubmit" type="submit"   class="btn-light"> Delete item</button>
                                </form>
                            </c:when>
                        </c:choose>
                        <hr>
                        <p>Available: ${transaction.item.quantity}pcs</p>
                    </div>
                    </div>
                </div>
            </div>
            </c:forEach>
            <script type="text/javascript">

                let inputs = document.getElementsByClassName("quantityInput")
                let elements = document.getElementsByClassName("quantitySubmit");
                for(let i =0; i < elements.length; i++){
                    inputs[i].addEventListener("blur", ()=>{
                        if(inputs[i].value==""){
                            elements[i].disabled = true;
                        }else{
                            elements[i].disabled = false;
                        }
                    })


                }
            </script>
    </div>
    </div>
</body>
</html>

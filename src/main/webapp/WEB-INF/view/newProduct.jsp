<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>
</head>
<body>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="language"/>
<jsp:include page="header.jsp"/>

<div class="form">
    <div class="col-12">

        <form method="post" action="controller" enctype="multipart/form-data">
            <input type="hidden" name="command" value="NEW_PRODUCT">
            <div class="form-outline mb-4">
                <label class="form-label" for="productName"><fmt:message key="product_name"/></label>
                <input type="productName" id="productName" name="productName" class="form-control" />
            </div>
            <div class="form-outline mb-4">
                <label class="form-label" for="quantity"><fmt:message key="_quantity"/></label>
                <input type="number" id="quantity"  name="quantity" class="form-control" />

            </div>
            <div class="form-outline mb-4">
                <label class="form-label" for="productDescription"><fmt:message key="_about"/></label>
                <textarea type="text" id="productDescription" name="productDescription" class="form-control" rows="3" ></textarea>
            </div>
            <div class="form-outline mb-4">
                <label class="form-label" for="price"><fmt:message key="_price"/></label>
                <input type="price" id="price" name="price" class="form-control" />
            </div>
            <div class="form-outline mb-4">
                <label class="form-label" for="photo"><fmt:message key="_img"/></label>
                <input type="file" id="photo" name="photo" class="form-control" />
            </div>
            <div class="form-outline mb-4">

                <label><fmt:message key="product_category"/></label>
                <div class="col">
                    <div class="row">

                        <label for="newCategory"><input type="radio" name="newCategory" id="newCategory"> <fmt:message key="product_newCategory"/></label>
                    </div>
                    <div class="row">

                        <label for="chooseCategory"><input type="radio" name="chooseCategory" id="chooseCategory"> <fmt:message key="product_chooseCategory"/></label>
                    </div>
                </div>
                <script type="text/javascript">
                    document.getElementById('newCategory').addEventListener('click',()=> {
                    document.getElementById('chooseCategoryDiv').hidden = true;
                        document.getElementById('addButton').hidden = true;
                        document.getElementById('newCategoryDiv').hidden = false;
                        document.getElementById('chooseCategory').checked = false;

                });
                    document.getElementById('chooseCategory').addEventListener('click',()=> {
                        document.getElementById('addButton').hidden = false;
                        document.getElementById('chooseCategoryDiv').hidden = false;
                        document.getElementById('newCategoryDiv').hidden = true;
                        document.getElementById('newCategory').checked = false;

                    });
                </script>

                <div id="chooseCategoryDiv" hidden>
                <select class="form-control" id="selectCategory" name="selectCategory">
                    <option></option>
                    <c:forEach var="category" items="${categories}">
                            <option>${category.name}</option>
                        </c:forEach>
                </select>
                </div>
                <tf:error message="${errorMessage}"/>
            </div>


            <!-- 2 column grid layout for inline styling -->


            <!-- Submit button -->
            <button type="submit" class="btn btn-primary btn-block" id="addButton"><fmt:message key="transaction_add"/></button>

        </form>
        <div id="newCategoryDiv" hidden>
            <form method="post" action="controller">
                <input type="hidden" name="command" value="ADD_CATEGORY">
                <div class="form-outline mb-4">
                    <label class="form-label" for="categoryName"><fmt:message key="product_categoryName"/></label>
                    <input type="categoryName" id="categoryName" name="categoryName" class="form-control" />
                    <label class="form-label" for="categoryTitle"><fmt:message key="_title"/></label>
                    <input type="categoryTitle" id="categoryTitle" name="categoryTitle" class="form-control" />

                </div>
                <button type="submit"  class="btn btn-primary btn-block"><fmt:message key="_add"/></button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

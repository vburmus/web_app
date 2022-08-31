<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: burmus
  Date: 8/21/2022
  Time: 12:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/lineicons.css"/>
</head>
<body>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="language"/>
<!-- ======== footer start ======== -->
<footer class="footer">
    <div class="container">
        <div class="widget-wrapper">
            <div class="row">
                <div class="col-4">
                <div class="footerLogo">
                    <a href="index.jsp">
                        <i class="lni lni-investment"></i>
                    </a>
                </div>
                <div class="footer-widget">

                    <p class="desc mb-30 text-white">
                        <fmt:message key="footer_description"/> </p>
                    <ul class="socials">
                        <li>
                            <a href="jvascript:void(0)">
                                <i class="lni lni-facebook-filled"></i>
                            </a>
                        </li>
                        <li>
                            <a href="jvascript:void(0)">
                                <i class="lni lni-twitter-filled"></i>
                            </a>
                        </li>
                        <li>
                            <a href="jvascript:void(0)">
                                <i class="lni lni-instagram-filled"></i>
                            </a>
                        </li>
                        <li>
                            <a href="jvascript:void(0)">
                                <i class="lni lni-linkedin-original"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

                <div class="col-8">
                    <div class="row">
                <div class="col-6">
                    <div class="footer-widget">
                        <h3>About Us</h3>
                        <ul class="links">
                            <li><a href="javascript:void(0)"><fmt:message key="footer_home"/></a></li>
                            <li><a href="javascript:void(0)"><fmt:message key="features"/></a></li>
                            <li><a href="javascript:void(0)"><fmt:message key="_about"/></a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-6">
                    <div class="footer-widget">
                        <h3>Features</h3>
                        <ul class="links">
                            <li><a href="javascript:void(0)"><fmt:message key="footer_howItWorks"/></a></li>
                            <li><a href="javascript:void(0)"><fmt:message key="footer_TermsOfService"/></a></li>
                        </ul>
                    </div>
                </div>

            </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- ======== footer end ======== -->
</body>
</html>

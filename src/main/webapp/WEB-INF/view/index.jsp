<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="cash-register" prefix="mtl"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html class="no-js" lang="">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>The Cash Register</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/lineicons.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css"/>
    </head>
<body>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="language"/>
<jsp:include page="header.jsp"/>
<input type="hidden" id="access" value="${pageContext.servletContext.getAttribute("access")}">
<script type="text/javascript">
   window.onload = function (){
       let access = document.getElementById('access').value;
       if(access=='false') {
           let signIn = document.getElementById('signIn');
           let signUp = document.getElementById('signUp');
            let navSignIn = document.getElementById('navbarSignIn')
           signIn.addEventListener('click',function (e){
               swal("Database Alert", "You are not allowed to visit another pages! Your database isn`t available", "error");
               e.preventDefault();
           })
           signUp.addEventListener('click',function (e){
               swal("Database Alert", "You are not allowed to visit another pages! Your database isn`t available", "error");
               e.preventDefault();
           })
           navSignIn.addEventListener('click',function (e){
               swal("Database Alert", "You are not allowed to visit another pages! Your database isn`t available", "error");
               e.preventDefault();
           })

       }
   }
</script>
<section id="home" class="hero-section">
    <div class="container">
        <div class="row align-items-center position-relative">
            <div class="col-lg-12">
                <div class="hero-content">
                    <h1 class="wow fadeInUp" data-wow-delay=".4s">
                        <fmt:message key="index_start"/>
                    </h1>
                    <p class="wow fadeInUp" data-wow-delay=".6s">
                            <fmt:message key="index_business"/>
                    </p>
                    <a id="signIn"
                            href="${pageContext.request.contextPath}/controller?command=LOGIN_PAGE"
                            class="btn main-btn border-btn btn-hover wow fadeInUp"
                            data-wow-delay=".6s"
                    > <fmt:message key="signIn"/> </a
                    >
                    <a id="signUp"
                            href="${pageContext.request.contextPath}/controller?command=REGISTER_PAGE"
                            class="btn main-btn border-btn btn-hover wow fadeInUp"
                            data-wow-delay=".6s"
                    > <fmt:message key="signUp"/></a
                    >
                    
                    <div class="scroll-arrow wow fadeInUp" data-wow-delay=".6s">
                    <a href="#features" class="scroll-bottom">
                        <i class="lni lni-arrow-down"></i
                        ></a>
                </div>
                </div>
                
            </div>
            
        </div>
    </div>
</section>
<!-- ======== hero-section end ======== -->

<!-- ======== feature-section start ======== -->
<section id="features" class="feature-section pt-120">
    <div class="container">
        <div class="row justify-content-center mt-5">
            <div class="col-lg-4 col-md-8 col-sm-10">
                <div class="single-feature">
                    
                    <div class="content">
                        <h3> <fmt:message key="index_why1"/></h3>
                        <p> <fmt:message key="index_freeCashregister"/> </p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-8 col-sm-10">
                <div class="single-feature">
                   
                    <div class="content">
                        <h3> <fmt:message key="index_design"/></h3>
                        <p>  <fmt:message key="index_designDescription"/></p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-8 col-sm-10">
                <div class="single-feature">
                    <div class="content">
                        <h3> <fmt:message key="index_easyToUse"/></h3>
                        <p><fmt:message key="index_easyToUseDescription"/></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section id="about" class="about-section pt-150">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-xl-12 col-lg-12 text-center">
                <div class="about-content">
                    <div class="section-title mb-30">
                        <h2 class="mb-25 wow fadeInUp" data-wow-delay=".2s">
                           <fmt:message key="index_addAndDelete"/>
                        </h2>
                        <p class="wow fadeInUp" data-wow-delay=".4s">
                               <fmt:message key="index_addAndDelete_description"/>
                        </p>
                    </div>
                    <div class="row mb-5">
                        <div class="col-3"></div>
                        <div class="col-6">
                    <ul class="text-start">
                        <li> <fmt:message key="index_fastAdd"/></li>
                        <li> <fmt:message key="index_manageOrders"/></li>
                        <li> <fmt:message key="index_freeReports"/></li>
                    </ul>
                    <a
                            href="javascript:void(0)"
                            class="btn main-btn btn-hover border-btn wow fadeInUp"
                            data-wow-delay=".6s"
                    ><fmt:message key="index_how"/></a
                    >
                        </div>
                        <div class="col-3"></div>
                </div>
            </div>

            </div>
        </div>
    </div>
</section>
<!-- ======== about2-section end ======== -->

<!-- ======== feature-section start ======== -->
<section id="why" class="feature-extended-section pt-100">
    <div class="feature-extended-wrapper">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-xxl-5 col-xl-6 col-lg-8 col-md-9">
                    <div class="section-title text-center mb-60">
                        <h2 class="mb-25 wow fadeInUp" data-wow-delay=".2s">
                                               <fmt:message key="index_why"/>
                        </h2>
                        <p class="wow fadeInUp" data-wow-delay=".4s">
                                                   <fmt:message key="index_whyDescription"/>
                        </p>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-dollar"></i>
                        </div>
                        <div class="content">
                            <h3><fmt:message key="index_why1"/></h3>
                            <p>
                                O<fmt:message key="index_why1_Description"/>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-grid-alt"></i>
                        </div>
                        <div class="content">
                            <h3><fmt:message key="index_why2"/></h3>
                            <p>
                                                           <fmt:message key="index_why2_Description"/>   </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-angle-double-right"></i>
                        </div>
                        <div class="content">
                            <h3><fmt:message key="index_why3"/></h3>
                            <p><fmt:message key="index_why3_Description"/>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-key"></i>
                        </div>
                        <div class="content">
                            <h3><fmt:message key="index_why4"/></h3>
                            <p><fmt:message key="index_why4_Description"/>   </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-layers"></i>
                        </div>
                        <div class="content">
                            <h3><fmt:message key="index_why5"/></h3>
                            <p> <fmt:message key="index_why5_Description"/></p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-consulting"></i>
                        </div>
                        <div class="content">
                            <h3><fmt:message key="index_why6"/></h3>
                            <p><fmt:message key="index_why6_Description"/>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"/>


<a href="#" class="scroll-top ">
    <i class="lni lni-arrow-up"></i>
</a>

</body>
</html>

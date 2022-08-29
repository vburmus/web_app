<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<!-- ======== header start ======== -->
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
                        Start selling with this web application
                    </h1>
                    <p class="wow fadeInUp" data-wow-delay=".6s">
                        The cash register, which you can simply use with your business
                    </p>
                    <a id="signIn"
                            href="${pageContext.request.contextPath}/controller?command=LOGIN_PAGE"
                            class="btn main-btn border-btn btn-hover wow fadeInUp"
                            data-wow-delay=".6s"
                    >Sign in </a
                    >
                    <a id="signUp"
                            href="${pageContext.request.contextPath}/controller?command=REGISTER_PAGE"
                            class="btn main-btn border-btn btn-hover wow fadeInUp"
                            data-wow-delay=".6s"
                    >Sign up </a
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
        <div class="row justify-content-center">
            <div class="col-lg-4 col-md-8 col-sm-10">
                <div class="single-feature">
                    
                    <div class="content">
                        <h3>Free in use</h3>
                        <p>
                            This web application was made for people, who needs a free cash register for business.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-8 col-sm-10">
                <div class="single-feature">
                   
                    <div class="content">
                        <h3>Clean Design</h3>
                        <p>
                            Simple and understandable interface, even your kid can use it!
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-8 col-sm-10">
                <div class="single-feature">
                    <div class="content">
                        <h3>Easy to Use</h3>
                        <p>
                            To start working with our web-app you only need to register and make a first check.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ======== feature-section end ======== -->

<!-- ======== about-section start ======== -->

<!-- ======== about2-section start ======== -->
<section id="about" class="about-section pt-150">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-xl-6 col-lg-6">
                <div class="about-content">
                    <div class="section-title mb-30">
                        <h2 class="mb-25 wow fadeInUp" data-wow-delay=".2s">
                            You can easily add and delete goods
                        </h2>
                        <p class="wow fadeInUp" data-wow-delay=".4s">
                            To make a position, your commodity expert only must push few buttons, after that
                            cashier can make an order as fast as possible!
                        </p>
                    </div>
                    <ul>
                        <li>Fast position adding</li>
                        <li>Easily to manage orders</li>
                        <li>Free reports</li>
                    </ul>
                    <a
                            href="javascript:void(0)"
                            class="btn main-btn btn-hover border-btn wow fadeInUp"
                            data-wow-delay=".6s"
                    >Learn how to work with our app</a
                    >
                </div>
            </div>
            <div class="col-xl-6 col-lg-6 order-first order-lg-last">
                <div class="about-img-2">
                    <img src="../../assets/img/about/about-2.png" alt="" class="w-100" />
                    <img
                            src="../../assets/img/about/about-right-shape.svg"
                            alt=""
                            class="shape shape-1"
                    />
                    <img
                            src="../../assets/img/about/right-dots.svg"
                            alt=""
                            class="shape shape-2"
                    />
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
                            Why ours cash register?
                        </h2>
                        <p class="wow fadeInUp" data-wow-delay=".4s">
                            Here you can read some pros of our application:
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
                            <h3>Free</h3>
                            <p>
                                Our app is absolutely free! No subscriptions, no payments.
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
                            <h3>Awesome Design</h3>
                            <p>
                                Our developers tried to make a simple-to-use design,we think they have got it!
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-angle-double-right"></i>
                        </div>
                        <div class="content">
                            <h3>Ready to Use</h3>
                            <p>
                                Register and start, only 2 steps to catch a profit.
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
                            <h3>Roles</h3>
                            <p>
                                You can quickly add your employees and give them roles, but don`t give your admin`s password to anyone)
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-layers"></i>
                        </div>
                        <div class="content">
                            <h3>The best app for Start</h3>
                            <p>
                                If you want to start your business, our app will help you to manage your goods!
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-consulting"></i>
                        </div>
                        <div class="content">
                            <h3>Fast support</h3>
                            <p>
                                If you need some help, you can contact with us!
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ======== feature-section end ======== -->

<!-- ======== subscribe-section start ======== -->

<!-- ======== subscribe-section end ======== -->
<jsp:include page="footer.jsp"/>

<!-- ======== scroll-top ======== -->
<a href="#" class="scroll-top ">
    <i class="lni lni-arrow-up"></i>
</a>

<!-- ======== JS here ======== -->

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html class="no-js" lang="">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>The Cash Register</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <style>
    <%@include file="assets/css/bootstrap.min.css" %>
    <%@include file="assets/css/animate.css"%>
    <%@include file="assets/css/login.css"%>
    </style>
    </head>
<body>

<!-- ======== preloader start ======== -->
<div class="preloader">
    <div class="loader">
        <div class="spinner">
            <div class="spinner-container">
                <div class="spinner-rotator">
                    <div class="spinner-left">
                        <div class="spinner-circle"></div>
                    </div>
                    <div class="spinner-right">
                        <div class="spinner-circle"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- preloader end -->

<!-- ======== header start ======== -->
<jsp:include page="WEB-INF/view/header.jsp"/>
<!-- ======== header end ======== -->

<!-- ======== hero-section start ======== -->
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
                    <a
                            href="/cashregister/login"
                            class="main-btn border-btn btn-hover wow fadeInUp"
                            data-wow-delay=".6s"
                    >Sign in | Sing up</a
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
<section id="about" class="about-section pt-150">
  
            <div class="col-xl-6 col-lg-6">
                <div class="about-content">
                    <div class="section-title mb-30">
                        <h2 class="mb-25 wow fadeInUp" data-wow-delay=".2s">
                            Perfect Solution Thriving Online Business
                        </h2>
                        <p class="wow fadeInUp" data-wow-delay=".4s">
                            Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
                            dinonumy eirmod tempor invidunt ut labore et dolore magna
                            aliquyam erat, sed diam voluptua. At vero eos et accusam et
                            justo duo dolores et ea rebum. Stet clita kasd gubergren, no
                            sea takimata sanctus est Lorem.Lorem ipsum dolor sit amet.
                        </p>
                    </div>
                    <a
                            href="javascript:void(0)"
                            class="main-btn btn-hover border-btn wow fadeInUp"
                            data-wow-delay=".6s"
                    >Discover More</a>
                </div>
            </div>
       
</section>
<!-- ======== about-section end ======== -->

<!-- ======== about2-section start ======== -->
<section id="about" class="about-section pt-150">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-xl-6 col-lg-6">
                <div class="about-content">
                    <div class="section-title mb-30">
                        <h2 class="mb-25 wow fadeInUp" data-wow-delay=".2s">
                            Easy to Use with Tons of Awesome Features
                        </h2>
                        <p class="wow fadeInUp" data-wow-delay=".4s">
                            Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
                            diam nonumy eirmod tempor invidunt ut labore et dolore magna
                            aliquyam erat, sed diam voluptua.
                        </p>
                    </div>
                    <ul>
                        <li>Quick Access</li>
                        <li>Easily to Manage</li>
                        <li>24/7 Support</li>
                    </ul>
                    <a
                            href="javascript:void(0)"
                            class="main-btn btn-hover border-btn wow fadeInUp"
                            data-wow-delay=".6s"
                    >Learn More</a
                    >
                </div>
            </div>
            <div class="col-xl-6 col-lg-6 order-first order-lg-last">
                <div class="about-img-2">
                    <img src="assets/img/about/about-2.png" alt="" class="w-100" />
                    <img
                            src="assets/img/about/about-right-shape.svg"
                            alt=""
                            class="shape shape-1"
                    />
                    <img
                            src="assets/img/about/right-dots.svg"
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
                            Why Choose SaaSpal
                        </h2>
                        <p class="wow fadeInUp" data-wow-delay=".4s">
                            Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
                            diam nonumy eirmod tempor invidunt ut labore et dolore
                        </p>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-display"></i>
                        </div>
                        <div class="content">
                            <h3>SaaS Focused</h3>
                            <p>
                                Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
                                diam nonumy eirmod tempor invidunt ut labore
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-leaf"></i>
                        </div>
                        <div class="content">
                            <h3>Awesome Design</h3>
                            <p>
                                Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
                                diam nonumy eirmod tempor invidunt ut labore
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
                            <h3>Ready to Use</h3>
                            <p>
                                Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
                                diam nonumy eirmod tempor invidunt ut labore
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-javascript"></i>
                        </div>
                        <div class="content">
                            <h3>Vanilla JS</h3>
                            <p>
                                Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
                                diam nonumy eirmod tempor invidunt ut labore
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
                            <h3>Essential Sections</h3>
                            <p>
                                Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
                                diam nonumy eirmod tempor invidunt ut labore
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="single-feature-extended">
                        <div class="icon">
                            <i class="lni lni-rocket"></i>
                        </div>
                        <div class="content">
                            <h3>Highly Optimized</h3>
                            <p>
                                Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
                                diam nonumy eirmod tempor invidunt ut labore
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

<!-- ======== footer start ======== -->
<footer class="footer">
    <div class="container">І
        <div class="widget-wrapper">
            <div class="row">
                <div class="col-xl-4 col-lg-4 col-md-6">
                    <div class="footer-widget">
                        <div class="logo mb-30">
                            <a href="index.jsp">
                                <img src="assets/img/logo/logo.svg" alt="" />
                            </a>
                        </div>
                        <p class="desc mb-30 text-white">
                            Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
                            dinonumy eirmod tempor invidunt.
                        </p>
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

                <div class="col-xl-2 col-lg-2 col-md-6">
                    <div class="footer-widget">
                        <h3>About Us</h3>
                        <ul class="links">
                            <li><a href="javascript:void(0)">Home</a></li>
                            <li><a href="javascript:void(0)">Feature</a></li>
                            <li><a href="javascript:void(0)">About</a></li>
                            <li><a href="javascript:void(0)">Testimonials</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-xl-3 col-lg-3 col-md-6">
                    <div class="footer-widget">
                        <h3>Features</h3>
                        <ul class="links">
                            <li><a href="javascript:void(0)">How it works</a></li>
                            <li><a href="javascript:void(0)">Privacy policy</a></li>
                            <li><a href="javascript:void(0)">Terms of service</a></li>
                            <li><a href="javascript:void(0)">Refund policy</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-xl-3 col-lg-3 col-md-6">
                    <div class="footer-widget">
                        <h3>Other Products</h3>
                        <ul class="links">
                            <li><a href="jvascript:void(0)">Accounting Software</a></li>
                            <li><a href="jvascript:void(0)">Billing Software</a></li>
                            <li><a href="jvascript:void(0)">Booking System</a></li>
                            <li><a href="jvascript:void(0)">Tracking System</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- ======== footer end ======== -->

<!-- ======== scroll-top ======== -->
<a href="#" class="scroll-top btn-hover">
    <i class="lni lni-chevron-up"></i>
</a>

<!-- ======== JS here ======== -->
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/wow.min.js"></script>
<script src="assets/js/main.js"></script>
</body>
</html>

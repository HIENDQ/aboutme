<%@page import="utils.DefineUtil"%>
<%@page import="model.dao.InfoDAO"%>
<%@page import="model.bean.Info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Aboutme Ginyong</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />

  <!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/bootstrap.css">
	<!-- Flexslider  -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/flexslider.css">
	
	<!-- Owl Carousel -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/owl.carousel.min.css">
	
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/owl.theme.default.min.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/style.css">
	<!-- jQuery -->
	<script src="<%=request.getContextPath() %>/templates/public/js/jquery.min.js"></script>
	<!-- Modernizr JS -->
	<script src="<%=request.getContextPath() %>/templates/public/js/modernizr-2.6.2.min.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/public/js/jquery-3.4.1.min.js"></script>
	<!-- Validate -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/templates/public/js/jquery.validate.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>


	<div id="colorlib-page">
		<div class="container-wrap">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="border js-fullheight">
			<div class="text-center">
			<%
			InfoDAO  infoDAO = new InfoDAO();
			Info objInfo = infoDAO.getItems();
			System.out.print(objInfo);
			%>
				<div class="author-img" style="background-image: url(<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_PROJ %>/<%=infoDAO.getInfo().getPicture() %>);"></div>
				<h1 id="colorlib-logo"><a href="index.html"><%=objInfo.getFullname() %></a></h1>
				<span class="position"><a href="#"><%=objInfo.getPreview() %></a></span>
			</div>
			<nav id="colorlib-main-menu" role="navigation" class="navbar">
				<div id="navbar" class="collapse">
					<ul>
						<li class="active"><a href="#" data-nav-section="home">Home</a></li>
						
						<li><a  href="#about"  data-nav-section="about">About</a></li>
						<li><a href="#" data-nav-section="skills">Skills</a></li>
						<li><a href="#" data-nav-section="experience">Experience</a></li>
						<li><a href="#" data-nav-section="work">Work</a></li>
						<li><a href="#" data-nav-section="blog">Blog</a></li>
						<li><a href="#" data-nav-section="contact">Contact</a></li>
					</ul>
				</div>
			</nav>

			<div class="colorlib-footer">
				<p><small>Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="#" target="_blank">DQH</a>
				</small></p>
				<ul>
					<li><a href="#"><i class="icon-facebook2"></i></a></li>
					<li><a href="#"><i class="icon-twitter2"></i></a></li>
					<li><a href="#"><i class="icon-instagram"></i></a></li>
					<li><a href="#"><i class="icon-linkedin2"></i></a></li>
				</ul>
			</div>

		</aside>
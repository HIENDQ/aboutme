<%@page import="utils.DefineUtil"%>
<%@page import="model.dao.HomeDAO"%>
<%@page import="model.bean.Home"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="colorlib-hero" class="js-fullheight" data-section="home">
				<div class="flexslider js-fullheight">
					<ul class="slides">
					<%
					HomeDAO homeDAO = new HomeDAO();
					ArrayList<Home> listHome = homeDAO.getItemsByActive();
					if(listHome.size()>0) {
						for(Home home : listHome) {
					%>
					
				   	<li style="background-image: url(<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_HOM %>/<%=home.getPicture()%>);">
				   		<div class="overlay"></div>
				   		<div class="container-fluid">
				   			<div class="row">
					   			<div class="col-md-6 col-md-offset-3 col-md-pull-3 col-sm-12 col-xs-12 js-fullheight slider-text">
					   				<div class="slider-text-inner js-fullheight">
					   					<div class="desc">
						   					<h1><%=home.getDep() %></h1>
										</div>
					   				</div>
					   			</div>
					   		</div>
				   		</div>
				   	</li>
				   	<%
				   		}
					}
					%>
				  	</ul>
			  	</div>
			</section>
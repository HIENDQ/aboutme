<%@page import="model.bean.User"%>
<%@page import="model.dao.NewsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title id ="ttt">Aboutme-Trang chủ</title>
    <!-- BOOTSTRAP CORE STYLE  -->

    <script src="<%=request.getContextPath() %>/templates/admin/assets/js/jquery-3.3.1.min.js"></script>
    <script src="<%=request.getContextPath() %>/templates/admin/assets/js/jquery.validate.min.js"></script>
    <link href="<%=request.getContextPath() %>/templates/admin/assets/css/bootstrap.css" rel="stylesheet">
    <!-- FONT AWESOME STYLE  -->
    <link href="<%=request.getContextPath() %>/templates/admin/assets/css/font-awesome.css" rel="stylesheet">
    <!-- CUSTOM STYLE  -->
    <link href="<%=request.getContextPath() %>/templates/admin/assets/css/style.css" rel="stylesheet">
    <!-- GOOGLE FONT -->
    <link href="<%=request.getContextPath() %>/templates/admin/assets/css/css.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath() %>/templates/admin/assets/css/dataTables.bootstrap.css" rel="stylesheet">

    <script src="<%=request.getContextPath() %>/templates/admin/assets/js/ckeditor/ckeditor.js" type="text/javascript"></script><style>.cke{visibility:hidden;}</style>
    <script src="<%=request.getContextPath() %>/templates/admin/assets/js/ckfinder/ckfinder.js" type="text/javascript"></script>
    <style>
		.dropdown {
		    position: relative;
		    display: inline-block;
		}
		
		.dropdown-content {
		    display: none;
		    position: absolute;
		    background-color: #f9f9f9;
		    min-width: 160px;
		    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		    padding: 12px 16px;
		    z-index: 1;
		}
		
		.dropdown:hover .dropdown-content {
		    display: block;
		}
		.read-more-state {
		  display: none;
		}
		
		.read-more-target {
		  opacity: 0;
		  max-height: 0;
		  font-size: 0;
		  transition: .25s ease;
		}
		.read-more-state:checked ~ .read-more-wrap .read-more-target {
		  opacity: 1;
		  font-size: inherit;
		  max-height: 999em;
		}
		.read-more-state ~ .read-more-trigger:before {
		  content: 'Xem thêm';
		}
		.read-more-state:checked ~ .read-more-trigger:before {
		  content: 'Đóng';
		}
		.read-more-trigger {
		  cursor: pointer;
		  display: inline-block;
		  padding: 0 .5em;
		  color: #666;
		  font-size: .9em;
		  line-height: 2;
		  border: 1px solid #ddd;
		  border-radius: .25em;
		}

	</style>
</head>
<body>
    <div class="navbar navbar-inverse set-radius-zero">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <img src="">
                </a>
            </div>
            <div class="right-div">
            <%
            User useri = (User)session.getAttribute("userInfo");
            String nameUser = useri.getUsreName();
            %>
                <span class="" style="margin-right:10px;text-transform:uppercase;font-weight:
                 bold;padding-top:2%   ">Chào: <%=nameUser %></span>
                 <a href="<%=request.getContextPath() %>/logout" class="btn btn-danger pull-right">Đăng xuất</a>
           </div>
        </div>
    </div>
    <!-- LOGO HEADER END-->
    <section class="menu-section">
    <%
    int numberNoActive= 0;
    NewsDAO newsDAO = new NewsDAO();
    numberNoActive = newsDAO.getNumberNoactive();
    %>
        <div class="container">
            <div class="row ">
                <div class="col-md-12">
                    <div class="navbar-collapse collapse ">
                        <ul id="menu-top" class="nav navbar-nav navbar-right">
                            <li><a id= "tc" href="<%=request.getContextPath() %>/admin" >Trang chủ</a></li>
                            
                            <li class="dropdown"><a id= "post" href="javascript:void(0);" >Quản lý bài viết &nbsp;
	                            <span id="no_ac"><%if(numberNoActive>0){ %>
	                            	<span title="Có bài viết đang chờ kiểm duyệt" class="badge ac123" id="a_f"><%=numberNoActive %></span> <%} %>
	                            </span></a>
                                <ul class="dropdown-content aaa" style="list-style: none">
                                    	<li id="dm" ><a  href="<%=request.getContextPath() %>/admin/cats">danh mục</a></li>
                            			<li id= "tt" ><a  href="<%=request.getContextPath() %>/admin/news"> tin  tức  &nbsp;
	                            		<span id="no_ac1"><%if(numberNoActive>0){ %>
		                            	<span title="Có bài viết đang chờ kiểm duyệt" class="badge ac123"><%=numberNoActive %></span> <%} %>
		                            	</span></a>
                            			</li>
                            			<li id= "bl" ><a href="<%=request.getContextPath() %>/admin/comments"> Bình luận </a></li>
                                </ul>
                            </li> 
                            <li><a id ="user" href="<%=request.getContextPath() %>/admin/users" >Quản lý người dùng</a></li> 
							
							<li><a id ="contact"  href="<%=request.getContextPath() %>/admin/contacts" >Quản lý liên hệ</a></li> 
                            
                            <li class="dropdown"><a id ="tht" href="javascript:void(0);" >Quản lý thông tin</a>
                                <ul class="dropdown-content aaa" style="list-style: none">
                                  <li id ="info" ><a href="<%=request.getContextPath() %>/admin/info" "="">Thông tin</a></li> 
                                  <li id ="home" ><a href="<%=request.getContextPath() %>/admin/homes">Home</a></li> 
                                  <li id ="skill" ><a href="<%=request.getContextPath() %>/admin/skills">Kỹ năng</a></li> 
                                  <li id ="project" ><a href="<%=request.getContextPath() %>/admin/projects">Dự án</a></li> 
                                  <li id ="exp" ><a href="<%=request.getContextPath() %>/admin/exp" "="">Chặng đường</a></li> 
                                </ul>
                            </li> 
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </section>
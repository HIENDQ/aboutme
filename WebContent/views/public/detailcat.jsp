<%@page import="utils.StringUtil"%>
<%@page import="model.bean.Cat"%>
<%@page import="model.bean.New"%>
<%@page import="java.util.ArrayList"%>
<%@page import="utils.DefineUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Chi tiết</title>
	<!-- Animate.css -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/anim.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/styledetail.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/bootstrap.css">
		<!-- jQuery -->
	<script src="<%=request.getContextPath() %>/templates/public/js/jquery.min.js"></script>
	<!-- onlinefonts -->
	<link href="//fonts.googleapis.com/css?family=Dancing+Script:400,700" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Yanone+Kaffeesatz:200,300,400,700" rel="stylesheet">
</head>
<body>
<style type="text/css">
#myBtn {
  display: none;
  position: fixed;
  bottom: 20px;
  right: 30px;
  z-index: 99;
  font-size: 18px;
  border: none;
  outline: none;
   background-color: #555;
  color: white;
  cursor: pointer;
  padding: 15px;
  border-radius: 4px;
}

</style>

 
<button onclick="topFunction()" id="myBtn" title="Go to top" style="display: none;"><i class=" glyphicon glyphicon-chevron-up"></i></button>
<script>

window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("myBtn").style.display = "block";
    } else {
        document.getElementById("myBtn").style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}
</script>
	
		<!-- //header --><style type="text/css">
  p{color:black;
    font-size: 17px;
   /* font-family: 'Roboto', sans-serif;*/
  }
  img{
    width: 100%
  }
</style>


	<div class="about" id="blog">
		
<div class="container-fluid">
  <div class="row content" style="margin-top: 40px">
<div class="col-sm-3 sidenav">

    <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="#" style="background-color: #003322;font-size: 20px">Bài viết xem nhiều</a></li>
        <%if(request.getAttribute("listMostRead") != null) {
        	ArrayList<New> listMostRead = (ArrayList<New>)request.getAttribute("listMostRead");
        	if(listMostRead.size()>0){
        		for( New objNew : listMostRead){
        			
        	
        %>
        <li >
         <a href="<%=request.getContextPath()%>/detail/<%=StringUtil.makeSlug(objNew.getName_New())%>-<%=objNew.getId_New() %>">
          <img width="100%" height=""
           src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD %>/<%=objNew.getPicture_New() %>"
           alt="">
        </a>
          <h5 style="margin-left: 10%"><span class="glyphicon glyphicon-pencil"></span>  Admin &nbsp;&nbsp;  <span  class="  glyphicon glyphicon-eye-open"></span>  Lượt đọc:<%=objNew.getCount_New() %>.</h5>
          <a style="width:100% !important;padding:none;font-size: 16px"
           href="<%=request.getContextPath()%>/detail/<%=StringUtil.makeSlug(objNew.getName_New())%>-<%=objNew.getId_New() %>"><%=objNew.getName_New() %></a>
        
      </li>
      <%}}} %>
    </ul>
	<br>
  </div>

    <div class="col-sm-6">
      <br>
      <%
      Cat objCatDetail =(Cat)request.getAttribute("Cat");
      %>
      <h2 style="color:#003322" id= "<%=objCatDetail.getId_Cat()%>"><%=objCatDetail.getName_Cat() %></h2>
       
    <hr>
    
     <%if(request.getAttribute("listNewByCat")!= null){ 
    	 ArrayList<New> listNewByCat = (ArrayList<New>)request.getAttribute("listNewByCat");
    	 if(listNewByCat.size() > 0 ){
    		int i=1;
    		for(New objNew : listNewByCat ) {
     %>
   			
    		
     <div class="col-sm-6">
	    <a href="<%=request.getContextPath()%>/detail/<%=StringUtil.makeSlug(objNew.getName_New())%>-<%=objNew.getId_New() %>">
	     
	      <img src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD %>/<%=objNew.getPicture_New() %>" 
	      class="img-responsive" style="width:100%;height:180px " alt="Image"><br>
	      <h3><%=objNew.getName_New() %></h3><br><br>
	    </a> 
	    </div>
	  <%if(i%2==0){ %>
    	 <div class="clearfix"></div>
      <%}
	  i++;
	  }
    		
   	  }else {%>
    	<p> Không có bài viết nào.</p>
    <%}} %>
    



    </div>
    <div class="col-sm-3">
      <ul class="nav nav-pills nav-stacked">
	  
        <li class="active"><a href="#" style="background-color: #003322;font-size: 20px">Danh mục bài viết</a></li>
       <%if(request.getAttribute("listCat")!= null){
        	ArrayList<Cat> listCat = (ArrayList<Cat>)request.getAttribute("listCat");
        	if(listCat.size()>0) {
        		for( Cat objCat : listCat){
        			
        if(objCat.getId_Cat()==objCatDetail.getId_Cat()){	
        %>
         <li><a  style=" background-color:#787878;color: white;"
          href="<%=request.getContextPath() %>/cat/<%=StringUtil.makeSlug(objCat.getName_Cat()) %>-<%=objCat.getId_Cat()%>"><%=objCat.getName_Cat() %></a></li>
        <%}else { %>
        	<li><a  "style="font-size: 16px" href="<%=request.getContextPath() %>/cat/<%=StringUtil.makeSlug(objCat.getName_Cat()) %>-<%=objCat.getId_Cat()%>"><%=objCat.getName_Cat() %></a></li>	
        <%}}}} %> 
             
       </ul>
		<br>
    </div>
  </div>
</div>
		
	</div>

	<!-- modal -->
<div class="agileits_w3layouts-footer text-center">
  <div class="container">
    <p><small>Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="#" target="_blank">DQH</a>
	</small></p>
  </div>
</div>
</body>
</html>
<%@page import="utils.StringUtil"%>
<%@page import="model.bean.Comment"%>
<%@page import="model.bean.Cat"%>
<%@page import="utils.DefineUtil"%>
<%@page import="model.bean.New"%>
<%@page import="java.util.ArrayList"%>
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
         <a href="<%=request.getContextPath()%>/detail/<%=StringUtil.makeSlug(objNew.getName_New())%>-<%=objNew.getId_New() %>"  >
          <img width="100%" height=""
           src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD %>/<%=objNew.getPicture_New() %>"
           alt="">
        </a>
          <h5 style="margin-left: 10%"><span class="glyphicon glyphicon-pencil"></span>  <%=objNew.getCat_New().getName_Cat() %> &nbsp;&nbsp;  <span  class="  glyphicon glyphicon-eye-open"></span>  Lượt đọc:<%=objNew.getCount_New() %>.</h5>
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
      int idDetailCat=0;
      int id_New = 0;
      if(request.getAttribute("objNew")!= null) {
    	  New objNew = (New)request.getAttribute("objNew");
    	  
    	  if(objNew != null) {
    		  id_New = objNew.getId_New();
    		  idDetailCat = objNew.getCat_New().getId_Cat();
      %>
      <h2 style="color:#003322"><%=objNew.getCat_New().getName_Cat() %></h2>
       
    <hr>
    <h2 id="view"><%=objNew.getName_New() %></h2><br>
    <h5><span class="glyphicon glyphicon-pencil"></span>  Admin &nbsp;&nbsp;  <span class="  glyphicon glyphicon-eye-open"></span>  Lượt đọc:<%=objNew.getCount_New() %>.</h5><br>

    <p><%=objNew.getDetail_New() %></p>

	<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img alt="<%=objNew.getPicture_New() %>"
	src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD %>/<%=objNew.getPicture_New() %>" 
	style="height:500px; width:655px"></p>

	<p><%=objNew.getPreview_New() %></p>
	<%}}%>
    <br>
	<div class="hidden-form">
      <h2 style="color:#003322">Tham gia bình luận:</h2><br>
          <i class="er" style="color:red">

            </i>
      <form action="javascript:void(0)" onsubmit="cmt(<%=id_New%>)" method="post">
        <div class="form-group">
                    <input style="margin-bottom:0.5%;border-radius:3px" id="name" type="text" name="name" placeholder="nhập tên của bạn" required="required" value="">
                    <textarea class="form-control" name="content" id="content" placeholder="nhập bình luận" rows="3" required="required"></textarea>
      
       
        </div>
        <button type="submit" class="btn btn-success">Gửi bình luận</button>
      </form>
    </div>
      <br><br>
      <div class="show-cmt">
          <h2 style="color:#003322">Comment</h2><br>
          	<div class="row">
          <%if(request.getAttribute("listComment") != null) {
          	ArrayList<Comment> listComment = (ArrayList<Comment>)request.getAttribute("listComment");
          	if(listComment.size()>0) {
          		for(Comment objComment : listComment) {
          %>	
              <div class="col-sm-2 text-center">
          		<img src="<%=request.getContextPath() %>/templates/public/images/icon1.png" style="width: 80px !important; ">
          		<h4><%=objComment.getAuthor() %></h4>
        	</div>
        	<div class="col-sm-10">
         
          	<p><%=objComment.getContent() %></p>
          	<%
          	int ht= objComment.getTime().getHours();
			int mt= objComment.getTime().getMinutes();
			String h = "", m="";
			if(ht<10) {
				h= "0"+String.valueOf(ht);
			}else h = String.valueOf(ht);
			if(mt<10) {
				m= "0"+String.valueOf(mt);
			}else m= String.valueOf(mt);
			String date = h+":"+m+"|"+objComment.getDate();
          	%>
          	<p style="color: black;
    			font-size: 15px;font-family: monospace;"><%=date%></p>
          	<br>
        	</div>
        	<div class="clearfix"></div>
        
        <%}}} %>
        
        
        </div>
      </div>
<br><h2 style="color:#003322">BÀI VIẾT CÙNG CHUYÊN MỤC</h2>
      <div class="row">
	<%if(request.getAttribute("listNewByCat")!= null) { 
		ArrayList<New> listNew = (ArrayList<New>)request.getAttribute("listNewByCat");
		if(listNew.size()>1){
			for(New objNew : listNew){
				if(objNew.getId_New()!= id_New){
			
	%>
        <div class="col-sm-4">
    <a href="<%=request.getContextPath()%>/detail/<%=StringUtil.makeSlug(objNew.getName_New())%>-<%=objNew.getId_New() %>">
     
      <img src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD %>/<%=objNew.getPicture_New() %>"
       class="img-responsive" style="width:100%;height:180px " alt="Image"><br>
       <h3><%=objNew.getName_New() %></h3><br><br>
    </a> 
    </div>
    <%}}}else {
    	%>
    	<p>Không có bài viết nào.</p>
    	<%
    }} %>
      
   
  </div>

    </div>
    <div class="col-sm-3">
      <ul class="nav nav-pills nav-stacked">
	  
        <li class="active"><a href="#" style="background-color: #003322;font-size: 20px">Danh mục bài viết</a></li>
        <%if(request.getAttribute("listCat")!= null){
        	ArrayList<Cat> listCat = (ArrayList<Cat>)request.getAttribute("listCat");
        	if(listCat.size()>0) {
        		for( Cat objCat : listCat){
        			
        	if(objCat.getId_Cat()== idDetailCat){	
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
<script type="text/javascript">

function cmt(id){
  name = $('#name').val();
  content = $('#content').val();
 /* alert(content);*/
          $.ajax({
        	  url: '<%=request.getContextPath()%>/comment/news', 
            	type: 'POST',
            	dataType: 'html',
            	data: {
              		"id":id,
        			"name":name,
        			"content":content,
               
           	 	},
           	  	success: function(data){
       			 $('.show-cmt').html(data);
       			 $('.hidden-form').html('');
		      	},
			      error: function (){
			        alert('Có lỗi xảy ra');
      			}
    });
  //
  }
</script>

<div class="agileits_w3layouts-footer text-center">
  <div class="container">
    <p><small>Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="#" target="_blank">DQH</a>
	</small></p>
  </div>
</div>
 
</body>
</html>
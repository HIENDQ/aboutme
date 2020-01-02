<%@page import="model.dao.InfoDAO"%>
<%@page import="model.bean.Info"%>
<%@page import="utils.DefineUtil"%>
<%@page import="utils.CodeMessageUtil"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>

<div class="content-wrapper">
    <div class="container">
        <div class="row pad-botm">
            <div class="col-md-12">
                <h4 class="header-line">Quản lý thông tin cơ bản</h4>
                  
            </div>
        </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
               		<div class="panel panel-info">
                        <div class="panel-heading">
                          Sửa thông tin cơ bản
                        </div>
                        <div class="panel-body">
                        <%
                        
                        InfoDAO  infoDAO = new InfoDAO();
                        String ct="";
                        String img ="";
                        
                        
                        Info objInfo = (Info)request.getAttribute("objInfo");
                        if(objInfo!= null){
                        	ct= objInfo.getCt();
                        	img =objInfo.getImg();
                        	
                        }else {
                        	ct= request.getParameter("am");
                        	img = infoDAO.getAboutme().getImg();
                        }
                        %>
                            <form role="form" action="<%=request.getContextPath() %>/admin/info/editam" 
                            enctype="multipart/form-data" method="post" id= "form">
                                        <div class="form-group">
                                            <label for ="am">About me</label>
                                            <textarea class="form-control" rows="3" id= "am" name="am" required="required"><%=ct %></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for= "pc">Hình ảnh</label>
                                            <input type="file" name="picture" value="" id= "pc" name ="pc">
                                           
                                            <p class="help-block"></p>
                                            <img src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_PROJ %>/<%=img %>"
                                                 width="120px" alt=""> 
                                           
                                        </div>
                                        
                                        <input type="submit" name="submit" value="Sửa" class="btn btn-info">
                                 </form>
                            </div>
                        </div>
                  </div>
            </div>
                <!-- /. ROW  -->
           
    	</div>
    </div>
     <!-- CONTENT-WRAPPER SECTION END-->

     <!-- CONTENT-WRAPPER SECTION END-->
<script type="text/javascript">
	$().ready(function() {
		var validator =$("#form").validate({
			errorPlacement: function(error, element){
				$(element).closest("form").find("label[for='" + element.attr("id") + "']").append(error);
			},
			errorElement: "span",
			
			messages: {
				am:{
					required: " (Tên dự án không được trống)",
				},
				
				
				
			}
		});
	});

</script>
    <script>
    	document.getElementById("ttt").innerHTML = "Aboutme-Thông tin";
    	document.getElementById("info").classList.add('menu-top-active');
    	document.getElementById("tht").classList.add('menu-top-active');
	</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>
   


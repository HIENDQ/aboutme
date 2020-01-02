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
                        String name="";
                        String email ="";
                        String phone = "";
                        
                        String address ="";
                        String describe ="";
                        
                        Info objInfo = (Info)request.getAttribute("objInfo");
                        if(objInfo!= null){
                        	name= objInfo.getFullname();
                        	email = objInfo.getEmail();
                        	phone = objInfo.getPhone();
                        	address = objInfo.getAddress();
                        	describe = objInfo.getPreview();
                        }else {
                        	name= request.getParameter("name");
                        	email = request.getParameter("email");
                        	phone = request.getParameter("phone");
                        	address = request.getParameter("address");
                        	describe = request.getParameter("describe");
                        }
                        %>
                            <form role="form" action="<%=request.getContextPath() %>/admin/info/edit" 
                            enctype="multipart/form-data" method="post" id= "form">
                                        <div class="form-group">
                                            <label for ="name">FullName</label>
                                            <input class="form-control" type="text" id="name" name="name" value="<%=name%>" required="required">
                                        </div>
                                         <div class="form-group">
                                            <label for ="email">Email</label>
                                            <input class="form-control" type="text" id ="email"  name="email" value="<%=email%>" required="required">
                                        </div>
                                        <div class="form-group">
                                            <label for="phone">Phone</label>
                                            <input class="form-control" type="text" id= "phone" name="phone" value="<%=phone%>" required="required">
                                        </div>
                                        <div class="form-group">
                                            <label for ="address">Address</label>
                                            <input class="form-control" type="text" id= "address" name="address" value="<%=address%>" required="required">
                                        </div>
                                        <div class="form-group">
                                            <label for ="describe">Describe</label>
                                            <input class="form-control" type="text" id= "describe" name="describe" value="<%=describe%>" required="required">
                                        </div>
                                        
                                        
                                        <div class="form-group">
                                            <label>Hình ảnh</label>
                                            <input type="file" name="picture" value="">
                                           
                                            <p class="help-block"></p>
                                            <img src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_PROJ %>/<%=infoDAO.getInfo().getPicture() %>"
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
			rules :{
				phone :{
					number : true,
				},
				email :{
					email  : true,
				},
			},
			messages: {
				name:{
					required: " (Tên dự án không được trống)",
				},
				phone:{
					number :" (Sô điện thoại phải là số)" ,
					required: " (Giá trị không được trống)",
				},
				email:{
					email : " (Không đúng định dạng email)",
					required: " (Giá trị không được trống)",
				},
				address:{
					required: " (Giá trị không được trống)",
				},
				describe:{
					required: " ( không được trống)",
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
   


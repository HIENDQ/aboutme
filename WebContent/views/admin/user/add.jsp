<%@page import="model.dao.RoleDAO"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.LUSHR"%>
<%@page import="model.bean.Role"%>
<%@page import="model.bean.User"%>
<%@page import="utils.DefineUtil"%>
<%@page import="model.bean.New"%>
<%@page import="utils.CodeMessageUtil"%>
<%@page import="model.bean.Cat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
 <div class="content-wrapper">
         <div class="container">
        <div class="row pad-botm">
            <div class="col-md-12">
                <h4 class="header-line">Quản lý người dùng</h4>
                  <%
                if(request.getParameter("err")!= null) { 
                	String err="";
                	int code= Integer.parseInt(request.getParameter("err"));
                	switch(code) {
                		case 1:{
                			err ="Có lỗi xảy ra.";
                		}break;
                		case 2:{
                			err ="Username đã tồn tại.";
                		}break;
                		case 3:{
                			err ="Bạn đã sửa thành công.";
                		}break;
                		case 4:{
                			err ="Có lỗi xảy ra khi xóa.";
                		}break;
                	
                	}
                	out.print(CodeMessageUtil.disPlayMessage(out, err));
                } %> 
            </div>

        </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
               <div class="panel panel-info">
                        <div class="panel-heading">
                          Thêm người dùng
                        </div>
                        <div class="panel-body"><!-- <%=request.getContextPath() %>/admin/user/add -->
                            <form role="form" action="<%=request.getContextPath() %>/admin/user/add " method="post" id="form">
                                        <div class="form-group">
                                            <label for ="username">Username</label>
                                            <input class="form-control" type="text" id ="username" name="username" required="required" value="">
                                        </div>
                                         <div class="form-group">
                                            <label for ="password">Password</label>
                                            <input class="form-control" type="password" id= "password" name="password" required="required" value="">
                                        </div>
                                        <div class="form-group">
                                            <label for="fullname">Họ và tên</label>
                                            <input class="form-control" type="text" id= "fullname" name="fullname" required="required" value="">
                                        </div>
                                        <div class="form-group">
                                            <label for ="email">Email</label>
                                            <input class="form-control" type="email" id ="email" name="email" required="required" value="">
                                        </div>
                                         <div class="form-group">
                                            <label >Chức vụ</label>
                                            <select class="form-control"  name="role">
                                            	<% 
                                            		RoleDAO roleDAO = new RoleDAO();
                                            		ArrayList<Role> listRole = roleDAO.getItems();
                                            		if(listRole.size()>0) {
                                            			for(Role objRole : listRole){
                                            		%>
                                                <option value="<%=objRole.getId_Role()%>"><%=objRole.getFunc() %></option>
                                               <%}} %> 
                                            </select>
                                        </div>
                                        <input type="submit" name="submit" value="Thêm" class="btn btn-info">

                                    </form>
                            </div>
                        </div>
                            </div>
            </div>
                <!-- /. ROW  -->
           
    </div>
    </div>
     <!-- CONTENT-WRAPPER SECTION END-->
<script type="text/javascript">
	$().ready(function() {
		var validator =$("#form").validate({
			errorPlacement: function(error, element){
				$(element).closest("form").find("label[for='" + element.attr("id") + "']").append(error);
			},
			errorElement: "span",
			rules :{
				password :{
					minlength: 6,
				},
				email :{
					email : true,
				}
				
			},
			messages: {
				username:{
					required: " (Username không được trống)",
				},
				password:{
					required: " (Mật khẩu không được trống)",
					minlength :" (Vui lòng nhập mật khẩu dài hơn)"
				},
				fullname:{
					required: " (Tên đầy đủ không được trống)",
				},
				email:{
					required: " (Email không được trống)",
					email : " (Không đúng định dạng email)"
				},
				
				
			}
		});
	});

</script>
<script>
	document.getElementById("ttt").innerHTML = "Aboutme-Người dùng";
    document.getElementById("user").classList.add('menu-top-active');
</script>	 
<%@ include file="/templates/admin/inc/footer.jsp" %>	
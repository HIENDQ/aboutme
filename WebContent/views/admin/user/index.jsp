<%@page import="model.bean.User"%>
<%@page import="utils.DefineUtil"%>
<%@page import="utils.CodeMessageUtil"%>
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
                  User userInfo= (User)session.getAttribute("userInfo");
                  if(userInfo.getRole().getId_Role()==1){
                  %>
                  <a href="<%=request.getContextPath() %>/admin/user/add" class="btn btn-success">Thêm</a>
                  <%
                  }
                  
                	if(request.getParameter("msg")!= null) { 
	                	String msg="";
	                	int code= Integer.parseInt(request.getParameter("msg"));
	                	switch(code) {
	                		case 1:{
	                			msg ="Bạn đã thêm thành công.";
	                		}break;
	                		case 2:{
	                			msg ="Bạn đã xóa thành công.";
	                		}break;
	                		case 3:{
	                			msg ="Bạn đã sửa thành công.";
	                		}break;
	                		case 4:{
	                			msg ="Có lỗi xảy ra khi xóa.";
	                		}break;
                	
                	}
                	out.print(CodeMessageUtil.disPlayMessage(out, msg));
                } %>
            </div>
                                 
        </div>
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Danh sách người dùng
                        </div>
                        
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th width="10%">ID người dùng</th>
                                            <th width="15%">Username</th> 
                                            <th width="22%">Fullname</th>
                                            <th width="26%">Email</th>  
                                            <th width="12%">Chức vụ</th>                                        
                                            <th width="15%">Chức năng</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%if(request.getAttribute("listUser")!= null){
                        				ArrayList<User> listUser= (ArrayList<User>)request.getAttribute("listUser");
                                		if(listUser.size()>0){
                                			for (User user : listUser) {
                                	%>
                                      <tr class="odd gradeX">
                                            <td><%=user.getId() %></td>
                                            <td><%=user.getUsreName() %></td>
                                            <td><%=user.getName() %></td>
                                            <td><%=user.getEmail() %></td>
                                            <td><%=user.getRole().getName_Role() %></td>
                                            <td align="center">
                                            	<%if(userInfo.getRole().getId_Role()==1 || userInfo.getId()== user.getId()) {%>
                                                <a href="<%=request.getContextPath() %>/admin/user/edit?id=<%=user.getId() %>" class="btn btn-primary">Sửa</a>
                                                <%}if( userInfo.getRole().getId_Role()==1 && user.getRole().getId_Role()!= 1 ){ %>
                                                <a href="<%=request.getContextPath() %>/admin/user/del?id=<%=user.getId() %>" onclick="return confirm(&#39;Bạn có chắc chắn muốn xóa&#39;)" class="btn btn-danger">Xóa</a>
                                                <%} %>
                                            </td>                                          
                                        </tr>
                                       <%}}} %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
                <!-- /. ROW  -->
           
    </div>
    </div>
<script>
	document.getElementById("ttt").innerHTML = "Aboutme-Người dùng";
    document.getElementById("user").classList.add('menu-top-active');
</script>

     <!-- CONTENT-WRAPPER SECTION END-->
<%@ include file="/templates/admin/inc/footer.jsp" %>	 
   

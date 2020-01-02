<%@page import="model.bean.Contact"%>
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
                <h4 class="header-line">Quản lý liên hệ</h4>
                <%
                if(request.getParameter("msg")!= null) { 
                	String msg="";
                	int code= Integer.parseInt(request.getParameter("msg"));
                	switch(code) {
                		case 2:{
                			msg ="Bạn đã xóa thành công.";
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
                            Danh sách liên hệ
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                            <%
                            ArrayList<Contact> listContact = (ArrayList<Contact>)request.getAttribute("listContact"); 
                            for( Contact objContact : listContact) {
                            %>
                                <div class="modal fade" id="add-<%=objContact.getIdContact() %>" role="dialog" aria-hidden="true" style="display: none;">
                      				<div class="modal-dialog">
				                        <!-- Modal content-->
				                        <div class="modal-content">
                          					<div class="modal-header">
                            					<a type="a" class="close" data-dismiss="modal">×</a>
                            					<h4 class="modal-title">Liên hệ</h4>
                          					</div>
                          					<div class="modal-body">
                            					<div class="col-md-12">
                              						<form action="http://aboutme.vinaenter.edu.vn/admincp/contact/sentmail" method="post"></form>
                               							<div class="form-group">
                                							<br> <label>Người nhận</label>
                                 							<input readonly="" type="text" name="email" id="email" value="<%=objContact.getEmail() %>" class="form-control">
                                 							<label>Tiêu đề</label>
                                 							<input type="text" name="name" id="name" value="" class="form-control">
                                 							<label>Nội dung</label>
                                	 						<textarea name="noidung" rows="5" cols="72" id="noidung"></textarea>
                               							</div>
                               							<input type="submit" name="submit" value="Gửi" class="btn btn-success btn-md">
                           							</div>
                         						</div>
                         						<div class="modal-footer">
                          							<a type="a" class="btn btn-default" data-dismiss="modal">Đóng</a>
                        						</div>
                      						</div>
                    					</div>  
                  					</div>
                  				 <%} %>
                  				<table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th width="5%">ID</th>
                                            <th width="15%">Name</th> 
                                            <th width="15%">Email</th> 
                                            <th width="15%">Địa chỉ</th>  
                                            <th width="10%">Số điện thoại</th>                                        
                                            <th width="20%">Nội dung</th>                                        
                                         <th width="15%">Chức năng</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    for( Contact objContact : listContact) {
                                    %>
                                        <tr class="odd gradeX">
                                            <td><%=objContact.getIdContact() %></td>
                                            <td><%=objContact.getFullName() %></td>
                                            <td><%=objContact.getEmail() %></td>
                                            <td><%=objContact.getAddress()%></td>
                                            <td><%=objContact.getPhone() %></td>
                                            <td><%=objContact.getContent() %></td>
                                            <td align="center">
                                                <a class="btn btn-success btn-md" type="a" data-toggle="modal" data-target="#add-<%=objContact.getIdContact()%>">Liên hệ</a>
                                                <a href="<%=request.getContextPath() %>/admin/contact/del?id=<%=objContact.getIdContact() %>" onclick="return confirm(&#39;Bạn có chắc chắn muốn xóa&#39;)" class="btn btn-danger">Xóa</a>
                                        </tr>
                                      <%} %>  
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
     <!-- CONTENT-WRAPPER SECTION END-->
<script>
	document.getElementById("ttt").innerHTML = "Aboutme-Liên hệ";
    document.getElementById("contact").classList.add('menu-top-active');
</script>
     <!-- CONTENT-WRAPPER SECTION END-->
<%@ include file="/templates/admin/inc/footer.jsp" %>	 
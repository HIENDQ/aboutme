
<%@page import="utils.DefineUtil"%>
<%@page import="model.bean.Info"%>
<%@page import="utils.CodeMessageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
  <div class="content-wrapper">
         <div class="container">
        <div class="row pad-botm">
            <div class="col-md-12">
                <h4 class="header-line">Quản lý Thông tin cơ bản</h4>
                <%
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
                            Thông tin cơ bản
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th width="15%">FullName </th>
                                            <th width="12%">Email</th>   
                                            <th width="10%">Phone</th>   
                                            <th width="15%">Address</th>
                                            <th width="18%">Describe</th>
                                            <th width="23%">Picture</th>
                                            <th width="7%">Chức năng</th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    String fullname ="";
                                    String email ="";
                                    String phone ="";
                                    String address="";
                                    String pr =""; 
                                    String  picture ="";
                                    if(request.getAttribute("objInfo")!= null){
                                    	Info objInfo = (Info)request.getAttribute("objInfo");
                                    	fullname= objInfo.getFullname();
                                    	email = objInfo.getEmail();
                                    	phone = objInfo.getPhone();
                                    	address= objInfo.getAddress();
                                    	picture =objInfo.getPicture();
                                    	pr = objInfo.getPreview();
                                    }
                                   	%>
                                       <tr class="odd gradeX">
                                            <td><%=fullname %></td>
                                            <td><%=email %></td>
                                            <td><%=phone %></td>
                                            <td><%=address %></td>
                                            <td><%=pr%></td>
                                            <td>
                                            <%if(!"".equals(picture)) {%>
                                                <img src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_PROJ %>/<%=picture %>"
                                                 width="120px" alt="<%=picture%>"> 
                                             <%}else { %>
                                                	<p>Không có hình ảnh</p>
                                                <%} %>
                                            </td>
                                            <td align="center">
                                                <a href="<%=request.getContextPath() %>/admin/info/edit" class="btn btn-primary">Sửa</a>
                                            </td>   
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Aboutme
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th width="70%">Mô tả </th>
                                            <th width="20%">Hình ảnh</th>
                                            <th width="10%">Chức năng</th>    
                                            
                                       </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    if(request.getAttribute("objInfo")!= null){
                                    	Info objInfo = (Info)request.getAttribute("objInfo");
                                   		
                                   	%>
                                       <tr class="odd gradeX">
                                            <td><%=objInfo.getCt()%></td>
                                            
                                            <td>
                                            <%if(!"".equals(objInfo.getImg())) {%>
                                                <img src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_PROJ %>/<%=objInfo.getImg() %>"
                                                 width="120px" alt="<%=objInfo.getPicture()%>"> 
                                             <%}else { %>
                                                	<p>Không có hình ảnh</p>
                                                <%} %>
                                            </td>
                                            <td align="center">
                                                <a href="<%=request.getContextPath() %>/admin/info/editam" class="btn btn-primary">Sửa</a>
                                            </td>   
                                        </tr>
                                     <%
                                     }		
                                     %>
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
    	document.getElementById("ttt").innerHTML = "Aboutme-Thông tin";
    	document.getElementById("tht").classList.add('menu-top-active');
    	document.getElementById("info").classList.add('menu-top-active');
	</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>	 
   

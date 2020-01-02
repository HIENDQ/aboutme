<%@page import="model.bean.Project"%>
<%@page import="utils.DefineUtil"%>
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
                <h4 class="header-line">Quản lý dự án</h4>
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
                <a href="<%=request.getContextPath() %>/admin/project/add" class="btn btn-success">Thêm</a>
           </div>

        </div>
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Danh sách dự án
                        </div>
                        
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th width="10%">ID</th>
                                            <th width="25%">Tên dự án</th>
                                            <th width="25%">Link</th>
                                            <th width="15%">Hình ảnh</th> 
                                            <th width="15%">Chức năng</th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                    <%if(request.getAttribute("listProject") != null) {
                                    	ArrayList<Project> listProject = (ArrayList<Project>)request.getAttribute("listProject");
                                    	if(listProject.size()>0) {
                                    		for( Project project : listProject) {
                                   	%>
                                       <tr class="odd gradeX">
                                           <td><%=project.getId_Project() %></td>
                                           <td><%=project.getName_Project() %></td>
                                           <td><%=project.getLink_Project() %></td>
                                           <td>
                                                <%if(!"".equals(project.getPicture_Project())) {%>
                                                <img src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_PROJ %>/<%=project.getPicture_Project() %>"
                                                 width="120px" alt="<%=project.getName_Project()%>"> 
                                             <%}else { %>
                                                	<p style="color: blue;">Không có hình ảnh</p>
                                                <%} %>                       
                                           </td>
                                           <td align="center">
                                                <a href="<%=request.getContextPath() %>/admin/project/edit?id=<%=project.getId_Project() %>" class="btn btn-primary">Sửa</a>
                                                <a href="<%=request.getContextPath() %>/admin/project/del?id=<%=project.getId_Project() %>" onclick="return confirm(&#39;Bạn có chắc chắn muốn xóa&#39;)" class="btn btn-danger">Xóa</a>
                                           </td>  
                                     	</tr>
                                      <%
                                    		}
                                    	}
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
    	document.getElementById("ttt").innerHTML = "Aboutme-Dự án";
    	document.getElementById("tht").classList.add('menu-top-active');
    	document.getElementById("project").classList.add('menu-top-active');
	</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>
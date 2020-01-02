<%@page import="model.bean.Skill"%>
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
                <h4 class="header-line">Quản lý kỹ năng</h4>
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
                
                <a href="<%=request.getContextPath() %>/admin/skill/add" class="btn btn-success">Thêm</a>
           </div>
        </div>
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Danh sách kỹ năng
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th width="20%">ID </th>
                                            <th width="30%">Tên kỹ năng</th>   
                                            <th width="30%">Giá trị (%)</th>   
                                            <th width="20%">Chức năng</th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                    <%if(request.getAttribute("listSkill") != null) {
                                    	ArrayList<Skill> listSkill = (ArrayList<Skill>)request.getAttribute("listSkill");
                                    	if(listSkill.size()>0) {
                                    		for( Skill skill : listSkill) {
                                   	%>
                                       <tr class="odd gradeX">
                                            <td><%=skill.getId_skill() %></td>
                                            <td><%=skill.getName_Skill() %></td>
                                            <td><%=skill.getValus() %></td>
                                            <td align="center">
                                                <a href="<%=request.getContextPath() %>/admin/skill/edit?id=<%=skill.getId_skill() %>" class="btn btn-primary">Sửa</a>
                                                <a href="<%=request.getContextPath() %>/admin/skill/del?id=<%=skill.getId_skill() %>" onclick="return confirm(&#39;Bạn có chắc chắn muốn xóa&#39;)" class="btn btn-danger">Xóa</a>
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
    	document.getElementById("ttt").innerHTML = "Aboutme-Kỹ năng";
    	document.getElementById("tht").classList.add('menu-top-active');
    	document.getElementById("skill").classList.add('menu-top-active');
	</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>	 
   

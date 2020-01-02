<%@page import="model.bean.Experience"%>
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
                <h4 class="header-line">Quản lý Kinh nghiệm</h4>
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
                
                <a href="<%=request.getContextPath() %>/admin/exp/add" class="btn btn-success">Thêm</a>
           </div>
        </div>
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Danh sách
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th width="10%">ID </th>
                                            <th width="30%">Tên</th>   
                                            <th width="10%">Thời gian</th>  
                                            <th width="30%">Chi tiết</th>   
                                            <th width="20%">Chức năng</th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                    <%if(request.getAttribute("listEXP") != null) {
                                    	ArrayList<Experience> listEXP = (ArrayList<Experience>)request.getAttribute("listEXP");
                                    	if(listEXP.size()>0) {
                                    		for( Experience exp : listEXP) {
                                   	%>
                                       <tr class="odd gradeX">
                                            <td><%=exp.getId_ex() %></td>
                                            <td><%=exp.getName_ex() %></td>
                                            <td><%=exp.getTime_ex() %></td>
                                            <td><%=exp.getDescribe_ex() %></td>
                                            <td align="center">
                                                <a href="<%=request.getContextPath() %>/admin/exp/edit?id=<%=exp.getId_ex()%>" class="btn btn-primary">Sửa</a>
                                                <a href="<%=request.getContextPath() %>/admin/exp/del?id=<%=exp.getId_ex() %>" onclick="return confirm(&#39;Bạn có chắc chắn muốn xóa&#39;)" class="btn btn-danger">Xóa</a>
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
    	document.getElementById("ttt").innerHTML = "Aboutme-Chặng đường";
    	document.getElementById("tht").classList.add('menu-top-active');
    	document.getElementById("exp").classList.add('menu-top-active');
	</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>	 
   

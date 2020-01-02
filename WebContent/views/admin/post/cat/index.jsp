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
                <h4 class="header-line">Quản lý danh mục</h4>
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
                <a href="<%=request.getContextPath() %>/admin/cat/add" class="btn btn-success">Thêm</a>
        	</div>
		</div>
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading" >
                            Danh sách danh mục tin
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th width="10%">ID Danh mục</th>
                                            <th width="45%">Tên Danh mục</th>   
                                            <th width="30%">Chức năng</th>
                                            <td width="15%">STT</td>
                                    </thead>
                                    <tbody>
                                    <%if(request.getAttribute("listCat")!= null) {
                                  		ArrayList<Cat> listCat = (ArrayList<Cat>)request.getAttribute("listCat"); 
                                  		if(listCat.size()>0){
                                  			for(Cat cat : listCat){
                                    	%>
                                        <tr class="odd gradeX">
                                            <td><%=cat.getId_Cat() %></td>
                                            <td><%=cat.getName_Cat() %></td>
                                            <td align="center">
                                                <a href="<%=request.getContextPath() %>/admin/cat/edit?id=<%=cat.getId_Cat() %>" class="btn btn-primary">Sửa</a>
                                                <a href="<%=request.getContextPath() %>/admin/cat/del?id=<%=cat.getId_Cat() %>" onclick="return confirm(&#39;Bạn có chắc chắn muốn xóa&#39;)" class="btn btn-danger">Xóa</a>
                                            </td>
                                            <td><%=cat.getStt() %></td>  
                                        </tr>
                                        
                                    	<%}}}%>
                                    	<tr>
                                        <td style="border-color:white; background: white;"></td>
                                        <td style="border-color:white; background: white;"></td>
                                        <td style="border-color:white; background: white;"></td>
                                        <td style="background: white;border-color :1px black; "><a href="<%=request.getContextPath() %>/admin/cat/add" class="btn btn-success">Thay đổi</a></td>
                                        </tr>
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
	document.getElementById("ttt").innerHTML = "Aboutme-Danh mục";
    document.getElementById("dm").classList.add('menu-top-active');
    document.getElementById("post").classList.add('menu-top-active');
</script>
     <!-- CONTENT-WRAPPER SECTION END-->
<%@ include file="/templates/admin/inc/footer.jsp" %>	 
   

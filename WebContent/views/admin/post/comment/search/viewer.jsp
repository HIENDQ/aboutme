<%@page import="model.bean.Comment"%>
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
                <h4 class="header-line">Quản lý bình luận</h4>
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
                    <div class="panel panedanh mục tinl-default">
                        <div class="panel-body">
                            <div class="table-responsive">
                            <%
                            String name = "";
                            int id= 0;
                            if(request.getAttribute("listComment")!= null){ 
                                   ArrayList<Comment> listComment= (ArrayList<Comment>)request.getAttribute("listComment");
                                   name = listComment.get(0).getAuthor(); 
                                   id= listComment.get(0).getId_Comment();
                            }%>
                             <h3>Người bình luận: <%=name %></h3>
                             <br/>
                             <br/>
                             <a href="<%=request.getContextPath() %>/admin/comment/delall?id=<%=id %>&i=1" 
                             onclick="return confirm(&#39;Bạn có chắc chắn muốn xóa&#39;)" class="btn btn-danger">Xóa tất cả bình luận</a>
                                <table class="table table-striped table-bordered table-hover" style="margin-top: 15px;">
                                    <thead>
                                        <tr>
                                            <th width="5%">ID</th>
                                            <th width="30%">Bài viết</th> 
                                            <th width="35%">Nội dung</th>
                                            <th width="20%">Lúc</th>
                                            <th width="8">Chức năng</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%if(request.getAttribute("listComment")!= null){ 
                                    	ArrayList<Comment> listComment= (ArrayList<Comment>)request.getAttribute("listComment");
                                    	if(listComment.size()>0) {
                                   			for(Comment comment : listComment){
                                    		%>
                                        <tr class="odd gradeX">
                                             <td><%=comment.getId_Comment() %></td>  
                                             <td><%=comment.getObjNew().getName_New()%></td>  
                                             <td><%=comment.getContent()%></td> 
                                              <%
                                             int ht= comment.getTime().getHours();
												int mt= comment.getTime().getHours();
												String h = "", m="";
												if(ht<10) {
													h= "0"+String.valueOf(ht);
												}else h = String.valueOf(ht);
												if(mt<10) {
													m= "0"+String.valueOf(mt);
												}else m= String.valueOf(mt);
												String date = h+":"+m+"|"+comment.getDate();
									          	%>
                                             <td><%=date%></td>   
                                             <td>
                                                  <a href="<%=request.getContextPath() %>/admin/comment/del?id=<%=comment.getId_Comment() %>" onclick="return confirm(&#39;Bạn có chắc chắn muốn xóa&#39;)" class="btn btn-danger">Xóa</a>
                                             </td>   
                                        </tr>
                                        <%}}} %>
                                    </tbody>
                              </table>
                             
                       </div>
                   </div>
                </div>
            </div>
        </div>
    </div>
</div>
     <!-- CONTENT-WRAPPER SECTION END-->
<script>
	document.getElementById("ttt").innerHTML = "Aboutme-Bình luận";
	document.getElementById("bl").classList.add('menu-top-active');
    document.getElementById("post").classList.add('menu-top-active');
</script>
     <!-- CONTENT-WRAPPER SECTION END-->
<%@ include file="/templates/admin/inc/footer.jsp" %>	 
   


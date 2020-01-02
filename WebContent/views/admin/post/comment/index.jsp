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
	                	case 1:{
	            			msg ="Không tìm thấy bài viết.";
	            		}break;
                		case 2:{
                			msg ="Bạn đã xóa thành công.";
                		}break;
                		case 3:{
	            			msg ="Không tìm thấy người bình luận này.";
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
                            	<div style="float:left; margin-left: 50px; margin-right: 200px;" >
                            		<form method="post" action="<%=request.getContextPath()%>/search/newname_comment" id="form1">
                                        <input type="submit"  class="btn btn-warning btn-sm"  value="Tìm kiếm" style="float:right" />
                                        <input type="search" required="required" name="searchnew" class="form-control input-sm" placeholder="Bài viết" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form>	
                               </div>
                               <div>
                                    <form method="post" action="<%=request.getContextPath()%>/search/viewers_comment" id="form2">
                                        <input type="search" required="required" name="searchviewer" class="form-control input-sm" placeholder="Người bình luận" style="float:left; width: 300px;" />
                                        <input type="submit"  class="btn btn-warning btn-sm"  value="Tìm kiếm" style="float:left;" />
                                        <div style="clear:both"></div>
                                    </form>	
                            	</div>
                                <table class="table table-striped table-bordered table-hover" style="margin-top: 15px;">
                                    <thead>
                                    	
                                        <tr>
                                            <th width="5%">ID</th>
                                            <th width="30%">Bài viết</th> 
                                            <th width="12%">Người bình luận</th>  
                                            <th width="15%">Lúc</th>  
                                            <th width="30%">Nội dung</th>
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
                                             <%if(!"".equals(comment.getAuthor())) {%>                                    
                                             <td><%=comment.getAuthor() %></td>
                                             <%}else { %> 
                                             <td>Ẩn danh</td>
                                             <%} %> 
                                             <%
                                             int ht= comment.getTime().getHours();
												int mt= comment.getTime().getMinutes();
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
                                             <td><%=comment.getContent()%></td>   
                                             <td>
                                                  <a href="<%=request.getContextPath() %>/admin/comment/del?id=<%=comment.getId_Comment() %>" onclick="return confirm(&#39;Bạn có chắc chắn muốn xóa&#39;)" class="btn btn-danger">Xóa</a>
                                             </td>   
                                        </tr>
                                        <%}}} %>
                                    </tbody>
                              </table>
                               <div align="center">
                              	<ul class="pagination">
                                		<%
                    					int numberOfPage =0;
                    					int currentPage =0;
                    					if(request.getAttribute("numberOfPage") != null){
                    						numberOfPage =(Integer)request.getAttribute("numberOfPage");
                    						currentPage = (Integer)request.getAttribute("currentPage");
                    					}
                    					if(currentPage>1){
                    					%>
                    					<li><a href="<%=request.getContextPath() %>/admin/comments?page=<%=(currentPage-1) %>" rel="next">«</a></li>
                    					<%}
                    					else {
                    					%>
                    					<li class="disabled"><span>«</span></li>
                    					<% 	
                    					}
                    					for(int i=1; i<=numberOfPage ; i++){
                    						if(i==currentPage){
                    					%>
                    					<li class="active"><a  href="<%=request.getContextPath() %>/admin/comments?page=<%=i%>"><%=i %></a></li>
                    					<%}else{%>
                    					<li><a href="<%=request.getContextPath() %>/admin/comments?page=<%=i%>"><%=i %></a></li>
                    					<%}}
                    					if(currentPage<numberOfPage){
                    					%>
                  						<li><a  href="<%=request.getContextPath() %>/admin/comments?page=<%=(currentPage+1) %>" rel="next">»</a></li>
										<%}else 
										{%>
										<li class="disabled"><span>»</span></li>
										<%
										}
										%>
           		 			 </div>
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
   


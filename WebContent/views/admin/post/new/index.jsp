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
                <h4 class="header-line">Quản lý tin</h4>
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
                <a href="<%=request.getContextPath() %>/admin/new/add" class="btn btn-success">Thêm</a>
           </div>
        </div>
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Danh sách tin
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th width="10%">ID Tin</th>
                                            <th width="30%">Tên Tin</th>
                                            <th width="15%">Danh mục</th>
                                            <th width="15%">Hình ảnh</th> 
                                            <th width="15%">Trạng thái</th>                                         
                                            <th width="15%">Chức năng</th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                    	<%if(request.getAttribute("listNew")!= null){ 
                                    		ArrayList<New> listNew =(ArrayList<New>)request.getAttribute("listNew");
                                    		if(listNew.size()>0) {
                                    			for (New objNew : listNew){
                                    	%>
                                       <tr class="odd gradeX">
                                            <td><%=objNew.getId_New() %></td>
                                            <td>
                                                <%=objNew.getName_New() %>                       
                                            </td>
                                             <td>
                                                <%=objNew.getCat_New().getName_Cat() %>                      
                                            </td>
                                            <td>
                                             <%if(objNew.getPicture_New()!= null) {%>
                                                <img src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD %>/<%=objNew.getPicture_New() %>"
                                                 width="120px" alt="<%=objNew.getName_New()%>"> 
                                             <%}else { %>
                                                	<p>Không có hình ảnh</p>
                                                <%} %>                      
                                            </td>
                                            <td class="center">
                                               <span id="actice-<%=objNew.getId_New()%>">
                                              		 <a href="javascript:void(0)" onclick="active(<%=objNew.getId_New()%>,<%=objNew.getActive_New()%>);">
                                              		 	<%if(objNew.getActive_New()==0){ %>
                                              		 	<img src="<%=request.getContextPath() %>/templates/admin/assets/img/unac.jpg" alt="">
                                              		 	<%}else { %>
                                              		 	<img src="<%=request.getContextPath() %>/templates/admin/assets/img/ac.png"  alt="">
                                              		 	<%} %>
                                              		 </a>
                                           		</span> 
                                            </td>
                                            <td align="center">
                                                <a href="<%=request.getContextPath() %>/admin/new/edit?id=<%=objNew.getId_New() %>" class="btn btn-primary">Sửa</a>
                                                <a href="<%=request.getContextPath() %>/admin/new/del?id=<%=objNew.getId_New() %>" onclick="return confirm(&#39;Bạn có chắc chắn muốn xóa&#39;)" class="btn btn-danger">Xóa</a>
                                            </td>  
                                       </tr>
                                       <%		}
                                    		}
                                    	} %>
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
                    					<li><a href="<%=request.getContextPath() %>/admin/news?page=<%=(currentPage-1) %>" rel="next">«</a></li>
                    					<%}
                    					else {
                    					%>
                    					<li class="disabled"><span>«</span></li>
                    					<% 	
                    					}
                    					for(int i=1; i<=numberOfPage ; i++){
                    						if(i==currentPage){
                    					%>
                    					<li class="active"><a  href="<%=request.getContextPath() %>/admin/news?page=<%=i%>"><%=i %></a></li>
                    					<%}else{%>
                    					<li><a href="<%=request.getContextPath() %>/admin/news?page=<%=i%>"><%=i %></a></li>
                    					<%}}
                    					if(currentPage<numberOfPage){
                    					%>
                  						<li><a  href="<%=request.getContextPath() %>/admin/news?page=<%=(currentPage+1) %>" rel="next">»</a></li>
										<%}else 
										{%>
										<li class="disabled"><span>»</span></li>
										<%
										}
										%>
									</ul>
								</div>
                            </div>
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
                <!-- /. ROW  -->
    </div>
    </div>
          <script type="text/javascript">

           function active(nid,active)
              {
                var url_get_picture_active ='<%=request.getContextPath()%>/admin/news/active';
                var tmp="#actice-"+nid;
                  $.ajax({
                    url:url_get_picture_active,
                    dataType: "html",
                    data: {
                    	"nid" :nid,
                    	"active" : active,
                    },
                  success: function() {
                	  numberNoActive();
                      tmp="#actice-"+nid;
                      if(active ==1){
                        var ac = "<a href='javascript:void(0)' onclick='active("+nid+" ,0);'><img src='<%=request.getContextPath() %>/templates/admin/assets/img/unac.jpg'/></a>";
                       $(tmp).html(ac);
                      }else{
                          var de = "<a href='javascript:void(0)' onclick='active("+nid+" ,1);'><img src='<%=request.getContextPath() %>/templates/admin/assets/img/ac.png'/></a>";
                       $(tmp).html(de);
                     }
                    },
                  });
                  return false;
                 }

           function numberNoActive(){
        	   var url_get_number_no_active = '<%=request.getContextPath()%>/admin/news/numbernoactive';
        	   $.ajax({
                   url:url_get_number_no_active,
                   dataType: "html",
                   data: {
                   },
                 success: function(data) {
                 	$("#no_ac").html(data);
                 	$("#no_ac1").html(data);
                  
                   },
                 });
        	   return false;
           }
   </script>
<script>
	document.getElementById("ttt").innerHTML = "Aboutme-Tin tức";
	document.getElementById("tt").classList.add('menu-top-active');
    document.getElementById("post").classList.add('menu-top-active');
</script>
     <!-- CONTENT-WRAPPER SECTION END-->
<%@ include file="/templates/admin/inc/footer.jsp" %>	 
   

<%@page import="model.bean.Home"%>
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
                <h4 class="header-line">Quản lý home</h4>
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
                <a href="<%=request.getContextPath() %>/admin/home/add" class="btn btn-success">Thêm</a>
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
                                            <th width="30%">Nội Dung</th>
                                            <th width="20%">Hình ảnh</th> 
                                            <th width="20%">Trạng thái</th>                                         
                                            <th width="20%">Chức năng</th>
                                       </tr>
                                    </thead>
                                    <tbody>
                                    	<%if(request.getAttribute("listHome")!= null){ 
                                    		ArrayList<Home> listHome =(ArrayList<Home>)request.getAttribute("listHome");
                                    		if(listHome.size()>0) {
                                    			for (Home objHome : listHome){
                                    	%>
                                       <tr class="odd gradeX">
                                            <td><%=objHome.getId() %></td>
                                            <td>
                                                <%=objHome.getDep() %>                       
                                            </td>
                                            <td>
                                             <%if(objHome.getPicture()!= null) {%>
                                                <img src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_HOM %>/<%=objHome.getPicture() %>"
                                                 width="120px" alt="<%=objHome.getPicture()%>"> 
                                             <%}else { %>
                                                	<p>Không có hình ảnh</p>
                                                <%} %>                      
                                            </td>
                                            <td class="center">
                                               <span id="actice-<%=objHome.getId()%>">
                                              		 <a href="javascript:void(0)" onclick="active(<%=objHome.getId()%>,<%=objHome.getActive()%>);">
                                              		 	<%if(objHome.getActive()==0){ %>
                                              		 	<img src="<%=request.getContextPath() %>/templates/admin/assets/img/unac.jpg" alt="">
                                              		 	<%}else { %>
                                              		 	<img src="<%=request.getContextPath() %>/templates/admin/assets/img/ac.png"  alt="">
                                              		 	<%} %>
                                              		 </a>
                                           		</span> 
                                            </td>
                                            <td align="center">
                                                <a href="<%=request.getContextPath() %>/admin/home/edit?id=<%=objHome.getId() %>" class="btn btn-primary">Sửa</a>
                                                <a href="<%=request.getContextPath() %>/admin/home/del?id=<%=objHome.getId() %>" onclick="return confirm(&#39;Bạn có chắc chắn muốn xóa&#39;)" class="btn btn-danger">Xóa</a>
                                            </td>  
                                       </tr>
                                       <%		}
                                    		}
                                    	} %>
                                </table>
                                <div align="center">
                                	<ul class="pagination">
                    					<li class="disabled"><span>«</span></li>
										<li class="active"><span>1</span></li>
                    					<li><a href="http://aboutme.vinaenter.edu.vn/admincp/news?page=2">2</a></li>
                  						<li><a href="http://aboutme.vinaenter.edu.vn/admincp/news?page=2" rel="next">»</a></li>
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
                      var url='<%=request.getContextPath()%>/admin/homes/active';
                      var tmp="#actice-"+nid;
                      
        
                  $.ajax({
                    url:url,
                    dataType: "html",
                    data: {
                    	"nid" :nid,
                    	"active" : active,
                    },
                  success: function(data) {
                      tmp="#actice-"+nid;
                      if(active ==1){
                        var ac = "<a href='javascript:void(0)' onclick='active("+nid+" ,0);'><img src='<%=request.getContextPath() %>/templates/admin/assets/img/unac.jpg'/></a>";
                       $(tmp).html(ac);
                      }else{
                          var de = "<a href='javascript:void(0)' onclick='active("+nid+" ,1);'><img src='<%=request.getContextPath() %>/templates/admin/assets/img/ac.png'/></a>";
                       $(tmp).html(de);
                     }
                    // $('.ac123').html(data);
                    },
                  });
                 }


   </script>

     <!-- CONTENT-WRAPPER SECTION END-->
    <script>
    	document.getElementById("ttt").innerHTML = "Aboutme-Home";
    	document.getElementById("tht").classList.add('menu-top-active');
    	document.getElementById("home").classList.add('menu-top-active');
	</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>	 
   

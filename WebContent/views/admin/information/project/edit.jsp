<%@page import="utils.FileUtil"%>
<%@page import="utils.DefineUtil"%>
<%@page import="model.bean.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<div class="content-wrapper">
         <div class="container">
        <div class="row pad-botm">
            <div class="col-md-12">
                <h4 class="header-line">Quản lý dự án</h4>
                  
            </div>

        </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
               		<div class="panel panel-info">
                        <div class="panel-heading">
                          Thêm dự án
                        </div>
                        <div class="panel-body">
                        <%
                        int id;
                        String name = "";
                        String link = "";
                        String picture ="";
                        if(request.getAttribute("objProject")!= null){
                        	Project objProject = (Project)request.getAttribute("objProject");
                        	System.out.println(objProject);
                        	id = objProject.getId_Project();
                        	name = objProject.getName_Project();
                        	link = objProject.getLink_Project();
                        	picture =objProject.getPicture_Project();
                        }else {
                        	id = Integer.parseInt(request.getParameter("id"));
                        	link = request.getParameter("name");
                        	name = request.getParameter("link");
                        }
                        %>
                            <form role="form" action="<%=request.getContextPath() %>/admin/project/edit?id=<%=id %>" 
                            enctype="multipart/form-data" method="post" id= "form">
                                  <div class="form-group">
                                       <label for="name">Tên dự án</label>
                                       <input class="form-control" type="text" id= "name" name="name" value="<%=name%>" required="required">
                                  </div>
                                  <div class="form-group">
                                 		<label for ="link">Link</label>
                                  		<input class="form-control" type="text" id= "link" name="link" value="<%=link%>" required="required">
                                  </div>
                                  <div class="form-group">
                                  		<label>Hình ảnh</label>
                                  		<input type="file" name="picture" value="">
                                  		<img name= "pic" src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_PROJ %>/<%=picture %>"
                                  		width="120px" alt="<%=picture%>"> 
                                  </div>
                                        <input type="submit" name="submit" value="Sửa" class="btn btn-info">
                             </form>
                       </div>
                   </div>
              </div>
         </div>
                <!-- /. ROW  -->
           
    </div>
    </div>
     <!-- CONTENT-WRAPPER SECTION END-->
	<script type="text/javascript">
		$().ready(function() {
			var validator =$("#form").validate({
				errorPlacement: function(error, element){
					$(element).closest("form").find("label[for='" + element.attr("id") + "']").append(error);
				},
				errorElement: "span",
				messages: {
					name:{
						required: " (Tên dự án không được trống)",
					},
					link:{
						required: " (Giá trị không được trống)",
					},
					
				}
			});
		});
	
	</script>
    <script>
    	document.getElementById("ttt").innerHTML = "Aboutme-Dự án";
    	document.getElementById("project").classList.add('menu-top-active');
    	document.getElementById("tht").classList.add('menu-top-active');
	</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>
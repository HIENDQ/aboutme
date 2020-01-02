<%@page import="model.bean.Home"%>
<%@page import="utils.DefineUtil"%>
<%@page import="utils.CodeMessageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>

<div class="content-wrapper">
    <div class="container">
        <div class="row pad-botm">
            <div class="col-md-12">
                <h4 class="header-line">Quản lý tin tức</h4>
                  
            </div>
        </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
               		<div class="panel panel-info">
                        <div class="panel-heading">
                          Sửa tin tin
                        </div>
                        <div class="panel-body">
                        <%
                        
                         Home objHome = (Home)request.getAttribute("objHome");
                        %>
                            <form role="form" action="<%=request.getContextPath() %>/admin/home/edit?id=<%=objHome.getId() %>"
                             enctype="multipart/form-data" method="post" " >
                                        <div class="form-group">
                                            <label  >Mô tả</label>
                                            <textarea class="form-control" class="ckeditor" rows="3"
                                             name="preview_text" required = "required"><%=objHome.getDep() %></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Hình ảnh</label>
                                            <input type="file" name="picture" value="">
                                            <p class="help-block"></p>
                                            <img src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_HOM %>/<%=objHome.getPicture()%>"
                                                 width="120px" alt="<%=objHome.getPicture()%>">
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

     <!-- CONTENT-WRAPPER SECTION END-->

     <script>
     	CKEDITOR.replace( 'preview_text');
     </script>
    <script>
    	document.getElementById("ttt").innerHTML = "Aboutme-Home";
    	document.getElementById("tht").classList.add('menu-top-active');
    	document.getElementById("home").classList.add('menu-top-active');
	</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>
   


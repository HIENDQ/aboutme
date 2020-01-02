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
                <h4 class="header-line">Quản lý tin tức</h4>
                  
            </div>
        </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
               		<div class="panel panel-info">
                        <div class="panel-heading">
                          Thêm tin
                        </div>
                        <div class="panel-body">
                            <form role="form" action="<%=request.getContextPath() %>/admin/new/add" enctype="multipart/form-data" method="post" id="form">
                                        <div class="form-group">
                                            <label for ="name">Tên tin</label>
                                            <input class="form-control" type="text" id= "name" name="name" value="" required="required">
                                        </div>
                                         <div class="form-group">
                                            <label for="cat">Danh mục</label>
                                             <select class="form-control" id= "cat" name="cat" required="required"> 
                                             <option value ="">--</option> 
                                             <%
                                            	if(request.getAttribute("listCat")!= null){
                                            		ArrayList<Cat> listCat =(ArrayList<Cat>)request.getAttribute("listCat");
                                            		if(listCat.size()>0){
                                            			for(Cat cat : listCat) {
                                              %>                                                  
                                                <option value="<%=cat.getId_Cat()%>"><%=cat.getName_Cat() %></option>
                                              <%} } } %>
                                            </select>
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Hình ảnh</label>
                                            <input type="file" name="picture" value="">
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label for= "preview_text">Mô tả</label>
                                            <textarea class="form-control" rows="3" id= "preview_text" name="preview_text" required="required"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Chi tiết</label>
                                            <textarea  class="ckeditor" id="editor1" class="form-control" rows="3" name="detail_text"></textarea>
                                        </div>
                                        <input type="submit" name="submit" value="Thêm" class="btn btn-info">
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
					required: " (Tên tin không được trống)",
				},
				
				cat:{
					required: " (Danh mục không được trống)",
				},
				preview_text:{
					required: " (Mô tả không được trống)",
					
				},
				
				
			}
		});
	});

</script>
   <script type="text/javascript">

     CKEDITOR.replace( 'editor1',
    	      {
    	         filebrowserBrowseUrl : '<%=request.getContextPath()%>/templates/admin/assets/js/ckfinder/ckfinder.html',
    	         filebrowserImageBrowseUrl : '<%=request.getContextPath()%>/templates/admin/assets/js/ckfinder/ckfinder.html?Type=Images',
    	         filebrowserFlashBrowseUrl : '<%=request.getContextPath()%>/templates/admin/assets/js/ckfinder/ckfinder.html?Type=Flash',
    	         filebrowserUploadUrl : '<%=request.getContextPath()%>/templates/admin/assets/js/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files',
    	         filebrowserImageUploadUrl : '<%=request.getContextPath()%>/templates/admin/assets/js/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Images',
    	         filebrowserFlashUploadUrl : '<%=request.getContextPath()%>/templates/admin/assets/js/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Flash'
    	      } 
    	);
     </script>
<script>
	document.getElementById("ttt").innerHTML = "Aboutme-Tin tức";
	document.getElementById("tt").classList.add('menu-top-active');
    document.getElementById("post").classList.add('menu-top-active');
</script>
     <!-- CONTENT-WRAPPER SECTION END-->
<%@ include file="/templates/admin/inc/footer.jsp" %>
   


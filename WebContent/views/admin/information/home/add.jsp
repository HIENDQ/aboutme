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
                <h4 class="header-line">Quản lý Home</h4>
                  
            </div>
        </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
               		<div class="panel panel-info">
                        <div class="panel-heading">
                          Thêm Home
                        </div>
                        	<div class="panel-body">
                           		 <form role="form" action="<%=request.getContextPath() %>/admin/home/add"
                           		  enctype="multipart/form-data" method="post" id= "form">
                                        <div class="form-group">
                                            <label for ="preview_text">Nội dung</label>
                                            <textarea class="form-control" rows="3" id= "preview_text" name="preview_text" required="required"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Hình ảnh</label>
                                            <input type="file" name="picture" value="">
                                            <p class="help-block"></p>
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

     <!-- CONTENT-WRAPPER SECTION END-->
	<script type="text/javascript">
		$().ready(function() {
			var validator =$("#form").validate({
				errorPlacement: function(error, element){
					$(element).closest("form").find("label[for='" + element.attr("id") + "']").append(error);
				},
				errorElement: "span",
				
				messages: {
					preview_text:{
						required :" (Không được trống)"
					},
				}
			});
		});
	
	</script>
     <script>
     	CKEDITOR.replace( 'preview_text');
     </script>
    <script>
    	document.getElementById("ttt").innerHTML = "Aboutme-Home";
    	document.getElementById("home").classList.add('menu-top-active');
    	document.getElementById("tht").classList.add('menu-top-active');
	</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>
   


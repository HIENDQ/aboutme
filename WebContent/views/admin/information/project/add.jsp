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
                            <form role="form" action="<%=request.getContextPath() %>/admin/project/add" 
                            enctype="multipart/form-data" method="post" id= "form">
                                  <div class="form-group">
                                       <label for= "name">Tên dự án</label>
                                       <input class="form-control" type="text" id= "name" name="name" value="" required="required">
                                  </div>
                                  <div class="form-group">
                                 		<label for="link" >Link</label>
                                  		<input class="form-control" type="text" id= "link" name="link" value="" required="required">
                                  </div>
                                  <div class="form-group">
                                  		<label>Hình ảnh</label>
                                  		<input type="file" name="picture" value="">
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
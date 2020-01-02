<%@page import="utils.CodeMessageUtil"%>
<%@page import="model.bean.Skill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<div class="content-wrapper">
	<div class="container">
		<div class="row pad-botm">
			<div class="col-md-12">
				<h4 class="header-line">Quản lý Kỹ năng</h4>
				 <%
                	if(request.getParameter("err")!= null) { 
	                	String err="";
	                	int code= Integer.parseInt(request.getParameter("err"));
	                	switch(code) {
	                		case 1:{
	                			err ="Bạn đã thêm thành công.";
	                		}break;
	                		case 2:{
	                			err ="Bạn đã xóa thành công.";
	                		}break;
	                		case 3:{
	                			err ="Có lỗi xãy ra.";
	                		}break;
	                		case 4:{
	                			err ="Đã tồn tại kỹ năng.";
	                		}break;
                	
                	}
                	out.print(CodeMessageUtil.disPlayMessage(out, err));
                } %>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="panel panel-info">
					<div class="panel-heading">Thêm kỹ năng</div>
					<div class="panel-body">
						<form role="form"
							action="<%=request.getContextPath()%>/admin/exp/add"
							method="post" id= "form">
							
							<div class="form-group">
								<label for ="name">Tên kỹ năng</label>
								<input class="form-control" type="text" id= "name" name="name" value="" required="required">
							</div>
							<div class="form-group">
								<label for= "time">Thời gian</label>
								 <input class="form-control" type="text" id= "time" name="time" value="" required="required">
							</div>
							 <div class="form-group">
                                 <label>Chi tiết</label>
                                  <textarea class="form-control" rows="3" name="detail_text"></textarea>
                             </div>
							<input type="submit" name="submit" value="Thêm"
								class="btn btn-info">
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
					required: " (Không được trống)",
				},
				time:{
					
					required: " (Thời gian không được trống)",
				},
				
			}
		});
	});

</script>
    <script>
    	document.getElementById("ttt").innerHTML = "Aboutme-Chặng đường";
    	document.getElementById("tht").classList.add('menu-top-active');
    	document.getElementById("exp").classList.add('menu-top-active');
	</script>
<%@ include file="/templates/admin/inc/footer.jsp"%>
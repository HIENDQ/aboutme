<%@page import="utils.CodeMessageUtil"%>
<%@page import="model.bean.Cat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<div class="content-wrapper">
<div class="container">
	<div class="row pad-botm">
		<div class="col-md-12">
			<h4 class="header-line">Quản lý danh mục</h4>
        </div>
        </div>
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
              		 <div class="panel panel-info">
                        <div class="panel-heading"> Sửa danh mục</div>
                        <div class="panel-body">
                        <%
                        Cat objCat= null;
                        if(request.getAttribute("objCat")!= null) {
                        	objCat=(Cat)request.getAttribute("objCat");
                        }
                        %>
                            <form role="form" action="<%=request.getContextPath() %>/admin/cat/edit?id=<%=objCat.getId_Cat() %>" method="post" id= "form">
                                    <div class="form-group">
                                         <label for ="name">Tên danh mục</label>
                                         <input class="form-control" type="text" id= "name" name="name" value="<%=objCat.getName_Cat()%>" required="required">
                                    </div>
                                <input type="submit" name="submit" value="Sửa" class="btn btn-info">
                            </form>
                      </div>
                 </div>
            </div>
        </div>
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
					required: " (Tên danh mục không được trống)",
				},
				
			}
		});
	});

</script>	 
<script>
	document.getElementById("ttt").innerHTML = "Aboutme-Danh mục";
    document.getElementById("dm").classList.add('menu-top-active');
    document.getElementById("post").classList.add('menu-top-active');
</script>
     <!-- CONTENT-WRAPPER SECTION END-->
<%@ include file="/templates/admin/inc/footer.jsp" %>	
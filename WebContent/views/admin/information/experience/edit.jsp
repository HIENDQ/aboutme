<%@page import="model.bean.Experience"%>
<%@page import="utils.CodeMessageUtil"%>
<%@page import="model.bean.Skill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
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
                        <div class="panel-heading">
                          Sửa kỹ năng
                        </div>
                        <div class="panel-body">
                        <%
							String name = "";
							String time  = "";
							String der = "";
							int id=0;
							if (request.getAttribute("objEx") != null){
								Experience objEx = (Experience)request.getAttribute("objEx");
								name= objEx.getName_ex();
								time = objEx.getTime_ex(); 
								der = objEx.getDescribe_ex();
								id= objEx.getId_ex();
							}else{
								id= Integer.parseInt(request.getParameter("id"));
								name= request.getParameter("name");
								time = request.getParameter("time");
								der = request.getParameter("detail_text");
								id= Integer.parseInt(request.getParameter("id"));
							}
						 %>
                            <form role="form" action="<%=request.getContextPath() %>/admin/exp/edit?id=<%=id %>" 
                            method="post" id= "form">
                               
                                  <div class="form-group">
								<label for ="name">Tên kỹ năng</label>
								<input class="form-control" type="text" id= "name" name="name" value="<%=name%>" required="required">
							</div>
							<div class="form-group">
								<label for="time">Thời gian</label>
								 <input class="form-control" type="text" id="time" name="time" value="<%=time%>" required="required">
							</div>
							 <div class="form-group">
                                 <label>Chi tiết</label>
                                  <textarea class="form-control" rows="3" name="detail_text"><%=der %></textarea>
                             </div>
							<input type="submit" name="submit" value="Sửa"
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
<%@ include file="/templates/admin/inc/footer.jsp" %>
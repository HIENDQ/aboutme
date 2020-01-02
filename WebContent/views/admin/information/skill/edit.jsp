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
							int value = 0;
							int id=0;
							if (request.getAttribute("objSkill") != null){
								Skill objSkill = (Skill)request.getAttribute("objSkill");
								name= objSkill.getName_Skill();
								value = objSkill.getValus(); 
								id= objSkill.getId_skill();
							}else{
								id= Integer.parseInt(request.getParameter("id"));
								name= request.getParameter("name");
								value = Integer.parseInt(request.getParameter("value"));
							}
						 %>
                            <form role="form" action="<%=request.getContextPath() %>/admin/skill/edit?id=<%=id %>" method="post">
                               
                                  <div class="form-group">
                                       <label>Tên kỹ năng</label>
                                       <input class="form-control" type="text" name="name" value="<%=name%>">
                                  </div>
                                  <div class="form-group">
                                       <label>Giá trị</label>
                                       <input class="form-control" type="number" name="value" value="<%=value%>">
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
    <script>
    	document.getElementById("ttt").innerHTML = "Aboutme-Kỹ năng";
    	document.getElementById("skill").classList.add('menu-top-active');
    	document.getElementById("tht").classList.add('menu-top-active');
	</script>	 
<%@ include file="/templates/admin/inc/footer.jsp" %>
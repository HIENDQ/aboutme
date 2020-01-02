<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %> 
<div class="content-wrapper">
   <div class="container">
        <div class="row pad-botm">
            <div class="col-md-12">
                <h4 class="header-line" style="margin-left:14% "> Chào mừng bạn đến với Trang quản trị Website AboutMe</h4>
           </div>
        </div>
        </div>              
             <div class="row">
             	<div class="col-md-8 col-sm-12 col-xs-12" style="margin-left: 18%;padding-right:15% ">
                    <div id="carousel-example" style="width: 92%" class="carousel slide slide-bdr" data-ride="carousel">
                    	<div class="carousel-inner">
                        	<div class="item active">
                            	<img width="100%" height="100%" src="<%=request.getContextPath()%>/templates/admin/assets/img/ia.jpg" alt="">
                        	</div>
                        <div class="item">
                            <img src="<%=request.getContextPath()%>/templates/admin/assets/img/iic.jpg" alt="">
                        </div>
                        <div class="item">
                            <img src="<%=request.getContextPath()%>/templates/admin/assets/img/ic.jpg" alt="">
                        </div>
                    </div>
                    <!--INDICATORS-->
                     <ol class="carousel-indicators">
                        <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example" data-slide-to="1" class=""></li>
                        <li data-target="#carousel-example" data-slide-to="2" class=""></li>
                    </ol>
                    <!--PREVIUS-NEXT BUTTONS-->
                    <a class="left carousel-control" href="http://aboutme.vinaenter.edu.vn/admincp#carousel-example" data-slide="prev">
    					<span class="glyphicon glyphicon-chevron-left"></span>
  					</a>
  					<a class="right carousel-control" href="http://aboutme.vinaenter.edu.vn/admincp#carousel-example" data-slide="next">
    					<span class="glyphicon glyphicon-chevron-right"></span>
  					</a>
                </div>
           </div>
     </div>
</div>
    <script>
    document.getElementById("tc").classList.add('menu-top-active');
	</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>

<%@page import="model.dao.InfoDAO"%>
<%@page import="model.bean.Info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="colorlib-contact" data-section="contact">

<div id="myModal"  class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" style=" font-size: 40px; color: blue;">Message</h4>
      </div>
      <div class="modal-body">
        <p style="font-size: 25px;">Thank you for sending me the information</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


				<div class="colorlib-narrow-content">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box" data-animate-effect="fadeInLeft">
							<span class="heading-meta">Get in Touch</span>
							<h2 class="colorlib-heading">Contact</h2>
						</div>
					</div>
					<%					
					InfoDAO infoDAOContact= new InfoDAO();
					Info objInfoContact = infoDAOContact.getItem();
					
					%>
					
					<div class="row">
						<div class="col-md-5">
							<div class="colorlib-feature colorlib-feature-sm animate-box" data-animate-effect="fadeInLeft">
								<div class="colorlib-icon">
									<i class="icon-globe-outline"></i>
								</div>
								<div class="colorlib-text">
									<p><a href="#"><%=objInfoContact.getEmail() %></a></p>
								</div>
							</div>

							<div class="colorlib-feature colorlib-feature-sm animate-box" data-animate-effect="fadeInLeft">
								<div class="colorlib-icon">
									<i class="icon-map"></i>
								</div>
								<div class="colorlib-text">
									<p><%=objInfoContact.getAddress() %></p>
								</div>
							</div>

							<div class="colorlib-feature colorlib-feature-sm animate-box" data-animate-effect="fadeInLeft">
								<div class="colorlib-icon">
									<i class="icon-phone"></i>
								</div>
								<div class="colorlib-text">
									<p><a href="tel://"><%=objInfoContact.getPhone() %></a></p>
								</div>
							</div>
						</div>
						<div class="col-md-7 col-md-push-1">
							<div class="row">
								<div class="col-md-10 col-md-offset-1 col-md-pull-1 animate-box" data-animate-effect="fadeInRight">
									<form action="">
										<div class="form-group">
											<input id= "name" type="text" class="form-control" required ="required" placeholder="Name" value="" >
										</div>
										<div class="form-group">
											<input id= "email" type="text" class="form-control" required ="required" placeholder="Email" value="" >
										</div>
										<div class="form-group">
											<input id= "phone" type="text" class="form-control" required ="required" placeholder="Phone" value="" >
										</div>
										<div class="form-group">
											<input id= "address" type="text" class="form-control" required ="required" placeholder="Address" value="" >
										</div>
										<div class="form-group" id ="a">
											<textarea name="" id="message" cols="30" rows="7" class="form-control" required ="required" placeholder="Message" ></textarea>
										</div>
										<div class="form-group" >
										
										
											<input type="submit" class="btn btn-primary btn-send-message" 
											   value="Send Message" onclick="return sendContact();">
											
										</div>
									</form>
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</section>
<script>
function sendContact(){
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var phone = document.getElementById("phone").value;
	var address = document.getElementById("address").value;
	var message = document.getElementById("message").value;
	
	$.ajax({
		url: '<%=request.getContextPath()%>/contact',
		type: 'get',
		cache: false,
		data: {
				"name" : name,
				"email" :email,
				"phone" :phone,
				"address" :address,
				"message" :message,
		},
		success: function(data){
			data-toggle="modal" data-target="#myModal"
		},
		error: function (){
			alert('xảy ra lỗi');
		}
	});
	return false;
	
}

</script>
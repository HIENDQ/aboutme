
<%@page import="model.bean.Experience"%>
<%@page import="model.dao.ExperienceDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/leftbar.jsp" %> 
		<div id="colorlib-main">
			<%@ include file="/templates/public/inc/home.jsp" %> 
			<%@ include file="/templates/public/inc/about.jsp" %>
			<%@ include file="/templates/public/inc/skill.jsp" %>

			

			<section class="colorlib-experience" data-section="experience">
				<div class="colorlib-narrow-content">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box" data-animate-effect="fadeInLeft">
							<span class="heading-meta">Experience</span>
							<h2 class="colorlib-heading animate-box">Work Experience</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
				         <div class="timeline-centered">
				         <%
				         ExperienceDAO experienceDAO = new ExperienceDAO();
				         ArrayList<Experience> listEXP = experienceDAO.getItems();
				         if(listEXP.size()>0){
				        	 int i=1;
				        	 for (Experience exp : listEXP){
				         
				         %>
				         
					         <article class="timeline-entry animate-box" data-animate-effect="fadeInLeft">
					            <div class="timeline-entry-inner">

					               <div class="timeline-icon color-<%=i%>">
					                  <i class="icon-pen2"></i>
					               </div>

					               <div class="timeline-label">
					                  <h2><a href="#"><%=exp.getName_ex() %></a> <span><%=exp.getTime_ex() %></span></h2>
					                  <p><%=exp.getDescribe_ex() %></p>
					               </div>
					            </div>
					         </article>

						<%
						i++;
						}}
				        %>
					         

					         <article class="timeline-entry begin animate-box" data-animate-effect="fadeInBottom">
					            <div class="timeline-entry-inner">
					               <div class="timeline-icon color-none">
					               </div>
					            </div>
					         </article>
					      </div>
					   </div>
				   </div>
				</div>
			</section>

			<%@ include file="/templates/public/inc/work.jsp" %>

			<%@ include file="/templates/public/inc/blog.jsp" %>

			<%@ include file="/templates/public/inc/contact.jsp" %>

		</div><!-- end:colorlib-main -->
	</div><!-- end:container-wrap -->
	</div><!-- end:colorlib-page -->


	<!-- jQuery Easing -->
	<script src="<%=request.getContextPath() %>/templates/public/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="<%=request.getContextPath() %>/templates/public/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="<%=request.getContextPath() %>/templates/public/js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="<%=request.getContextPath() %>/templates/public/js/jquery.flexslider-min.js"></script>
	<!-- Owl carousel -->
	<script src="<%=request.getContextPath() %>/templates/public/js/owl.carousel.min.js"></script>
	<!-- Counters -->
	<script src="<%=request.getContextPath() %>/templates/public/js/jquery.countTo.js"></script>

	<!-- MAIN JS -->
	<script src="<%=request.getContextPath() %>/templates/public/js/main.js"></script>

	</body>
</html>


<%@page import="utils.DefineUtil"%>
<%@page import="model.bean.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.ProjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="colorlib-work" data-section="work">
				<div class="colorlib-narrow-content">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box" data-animate-effect="fadeInLeft">
							<span class="heading-meta">My Work</span>
							<h2 class="colorlib-heading animate-box">Recent Work</h2>
						</div>
					</div>
					<div class="row">
					 
					 <%
					 ProjectDAO projectDAOWork = new ProjectDAO();
					 ArrayList<Project> listProJectWork = projectDAOWork.getItems();
					 if(listProJectWork.size()>0) {
						 for(Project project : listProJectWork) 
						 {
							 
						
					 
					 %>
					 
						<div class="col-md-6 animate-box" data-animate-effect="fadeInLeft">
							<div class="project" style="background-image: url(<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_PROJ %>/<%=project.getPicture_Project() %>);">
								<div class="desc">
									<div class="con">
										<h3><a href="<%=project.getLink_Project()%>"><%=project.getName_Project() %></a></h3>
										
									</div>
								</div>
							</div>
						</div>
						<%}} %>
					</div>
					
				</div>
			</section>
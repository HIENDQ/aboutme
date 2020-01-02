<%@page import="model.bean.Skill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.SkillDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<section class="colorlib-skills" data-section="skills" id= "skill">
				<div class="colorlib-narrow-content">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box" data-animate-effect="fadeInLeft">
							<span class="heading-meta">My Specialty</span>
							<h2 class="colorlib-heading animate-box">My Skills</h2>
						</div>
					</div>
					<div class="row">
						<%
						SkillDAO skillDAO = new SkillDAO();
							ArrayList<Skill> listSkill = skillDAO.getItems();
							if(listSkill!= null) {
								if(listSkill.size()>0) {
									for(int i = 0; i< listSkill.size(); i++){
					
						%>
						<div class="col-md-6 animate-box" 
						data-animate-effect="<%
						if(i%2!=1) { 
							out.print("fadeInLeft");
						}
						else {
							out.print("fadeInRight");
						}
						%> ">
							<div class="progress-wrap">
								<h3><%=listSkill.get(i).getName_Skill() %></h3>
								<div class="progress">
								 	<div class="progress-bar color-<%=i+1%>" role="progressbar" aria-valuenow="<%=listSkill.get(i).getValus() %>"
								  	aria-valuemin="0" aria-valuemax="100" style="width:<%=listSkill.get(i).getValus() %>%">
								    <span><%=listSkill.get(i).getValus() %>%</span>
								  	</div>
								</div>
							</div>
						</div>
						<%
									}
								}
							}	
						%>
						
					</div>
				</div>
			</section>
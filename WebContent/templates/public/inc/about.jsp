<%@page import="utils.DefineUtil"%>
<%@page import="model.bean.Info"%>
<%@page import="model.dao.InfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="colorlib-about" data-section="about" id="about">
			<%
				InfoDAO infoDAOAboutme = new InfoDAO();
				Info objInfoAboume = infoDAOAboutme.getAboutme();
			%>
			<!--
			
			 -->
				<div class="colorlib-narrow-content">
				
					<div class="row">
						<div class="col-md-12">
							<div class="row row-bottom-padded-sm animate-box" data-animate-effect="fadeInLeft">
								<div class="col-md-12">
									<div class="about-desc">
										<span class="heading-meta">About Us</span>
										<h2 class="colorlib-heading">Who Am I?</h2>
										
										<div class="col-md-4 w3-about-top">
											<img src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD_PROJ %>/<%=objInfoAboume.getImg() %>" 
											class="img-responsive" alt="about-img"/>
										</div>
										<div class="col-md-8 w3l-about">
											<div class="w3ls-heading">
												<h2>Mục tiêu nghề nghiệp</h2>
											</div>
											<div class="w3ls-about-info">
												<p><%=objInfoAboume.getCt() %></p>
											</div>
											
									</div>
								</div>
							</div>
							
							<!-- modal -->
	
						</div>
					</div>
				</div>
				</div>
			</section>
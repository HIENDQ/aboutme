<%@page import="utils.StringUtil"%>
<%@page import="utils.DefineUtil"%>
<%@page import="model.bean.New"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row">    
  <%
  int currentPage =(Integer)request.getAttribute("currentPage");
  if(request.getAttribute("listNew") != null) {
	  ArrayList<New> listNew = (ArrayList<New>)request.getAttribute("listNew");
	  if(listNew.size()>0) {
		  for(int i=0; i<listNew.size(); i++){
	  
  %> 

<div class="col-md-4 col-sm-6 animate-box" data-animate-effect="
<%if(i%2==0) out.print("fadeInLeft"); else out.print("fadeInRight");%> ">
<div class="blog-entry">
<a href="<%=request.getContextPath()%>/detail?id=<%=listNew.get(i).getId_New()%>" class="blog-img">
<%if(!"".equals( listNew.get(i).getPicture_New())) {%>
<img class="img-responsive" style="width: 340px; height: 220px;" src="<%=request.getContextPath() %>/<%=DefineUtil.DIR_UPLOAD %>/<%=listNew.get(i).getPicture_New() %>">
<%}else { %>
<img class="img-responsive" src="">            	
<%} %>   
</a>
<div class="desc">
<span><small>April 14, 2018 </small> | <small><%=listNew.get(i).getCat_New().getName_Cat() %></small> | <small> <i class="icon-bubble3"></i> <%=listNew.get(i).getCount_New() %></small></span>
<h3><a href="<%=request.getContextPath()%>/detail/<%=StringUtil.makeSlug(listNew.get(i).getName_New())%>-<%=listNew.get(i).getId_New() %>"><%=listNew.get(i).getName_New() %></a></h3>
</div>
</div>
</div>
<%}}}%>
</div>
<div id="data_apage_<%=currentPage%>"></div>


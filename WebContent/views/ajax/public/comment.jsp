<%@page import="model.bean.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h2 style="color:#003322">Comment</h2><br>
          	<div class="row">
          <%if(request.getAttribute("listComment") != null) {
          	ArrayList<Comment> listComment = (ArrayList<Comment>)request.getAttribute("listComment");
          	
          	if(listComment.size()>0) {
          		for(Comment objComment : listComment) {
          %>	
              <div class="col-sm-2 text-center">
          		<img src="<%=request.getContextPath() %>/templates/public/images/icon1.png" style="width: 80px !important; ">
          		<h4><%=objComment.getAuthor() %></h4>
        	</div>
        	<div class="col-sm-10">
         
          	<p><%=objComment.getContent() %></p>
          	<%
          	int ht= objComment.getTime().getHours();
			int mt= objComment.getTime().getMinutes();
			String h = "", m="";
			if(ht<10) {
				h= "0"+String.valueOf(ht);
			}else h = String.valueOf(ht);
			if(mt<10) {
				m= "0"+String.valueOf(mt);
			}else m= String.valueOf(mt);
			String date = h+":"+m+"|"+objComment.getDate();
          	%>
          	<p><%=date%></p>
          	<br>
        	</div>
        	<div class="clearfix"></div>
        
        <%}}} %>
        
        
        </div>
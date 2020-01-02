<%@page import="utils.StringUtil"%>
<%@page import="utils.DefineUtil"%>
<%@page import="model.bean.New"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.NewsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="colorlib-blog" data-section="blog">
				<div class="colorlib-narrow-content">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box" data-animate-effect="fadeInLeft">
							<span class="heading-meta">Read</span>
							<h2 class="colorlib-heading">Recent Blog</h2>
						</div>
					</div>
					<div class="row">
					<%
					int offset =0;
					
					NewsDAO newsDAO = new NewsDAO();
					int numberOfItems = newsDAO.getNumberOfActive();
					
					int numberOfPage = (int)Math.ceil((float)numberOfItems/DefineUtil.NUMBER_PER_PAGE);
					
					ArrayList<New> listNew = newsDAO.getItemsPagination(offset);
					if(listNew.size()>0) {
						for(int i=0 ; i< listNew.size(); i++){
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
									<h3><a href="<%=request.getContextPath()%>/detail/<%=StringUtil.makeSlug(listNew.get(i).getName_New())%>-<%=listNew.get(i).getId_New() %>"><%=listNew.get(i).getName_New()%></a></h3>
								</div>
							</div>
						</div>
					<%
						}
					}
					%>		
						
					</div>
					<div id="data_apage_<%=(offset+1)%>"></div>
					
					<div class="row">
						<div class="col-md-12 animate-box">
							<p><a href="javascript:void(0);" class="btn btn-primary btn-lg btn-load-more" onclick="return showMoreNews( <%=numberOfPage %>);" >Load more <i class="icon-reload"></i></a></p>
						</div>
					</div>
				</div>
			</section>
		<script type="text/javascript">
		var currentPage = 1;
		function showMoreNews(ofs){
			var  numberOfPage =ofs;
			
			if(currentPage< numberOfPage) {
				currentPage +=1;
				$.ajax({
					url: '<%=request.getContextPath()%>/page',
					type: 'get',
					cache: false,
					data: {
							"currentPage" : currentPage,
					},
					success: function(data){
						var tmp="#data_apage_"+(currentPage-1);
						$(tmp).html(data);
					},
					error: function (){
						alert('xảy ra lỗi');
					}
				});
				return false;
			}
		}
		</script>
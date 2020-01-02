package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Comment;
import model.dao.CommentDAO;
import utils.AuthUtil;
import utils.DefineUtil;



public class AdminIndexCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CommentDAO commentDAO;   

    public AdminIndexCommentController() {
        super();
        commentDAO= new CommentDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int currentPage=1 ;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));//trang đầu tiên
		}
		    
		int numberOfItems = commentDAO.getNumberOfItems(); //số dòng
		int numberOfPage = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_CMT_ADMIM); // số trang
		int offset = (currentPage - 1) * DefineUtil.NUMBER_CMT_ADMIM;
		ArrayList< Comment> listComment = commentDAO.getItems(offset);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("listComment", listComment);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/post/comment/index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

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


public class AdminSearchViewerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDAO commentDAO;  

    public AdminSearchViewerController() {
        super();
        commentDAO = new CommentDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String name =request.getParameter("searchviewer").trim();
		ArrayList< Comment> listComment = commentDAO.getItemsByViewer(name);
		if(listComment.size() ==0 ) {
			response.sendRedirect(request.getContextPath()+"/admin/comments?msg="+3);
			return;
		}
		request.setAttribute("listComment", listComment);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/post/comment/search/viewer.jsp");
		rd.forward(request, response);
		
	}

}

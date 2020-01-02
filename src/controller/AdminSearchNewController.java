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


public class AdminSearchNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDAO commentDAO;
       

    public AdminSearchNewController() {
        super();
        commentDAO = new CommentDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String name =request.getParameter("searchnew").trim();
		ArrayList< Comment> listComment = commentDAO.getItemsByNameNew(name);
		if(listComment.size() ==0 ) {
			response.sendRedirect(request.getContextPath()+"/admin/comments?msg="+1);
			return;
		}
		request.setAttribute("listComment", listComment);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/post/comment/search/new.jsp");
		rd.forward(request, response);
	}
}

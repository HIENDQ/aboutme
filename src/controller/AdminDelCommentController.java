package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CommentDAO;
import utils.AuthUtil;


public class AdminDelCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private   CommentDAO commentDAO;

    public AdminDelCommentController() {
        super();
        commentDAO= new CommentDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int idComment= 0;
		try {
			idComment= Integer.parseInt(request.getParameter("id"));
			if(commentDAO.delItem(idComment)!=0) {
				response.sendRedirect(request.getContextPath()+"/admin/comments?msg="+2);
				return;
			}else {
				response.sendRedirect(request.getContextPath()+"/admin/comments?msg="+4);
				return;
			}
		} catch (Exception e) {
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

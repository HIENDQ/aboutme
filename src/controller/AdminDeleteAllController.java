package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Comment;
import model.dao.CommentDAO;
import utils.AuthUtil;


public class AdminDeleteAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CommentDAO commentDAO;

    public AdminDeleteAllController() {
        super();
        commentDAO =  new CommentDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int i=0;
		int id= 0;
		if(request.getParameter("i")!= null) {
			i= Integer.parseInt(request.getParameter("i"));
		}
		id= Integer.parseInt(request.getParameter("id"));
		if(i==0) {
			commentDAO.delItemByNew(id);
		}else {
			Comment objComment = commentDAO.getItem(id);
			commentDAO.delItemByViewer(objComment.getAuthor());
		}
		response.sendRedirect(request.getContextPath()+"/admin/comments");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Cat;
import model.bean.Comment;
import model.bean.New;
import model.dao.CatDAO;
import model.dao.CommentDAO;
import model.dao.NewsDAO;
import utils.DefineUtil;

public class PublicDetailNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDAO newsDAO;
	private CatDAO catDAO;
	private CommentDAO commentDAO;

	public PublicDetailNewsController() {
		super();
		newsDAO = new NewsDAO();
		catDAO = new CatDAO();
		commentDAO = new CommentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("id") != null ) {
			int id_New = Integer.parseInt(request.getParameter("id"));
			New objNew = newsDAO.getItemActive(id_New);
			//tăng luong views cua bai viet
			HttpSession session = request.getSession();
			String hasVisited = (String)session.getAttribute("hasVisited"+id_New);
			if(hasVisited== null) {
				session.setAttribute("hasVisited"+id_New, "123");
				session.setMaxInactiveInterval(120);
				newsDAO.increaseView(objNew);
			}
			int id_cat = objNew.getCat_New().getId_Cat();
			int offset=0;
			ArrayList<New> listNewByCat = newsDAO.getItemsByCat(id_cat, offset);
			//liêt bài viết có sô lượng đọc nhìu nhất
			ArrayList<New> listMostRead = newsDAO.getItemsMostRead(DefineUtil.NUMBER_MOST_READ_ART);
			ArrayList<Cat> listCat = catDAO.getItems();
			ArrayList<Comment> listComment = commentDAO.getItemsByNew(id_New,0);
			
			request.setAttribute("objNew", objNew);
			request.setAttribute("listComment", listComment);
			request.setAttribute("listCat", listCat);
			request.setAttribute("listMostRead", listMostRead);
			request.setAttribute("listNewByCat", listNewByCat);
			RequestDispatcher rd= request.getRequestDispatcher("/views/public/detail.jsp");
			rd.forward(request, response);
		}else {
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

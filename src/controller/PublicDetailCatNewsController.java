package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Cat;
import model.bean.New;
import model.dao.CatDAO;
import model.dao.NewsDAO;
import utils.DefineUtil;

public class PublicDetailCatNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDAO newsDAO;
	private CatDAO catDAO;

	public PublicDetailCatNewsController() {
		super();
		newsDAO = new NewsDAO();
		catDAO = new CatDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("id") != null ) {
			int id_Cat = Integer.parseInt(request.getParameter("id"));
			ArrayList<New> listNewByCat= null;
			ArrayList<Cat> listCat = null;
			ArrayList<New> listMostRead = null;
			try {
				 listNewByCat = newsDAO.getItemsByCat(id_Cat);
				//liêt bài viết có sô lượng đọc nhìu nhất
				listMostRead = newsDAO.getItemsMostRead(DefineUtil.NUMBER_MOST_READ_ART);
				listCat = catDAO.getItems();
			} catch (Exception e) {
				return;
			}
			
			if(listNewByCat.size()>0) {
				request.setAttribute("Cat", listNewByCat.get(0).getCat_New());
			}else {
				request.setAttribute("Cat",catDAO.getItem(id_Cat));
			}
			request.setAttribute("listCat", listCat);
			request.setAttribute("listMostRead", listMostRead);
			request.setAttribute("listNewByCat", listNewByCat);
			RequestDispatcher rd= request.getRequestDispatcher("/views/public/detailcat.jsp");
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

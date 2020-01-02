package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Cat;
import model.dao.CatDAO;
import utils.AuthUtil;

public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatDAO catDAO;

	public AdminAddCatController() {
		super();
		catDAO = new CatDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/post/cat/add.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String cat_Name = request.getParameter("name");
		Cat objCat = new Cat(cat_Name);
		if (catDAO.addItem(objCat) != 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=" + 1);
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/post/cat/add.jsp?err=" + 1);
			rd.forward(request, response);
			return;
		}
	}

}

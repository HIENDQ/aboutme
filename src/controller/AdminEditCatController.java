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


public class AdminEditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatDAO catDAO;

    public AdminEditCatController() {
        super();
        catDAO =  new CatDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_Cat=0;
		try {
			id_Cat= Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		Cat objCat= catDAO.getItem(id_Cat);
		if(objCat!= null) {
			request.setAttribute("objCat", objCat);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/post/cat/edit.jsp");
			rd.forward(request, response);
		}else {
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int id_Cat=0;
		try {
			id_Cat= Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		String newNameCat=request.getParameter("name");
		Cat objCat = new Cat(id_Cat, newNameCat);
		if(catDAO.editItem(objCat)!=0 ) {
			response.sendRedirect(request.getContextPath()+"/admin/cats?msg="+3);
			return;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/post/cat/edit.jsp?err=" + 3);
			rd.forward(request, response);
			return;
		}
		
	}

}

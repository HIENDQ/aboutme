package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CatDAO;
import model.dao.NewsDAO;
import utils.AuthUtil;


public class AdminDelCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatDAO catDAO;
    private NewsDAO newsDAO;   

    public AdminDelCatController() {
        super();
        catDAO = new CatDAO();
        newsDAO = new NewsDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_Cat =0;
		try {
			id_Cat = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		if(catDAO.delItem(id_Cat)!= 0) {
			newsDAO.delItemByCat(id_Cat);
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=" + 2);
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=" + 4);
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HomeDAO;
import utils.AuthUtil;


public class AdminDelHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeDAO homeDAO;  

    public AdminDelHomeController() {
        super();
        homeDAO = new HomeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_Home =0;
		try {
			id_Home = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		if(homeDAO.delItem(id_Home)!= 0) {
			response.sendRedirect(request.getContextPath() + "/admin/homes?msg=" + 2);
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/homes?msg=" + 4);
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Home;
import model.dao.HomeDAO;
import utils.AuthUtil;

public class AdminIndexHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeDAO homeDAO;

    public AdminIndexHomeController() {
        super();
        homeDAO = new HomeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		ArrayList<Home>  listHome= homeDAO.getItems();
		if(listHome== null) return;
		request.setAttribute("listHome", listHome);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/home/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Info;
import model.dao.InfoDAO;
import utils.AuthUtil;


public class AdminIndexInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InfoDAO infoDAO ;
       
    public AdminIndexInfoController() {
        super();
        infoDAO = new InfoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		try {
			Info objInfo = infoDAO.getInfo();
			if(objInfo == null) {
				Exception exception = new Exception();
				throw exception;
			}
			request.setAttribute("objInfo", objInfo);
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/info/index.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}


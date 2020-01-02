package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.New;
import model.dao.NewsDAO;
import utils.AuthUtil;
import utils.DefineUtil;


public class AdminIndexNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDAO newsDAO;
    public AdminIndexNewController() {
        super();
       newsDAO= new NewsDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int currentPage=1 ;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));//trang đầu tiên
		}
		    
		int numberOfItems = newsDAO.getNumberOfItems(); //số dòng
		int numberOfPage = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_NEWS_ADMIM); // số trang
		int offset = (currentPage - 1) * DefineUtil.NUMBER_NEWS_ADMIM;
		ArrayList<New > listNew=newsDAO.getItems(offset);
		request.setAttribute("listNew", listNew);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfPage", numberOfPage);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/post/new/index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Experience;
import model.dao.ExperienceDAO;
import utils.AuthUtil;

public class AdminAddEXPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExperienceDAO experienceDAO;
	
    public AdminAddEXPController() {
        super();
        experienceDAO = new ExperienceDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/experience/add.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
	    String der = request.getParameter("detail_text");
	    Experience objEx = new Experience(name, time, der);
	    if(experienceDAO.addItem(objEx) != 0) {
	    	response.sendRedirect(request.getContextPath() + "/admin/exp?msg=" + 1);
			return;
	    }else {
	    	RequestDispatcher rd = request.getRequestDispatcher("/views/admin/information/experience/add.jsp?err=" + 1);
			rd.forward(request, response);
			return;
	    }
		
	}

}

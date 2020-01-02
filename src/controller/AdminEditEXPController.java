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


public class AdminEditEXPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExperienceDAO experienceDAO;   

    public AdminEditEXPController() {
        super();
        experienceDAO = new ExperienceDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_Ex = 0;
		try {
			id_Ex = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			return;
		}
		Experience objEx = experienceDAO.getItem(id_Ex);
		if(objEx!= null) {
			request.setAttribute("objEx", objEx);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/information/experience/edit.jsp");
			rd.forward(request, response);
		}else {
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String time = request.getParameter("time");
	    String der = request.getParameter("detail_text");
	    if(!"".equals(name) && !"".equals(time) &&!"".equals(der)) {
	    	Experience objEx = new Experience(id,name, time, der);
	    	if(experienceDAO.editItem(objEx) != 0) {
	    		response.sendRedirect(request.getContextPath()+"/admin/exp?msg="+3);
				return;
	    	}else {
	    		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/information/experience/edit?err=" + 3);
				rd.forward(request, response);
				return;
	    	}
	    }else {
	    	return;
	    }
	   
	}

}

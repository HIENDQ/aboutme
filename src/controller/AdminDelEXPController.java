package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ExperienceDAO;
import utils.AuthUtil;

public class AdminDelEXPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExperienceDAO experienceDAO;   

    public AdminDelEXPController() {
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
			if(experienceDAO.delItem(id_Ex)!= 0) {
				response.sendRedirect(request.getContextPath()+"/admin/exp?msg="+2);
				return;
			}else {
				response.sendRedirect(request.getContextPath()+"/admin/exp?msg="+4);
				return;
			}
		} catch (Exception e) {
			return;
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

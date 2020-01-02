package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.dao.ProjectDAO;
import utils.AuthUtil;

public class AdminDelProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProjectDAO projectDAO;   

    public AdminDelProjectController() {
        super();
        projectDAO = new ProjectDAO(); 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_Project= 0;
		try {
			id_Project =Integer.parseInt(request.getParameter("id")); 
			if(projectDAO.delItem(id_Project)!= 0) {
				response.sendRedirect(request.getContextPath()+"/admin/projects?msg="+2);
				return;
			}else {
				response.sendRedirect(request.getContextPath()+"/admin/projects?msg="+4);
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

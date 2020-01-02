package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Project;
import model.dao.ProjectDAO;
import utils.AuthUtil;


public class AdminIndexProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDAO projectDAO;

    public AdminIndexProjectController() {
        super();
        projectDAO= new ProjectDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		ArrayList<Project> listProject = projectDAO.getItems();
		if(listProject == null) {
			return;
		}
		request.setAttribute("listProject", listProject);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/project/index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

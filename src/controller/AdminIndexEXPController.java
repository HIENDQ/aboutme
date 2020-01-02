package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Experience;
import model.dao.ExperienceDAO;


public class AdminIndexEXPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ExperienceDAO experienceDAO;   

    public AdminIndexEXPController() {
        super();
        experienceDAO = new ExperienceDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Experience> listEXP = null;
		try {
			listEXP= experienceDAO.getItems();
			if(listEXP== null) {
				Exception exception= new Exception();
				throw exception;
			}
			request.setAttribute("listEXP", listEXP);
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/experience/index.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

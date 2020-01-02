package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Skill;
import model.dao.SkillDAO;
import utils.AuthUtil;


public class AdminIndexSkillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SkillDAO skillDAO;

    public AdminIndexSkillController() {
        super();
        skillDAO= new SkillDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		ArrayList< Skill> listSkill = skillDAO.getItems();
		if(listSkill == null) {
			return;
		}
		request.setAttribute("listSkill", listSkill);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/skill/index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

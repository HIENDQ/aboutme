package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Skill;
import model.dao.SkillDAO;
import utils.AuthUtil;

public class AdminAddSkillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SkillDAO skillDAO;

	public AdminAddSkillController() {
		super();
		skillDAO = new SkillDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/information/skill/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String skillName = request.getParameter("name");
		int value = Integer.parseInt(request.getParameter("value"));
		Skill objSkill= new Skill(skillName, value);
		if (skillDAO.addItem(objSkill) != 0) {
			response.sendRedirect(request.getContextPath() + "/admin/skills?msg=" + 1);
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/information/skill/add.jsp?err=" + 1);
			rd.forward(request, response);
			return;
		}
	}

}

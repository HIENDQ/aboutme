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

public class AdminEditSkillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SkillDAO skillDAO;

	public AdminEditSkillController() {
		super();
		skillDAO = new SkillDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_Skill = 0;
		try {
			id_Skill = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		Skill objSkill = skillDAO.getItem(id_Skill);
		if (objSkill != null) {
			request.setAttribute("objSkill", objSkill);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/information/skill/edit.jsp");
			rd.forward(request, response);
		} else {
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int id_Skill = 0;
		try {
			id_Skill = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			return;
		}
		String newNameSkill = request.getParameter("name");
		int value = Integer.parseInt(request.getParameter("value"));
		Skill objSkill = new Skill(id_Skill, value, newNameSkill);
		if (!skillDAO.hasItem(objSkill)) {
			if (skillDAO.editItem(objSkill) != 0) {
				response.sendRedirect(request.getContextPath() + "/admin/skills?msg=" + 3);
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/information/skill/edit.jsp?err=" + 3+"&id="+objSkill.getId_skill());
				rd.forward(request, response);
				return;
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/information/skill/edit.jsp?err=" + 4+"&id="+objSkill.getId_skill());
			rd.forward(request, response);
			return;
		}
	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SkillDAO;
import utils.AuthUtil;


public class AdminDelSkillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SkillDAO skillDAO;   

    public AdminDelSkillController() {
        super();
       skillDAO = new SkillDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_Skill =0;
		try {
			id_Skill = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		if(skillDAO.delItem(id_Skill)!= 0) {
			response.sendRedirect(request.getContextPath() + "/admin/skills?msg=" + 2);
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/skills?msg=" + 4);
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

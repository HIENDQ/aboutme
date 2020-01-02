package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import utils.AuthUtil;

public class AdminDelNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsDAO  newsDAO;   

    public AdminDelNewController() {
        super();
        newsDAO = new NewsDAO(); 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_New= 0;
		try {
			id_New =Integer.parseInt(request.getParameter("id")); 
			if(newsDAO.delItem(id_New)!= 0) {
				response.sendRedirect(request.getContextPath()+"/admin/news?msg="+2);
				return;
			}else {
				response.sendRedirect(request.getContextPath()+"/admin/news?msg="+4);
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

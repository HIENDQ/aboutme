package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ContactDAO;
import utils.AuthUtil;


public class AdminDelContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactDAO contactDAO;   

    public AdminDelContactController() {
        super();
        contactDAO = new ContactDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_Contact =0;
		try {
			id_Contact = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			//tl
			return;
		}
		if(contactDAO.delItem(id_Contact)!= 0) {
			response.sendRedirect(request.getContextPath() + "/admin/contacts?msg=" + 2);
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/contacts?msg=" + 4);
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

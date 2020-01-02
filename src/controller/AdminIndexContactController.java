package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;
import utils.AuthUtil;


public class AdminIndexContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactDAO contactDAO;
    public AdminIndexContactController() {
        super();
        contactDAO= new ContactDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		ArrayList<Contact> listContact = contactDAO.getItems();
		if(listContact== null ) {
			return;
		}
		request.setAttribute("listContact", listContact);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/contact/index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.dao.UserDao;
import utils.AuthUtil;


public class AdminIndexUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
    public AdminIndexUserController() {
        super();
        userDao= new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		ArrayList<User> listUser = userDao.getItems();
		System.out.println(listUser.size()+"ls");
		request.setAttribute("listUser", listUser);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/user/index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

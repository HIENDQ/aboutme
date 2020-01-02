package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.UserDao;
import utils.StringUtil;



public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;
    public LoginController() {
        super();
        userDao = new UserDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("username");
		String passWord=StringUtil.md5(request.getParameter("password"));
		User user= new User(userName, passWord);
		User userInfo= userDao.getItem(user);
		if(userInfo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);
			response.sendRedirect(request.getContextPath()+"/admin");
			return;
		}else {
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/login.jsp");
			rd.forward(request, response);
		}
	}
	
	
	

}

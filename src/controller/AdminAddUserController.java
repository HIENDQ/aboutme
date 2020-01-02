package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Role;
import model.bean.User;
import model.dao.UserDao;
import utils.AuthUtil;
import utils.StringUtil;


public class AdminAddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public AdminAddUserController() {
        super();
        userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		HttpSession session = request.getSession();
		User userInfo= (User)session.getAttribute("userInfo");
		if(userInfo.getRole().getId_Role()!=1 ) {
			//ko có quyền thêm
			return;
		}
		else {
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/user/add.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		 
		String fullName= request.getParameter("fullname").trim();
		String userName= request.getParameter("username").trim();
		String passWord= StringUtil.md5(request.getParameter("password"));
		String email = request.getParameter("email");
		int idRole =Integer.parseInt(request.getParameter("role"));
		if(!userDao.hasUser(userName)) {
			User objUser = new User(fullName, userName, passWord, email, new Role(idRole));
			if(userDao.addItem(objUser)!=0) {
				response.sendRedirect(request.getContextPath()+"/admin/users?msg="+1);
				return;
			}else {
				RequestDispatcher rd= request.getRequestDispatcher("/views/admin/user/add.jsp?err="+1);
				rd.forward(request, response);
				return;
			}
		}else {
			System.out.println("hello");
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/user/add.jsp?err="+2);//tồn tại
			rd.forward(request, response);
			return;
		}
		
	}

}

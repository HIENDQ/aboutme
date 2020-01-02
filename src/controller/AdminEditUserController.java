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


public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao ;   

    public AdminEditUserController() {
        super();
        userDao= new UserDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		HttpSession session = request.getSession();
		User userInfo= (User)session.getAttribute("userInfo");
		int id_user =Integer.parseInt(request.getParameter("id"));
		if(id_user==userInfo.getId() || userInfo.getRole().getId_Role()== 1) {
			User objUser = userDao.getItem(id_user);
			if(objUser== null) {
				return;
			}
			request.setAttribute("objUser", objUser);
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/user/edit.jsp");
			rd.forward(request, response);
		}else {
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		int id_User = Integer.parseInt(request.getParameter("id"));
		String fullName= request.getParameter("fullname").trim();
		String passWord="";
		if("".equals(request.getParameter("password").trim())) {
			try {
				passWord= userDao.getItem(id_User).getPass();
			} catch (Exception e) {
				//trang  lỗi
				return;
			}
		}else {
			passWord= StringUtil.md5(request.getParameter("password"));
		}
		String email = request.getParameter("email");
		int idRole =Integer.parseInt(request.getParameter("role"));
		System.out.println(idRole+"+");
		User objUser = new User(id_User, fullName, passWord, email, new Role(idRole));
		if(userDao.editItem(objUser)!= 0) {
			response.sendRedirect(request.getContextPath()+"/admin/users?msg="+3);
			return;
		}else {
			//trang  lỗi
			return;
		}
		
	
		
	}

}

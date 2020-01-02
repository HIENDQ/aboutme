package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.UserDao;
import utils.AuthUtil;


public class AdminDelUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;
    public AdminDelUserController() {
        super();
       userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_user =0;
		try {
			id_user =Integer.parseInt(request.getParameter("id"));
			User objUser =userDao.getItem(id_user);
			if(objUser== null) {
				//trang loi
				return;
			}
			HttpSession session = request.getSession();
			User userInfo = (User)session.getAttribute("userInfo"); 
			if(userInfo.getRole().getId_Role()==1 && objUser.getRole().getId_Role()!=1) {
				if(userDao.delItem(id_user)!= 0) {
					response.sendRedirect(request.getContextPath()+"/admin/users?msg="+2);
					return;
				}else {
					response.sendRedirect(request.getContextPath()+"/admin/users?msg="+4);
					return;
				}
			}else {
				return;
			}
		} catch (Exception e) {
			//trang loi
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

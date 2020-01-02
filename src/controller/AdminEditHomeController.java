package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Home;
import model.dao.HomeDAO;
import utils.AuthUtil;
import utils.DefineUtil;
import utils.FileUtil;

@MultipartConfig
public class AdminEditHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeDAO homeDAO;

    public AdminEditHomeController() {
        super();
        homeDAO= new HomeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_Home=0;
		try {
			id_Home= Integer.parseInt(request.getParameter("id"));
			Home objHome = homeDAO.getItem(id_Home);
			if(objHome!= null) {
				request.setAttribute("objHome", objHome);
				RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/home/edit.jsp");
				rd.forward(request, response);
			}else {
				return;
			}
		} catch (Exception e) {
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int id_Home = Integer.parseInt(request.getParameter("id"));
		String picture=homeDAO.getItem(id_Home).getPicture();
		String description = request.getParameter("preview_text");
		Part part = request.getPart("picture");
		String fileName = FileUtil.rename(part.getSubmittedFileName());
		if("".equals(fileName)) {
			fileName= picture;
		}else {
			//xóa file cũ
			String dirPath = request.getServletContext().getRealPath("") + DefineUtil.DIR_UPLOAD_HOM;
			String filePath = dirPath + File.separator + picture;
			File file= new File(filePath);
			if(file.exists()) {
				file.delete();
			}
			filePath = dirPath + File.separator + fileName;
			part.write(filePath);
			System.out.println(filePath);
		}
		Home objHome = new Home(id_Home, description, fileName); 
		if(homeDAO.editItem(objHome)!= 0) {
			response.sendRedirect(request.getContextPath() + "/admin/homes?msg=" + 3);
			return;
		}else {
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/home/edit.jsp?err="+3);
			rd.forward(request, response);
			return;
		}
		
	}

}

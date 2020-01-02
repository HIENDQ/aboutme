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
public class AdminAddHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeDAO homeDAO;

       
    public AdminAddHomeController() {
        super();
        homeDAO = new HomeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/home/add.jsp");
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String description = request.getParameter("preview_text");
		Part part = request.getPart("picture");
		String fileName = FileUtil.rename(part.getSubmittedFileName());
		Home objHome = new Home(fileName, description);
		if(homeDAO.addItem(objHome)!= 0) {
			if(!"".equals(fileName)) {
				String dirPath =request.getServletContext().getRealPath("")+DefineUtil.DIR_UPLOAD_HOM;
				File dir= new File(dirPath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				String filePath = dirPath + File.separator + fileName;
				part.write(filePath);
				System.out.println(filePath);
			}
			response.sendRedirect(request.getContextPath()+"/admin/homes?msg="+1);
			return;
			
		}else {
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/home/add.jsp?err="+1);
			rd.forward(request, response);
			return;
		}
	}

}

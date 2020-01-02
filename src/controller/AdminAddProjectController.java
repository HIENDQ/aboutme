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

import model.bean.Project;
import model.dao.ProjectDAO;
import utils.AuthUtil;
import utils.DefineUtil;
import utils.FileUtil;

@MultipartConfig
public class AdminAddProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDAO projectDAO;
       
    public AdminAddProjectController() {
        super();
        projectDAO = new ProjectDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/project/add.jsp");
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String nameProject = request.getParameter("name");
		String linkProject = request.getParameter("link");
		Part part = request.getPart("picture");
		
		String fileName = FileUtil.rename(part.getSubmittedFileName());
		Project objProject = new Project(nameProject, fileName, linkProject);
		if(projectDAO.addItem(objProject)!= 0) {
			if(!"".equals(fileName)) {
				String dirPath =request.getServletContext().getRealPath("")+DefineUtil.DIR_UPLOAD_PROJ;
				File dir= new File(dirPath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				String filePath = dirPath + File.separator + fileName;
				part.write(filePath);
				System.out.println(filePath);
			}
			response.sendRedirect(request.getContextPath()+"/admin/projects?msg="+1);
			return;
			
		}else {
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/project/add.jsp?err="+1);
			rd.forward(request, response);
			return;
		}
	}

}

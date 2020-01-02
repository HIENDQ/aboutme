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
public class AdminEditProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDAO projectDAO;

    public AdminEditProjectController() {
        super();
        projectDAO= new ProjectDAO();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_Project =0;
		try {
			id_Project= Integer.parseInt(request.getParameter("id"));
			Project objProject = projectDAO.getItem(id_Project);
			
			if(objProject!= null) {
				request.setAttribute("objProject", objProject);
				RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/project/edit.jsp");
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
		int id_Project=0;
		try {
			id_Project = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			return;
		}
		String picture ="";
		Part part = request.getPart("picture");
		String fileName = FileUtil.rename(part.getSubmittedFileName());
		try {
			picture=projectDAO.getItem(id_Project).getPicture_Project();
		} catch (Exception e) {
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/project/edit.jsp?err="+3+"&id="+id_Project);
			rd.forward(request, response);
			return;
		}
		String nameProject = request.getParameter("name");
		String linkProject = request.getParameter("link");
		
		if("".equals(fileName)) {
			fileName= picture;
		}
		Project objProject = new Project(id_Project,nameProject, fileName, linkProject);
		if(projectDAO.editItem(objProject)!= 0) {
			//xóa file cũ
			String dirPath = request.getServletContext().getRealPath("") + DefineUtil.DIR_UPLOAD_PROJ;
			String filePath = dirPath + File.separator + picture;
			File file= new File(filePath);
			if(file.exists()) {
				file.delete();
			}
			
			filePath = dirPath + File.separator + fileName;
			part.write(filePath);
			response.sendRedirect(request.getContextPath() + "/admin/projects?msg=" + 3);
			return;
		}else {
			System.out.println("hy");
			request.setAttribute("picture", picture);
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/project/edit.jsp?err="+3+"&id="+objProject.getId_Project());
			rd.forward(request, response);
			return;
		}
		
	}

}

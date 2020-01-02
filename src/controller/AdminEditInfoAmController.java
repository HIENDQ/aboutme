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

import model.bean.Info;
import model.dao.InfoDAO;
import utils.AuthUtil;
import utils.DefineUtil;
import utils.FileUtil;

@MultipartConfig
public class AdminEditInfoAmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InfoDAO infoDAO;   

    public AdminEditInfoAmController() {
        super();
        infoDAO = new InfoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		Info objInfo = infoDAO.getAboutme();
		request.setAttribute("objInfo", objInfo);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/info/editam.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String ct="";
        
        String img = infoDAO.getItem().getImg();
        ct= request.getParameter("am");
    	
    	Part part = request.getPart("picture");
    	String fileName = FileUtil.rename(part.getSubmittedFileName());
    	if("".equals(fileName)) {
			fileName= img;
		}
    	else {
			//xóa file cũ
			String dirPath = request.getServletContext().getRealPath("") + DefineUtil.DIR_UPLOAD_PROJ;
			String filePath = dirPath + File.separator + img;
			File file= new File(filePath);
			File dir= new File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			if(file.exists()) {
				file.delete();
			}
			filePath = dirPath + File.separator + fileName;
			part.write(filePath);
		}
    	
    	Info objInfo = new Info(ct, fileName);
    	if(infoDAO.editAboutme(objInfo)!= 0) {
    		response.sendRedirect(request.getContextPath() + "/admin/info?msg=" + 3);
			return;
    	}else {
    		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/info/editam.jsp?err="+3);
			rd.forward(request, response);
			return;
    	}
    	
    	
		
	}

}

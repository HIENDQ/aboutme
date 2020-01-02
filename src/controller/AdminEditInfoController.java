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
public class AdminEditInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InfoDAO infoDAO;   

    public AdminEditInfoController() {
        super();
        infoDAO = new InfoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		Info objInfo = infoDAO.getItems();
		request.setAttribute("objInfo", objInfo);
		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/info/edit.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String name="";
        String email ="";
        String phone = "";
        String address ="";
        String describe ="";
        String picture = infoDAO.getItem().getPicture();
        name= request.getParameter("name");
    	email = request.getParameter("email");
    	phone = request.getParameter("phone");
    	address = request.getParameter("address");
    	describe = request.getParameter("describe");
    	Part part = request.getPart("picture");
    	String fileName = FileUtil.rename(part.getSubmittedFileName());
    	if("".equals(fileName)) {
			fileName= picture;
		}
    	else {
			//xóa file cũ
			String dirPath = request.getServletContext().getRealPath("") + DefineUtil.DIR_UPLOAD_PROJ;
			String filePath = dirPath + File.separator + picture;
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
    	
    	Info objInfo = new Info(name, describe, fileName, email, phone, address);
    	if(infoDAO.editItem(objInfo)>0) {
    		response.sendRedirect(request.getContextPath() + "/admin/info?msg=" + 3);
			return;
    	}else {
    		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/information/info/edit.jsp?err="+3);
			rd.forward(request, response);
			return;
    	}
    	
    	
		
	}

}

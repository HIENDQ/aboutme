package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Cat;
import model.bean.New;
import model.dao.CatDAO;
import model.dao.NewsDAO;
import utils.AuthUtil;
import utils.DefineUtil;
import utils.FileUtil;

@MultipartConfig
public class AdminEditNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDAO newsDAO;
	private CatDAO catDAO;

    public AdminEditNewController() {
        super();
        newsDAO= new NewsDAO();
        catDAO = new CatDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		int id_new =0;
		try {
			id_new= Integer.parseInt(request.getParameter("id"));
			New objNew = newsDAO.getItem(id_new);
			ArrayList<Cat> listCat = catDAO.getItems(); 
			if(objNew!= null) {
				request.setAttribute("objNew", objNew);
				request.setAttribute("listCat", listCat);
				RequestDispatcher rd= request.getRequestDispatcher("/views/admin/post/new/edit.jsp");
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
		int id_New = Integer.parseInt(request.getParameter("id"));
		String picture=newsDAO.getItem(id_New).getPicture_New();
		
		String nameNew = request.getParameter("name");
		int idCatNew = Integer.parseInt(request.getParameter("cat"));
		String description = request.getParameter("preview_text");
		String detail = request.getParameter("detail_text");
		Part part = request.getPart("picture");
		String fileName = FileUtil.rename(part.getSubmittedFileName());
		if("".equals(fileName)) {
			fileName= picture;
		}else {
			//xóa file cũ
			String dirPath = request.getServletContext().getRealPath("") + DefineUtil.DIR_UPLOAD;
			String filePath = dirPath + File.separator + picture;
			File file= new File(filePath);
			if(file.exists()) {
				file.delete();
			}
			filePath = dirPath + File.separator + fileName;
			part.write(filePath);
		}
		New objNew = new New(id_New,nameNew, description, detail, new Cat(idCatNew), fileName); 
		if(newsDAO.editItem(objNew)!= 0) {
			response.sendRedirect(request.getContextPath() + "/admin/news?msg=" + 3);
			return;
		}else {
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/post/new/edit.jsp?err="+3);
			rd.forward(request, response);
			return;
		}
		
	}

}

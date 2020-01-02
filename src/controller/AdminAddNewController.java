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
public class AdminAddNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDAO newsDAO;
	private CatDAO catDAO;
       
    public AdminAddNewController() {
        super();
        newsDAO = new NewsDAO();
        catDAO = new CatDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.isLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		if(catDAO.getItems()!=null) {
			ArrayList<Cat> listCat = catDAO.getItems(); 
			request.setAttribute("listCat", listCat);
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/post/new/add.jsp");
			rd.forward(request, response);
		}else {
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String nameNew = request.getParameter("name");
		int idCatNew = Integer.parseInt(request.getParameter("cat"));
		String description = request.getParameter("preview_text");
		String detail = request.getParameter("detail_text");
		Part part = request.getPart("picture");
		String fileName = FileUtil.rename(part.getSubmittedFileName());
		New objNew = new New(nameNew, description, detail, new Cat(idCatNew), fileName);
		if(newsDAO.addItem(objNew)!= 0) {
			if(!"".equals(fileName)) {
				String dirPath =request.getServletContext().getRealPath("")+DefineUtil.DIR_UPLOAD;
				File dir= new File(dirPath);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				String filePath = dirPath + File.separator + fileName;
				part.write(filePath);
				System.out.println(filePath);
			}
			response.sendRedirect(request.getContextPath()+"/admin/news?msg="+1);
			return;
			
		}else {
			RequestDispatcher rd= request.getRequestDispatcher("/views/admin/post/new/add.jsp?err="+1);
			rd.forward(request, response);
			return;
		}
	}

}

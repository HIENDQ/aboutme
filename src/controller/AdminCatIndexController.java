//package controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import model.bean.Cat;
//import model.dao.CatDAO;
//import utils.AuthUtil;
//
//
//public class AdminCatIndexController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private CatDAO catDAO;
//       
//    public AdminCatIndexController() {
//        super();
//        catDAO = new CatDAO();
//    }
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("hello");
//		ArrayList<Cat> listCat = catDAO.getItemsBySTT();
//		for (Cat cat : listCat) {
//			System.out.println("x");
//			System.out.println(cat.getStt());
//		}
//		request.setAttribute("listCat", listCat);
//		RequestDispatcher rd= request.getRequestDispatcher("/views/admin/post/cat/index.jsp");
//		rd.forward(request, response);
//	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}
//
//}

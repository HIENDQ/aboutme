package ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.New;
import model.dao.NewsDAO;
import utils.DefineUtil;


@WebServlet("/page")
public class PublicGetPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsDAO newsDAO;    
    public PublicGetPage() {
        super();
        newsDAO = new NewsDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int offset=(currentPage-1)*DefineUtil.NUMBER_PER_PAGE;
		ArrayList<New> listNew =newsDAO.getItemsPagination(offset);
		
		request.setAttribute("listNew", listNew);
		request.setAttribute("currentPage", currentPage);
		RequestDispatcher rd= request.getRequestDispatcher("/views/ajax/public/pagenew.jsp");
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

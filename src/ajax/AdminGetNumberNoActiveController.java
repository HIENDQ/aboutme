package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;


@WebServlet("/admin/news/numbernoactive")
public class AdminGetNumberNoActiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsDAO newsDAO;

    public AdminGetNumberNoActiveController() {
        super();
        newsDAO = new NewsDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numberNoActive =0;
		numberNoActive= newsDAO.getNumberNoactive();
		PrintWriter out = response.getWriter();
		if(numberNoActive>0) {
			out.print("<span title=\"Có bài viết đang chờ kiểm duyệt\" class=\"badge ac123\">"+numberNoActive+"</span>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HomeDAO;

@WebServlet("/admin/homes/active")
public class AdminHomeActive extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeDAO homeDAO;
       
    public AdminHomeActive() {
        super();
        homeDAO= new HomeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int active=Integer.parseInt(request.getParameter("active"));
		int nid = Integer.parseInt(request.getParameter("nid"));
		if(active>0)active=0;
		else active=1;
		homeDAO.editItem(nid, active);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

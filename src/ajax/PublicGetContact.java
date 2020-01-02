package ajax;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;



public class PublicGetContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;   

    public PublicGetContact() {
        super();
        contactDAO = new ContactDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email =request.getParameter("email");
		String phone= request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		if("".equals(name)||"".equals(email)||"".equals(phone)||"".equals(address)||"".equals(message)) {
			return;
		}else {
			Contact objContact = new Contact(name, email, address, phone, message);
			contactDAO.addItem(objContact);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

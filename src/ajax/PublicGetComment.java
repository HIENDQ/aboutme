package ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Comment;
import model.bean.New;
import model.dao.CommentDAO;


@WebServlet("/comment/news")
public class PublicGetComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDAO commentDAO;

    public PublicGetComment() {
        super();
        commentDAO = new CommentDAO();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int id = 0;
		try {
			id= Integer.parseInt(request.getParameter("id"));
		} catch ( Exception e) {
			return;
		}
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		if(!"".equals(name) && !"".equals(content)) {
			Comment objComment = new Comment( new New(id),name , content);
			if(commentDAO.addItem(objComment) > 0) {
				ArrayList<Comment> listComment = commentDAO.getItemsByNew(id , 0);
				request.setAttribute("listComment", listComment);
				RequestDispatcher rd= request.getRequestDispatcher("/views/ajax/public/comment.jsp");
				rd.forward(request, response);
			}
		}
	}

}

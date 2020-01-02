package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Comment;
import model.bean.New;
import utils.ConnectDBUtil;
import utils.DefineUtil;

public class CommentDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public ArrayList<Comment> getItems(int offset) {

		ArrayList<Comment> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT c.id_comment, c.author, c.content, c.id_news, n.name ,"
				+ " c.date_create FROM comments AS c JOIN news AS n ON c.id_news = n.id_news"
				+ " ORDER BY c.id_comment DESC LIMIT ? , ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_CMT_ADMIM);
			rs = pst.executeQuery();

			while (rs.next()) {
				//int id, String name, String usreName, String pass, String email, int role
				Comment objComment = new Comment(rs.getInt("id_comment"), new New(rs.getInt("id_news"), rs.getString("name")), rs.getString("author"),
						rs.getString("content"), rs.getDate("date_create"), rs.getTime("date_create"));

				listItem.add(objComment);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public ArrayList<Comment> getItemsByNew(int idNew , int n) {

		ArrayList<Comment> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT c.id_comment, c.author, c.content, c.id_news,"
				+ " n.name , c.date_create FROM comments AS c JOIN news AS n ON c.id_news = n.id_news "
				+ "WHERE c.id_news = ?   ORDER BY id_comment DESC LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNew);
			pst.setInt(2, n);
			pst.setInt(3, DefineUtil.NUMBER_CMT_PUBLIC);
			rs = pst.executeQuery();

			while (rs.next()) {
				Comment objComment = new Comment(rs.getInt("id_comment"), new New(rs.getInt("id_news"), rs.getString("name")),
						rs.getString("author"), rs.getString("content"), rs.getDate("date_create"), rs.getTime("date_create"));

				listItem.add(objComment);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;
	}
	public Comment getItem(int id_Comment) {
		Comment objComment= null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM comments WHERE id_comment=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Comment);
			rs = pst.executeQuery();
			while (rs.next()) {
				objComment = new Comment(rs.getInt("id_comment"), 
						new New(rs.getInt("id_news"), ""),
						rs.getString("author"), rs.getString("content") ,
						rs.getDate("date_create"), rs.getTime("date_create"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objComment;
	}
	public ArrayList<Comment> getItemsByNameNew(String name) {
		System.out.println(name +"v");
		ArrayList<Comment> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT c.id_comment, c.author, c.content, c.id_news, n.name , "
				+ "c.date_create FROM comments AS c JOIN news AS n ON c.id_news = n.id_news WHERE n.name =? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				Comment objComment = new Comment(rs.getInt("id_comment"), 
						new New(rs.getInt("id_news"), rs.getString("name")),
						rs.getString("author"), rs.getString("content"), rs.getDate("date_create")
						, rs.getTime("date_create"));

				listItem.add(objComment);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;
	}
	public ArrayList<Comment> getItemsByViewer(String name) {

		ArrayList<Comment> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT c.id_comment, c.author, c.content, c.id_news, n.name , c.date_create FROM comments AS c JOIN news"
				+ " AS n ON c.id_news = n.id_news WHERE c.author =? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				//int id, String name, String usreName, String pass, String email, int role
				Comment objComment = new Comment(rs.getInt("id_comment"), new New(rs.getInt("id_news"),
						rs.getString("name")), rs.getString("author"),
						rs.getString("content") , rs.getDate("date_create"), rs.getTime("date_create"));

				listItem.add(objComment);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;
	}
	public int delItem(int id_Comment) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "DELETE FROM comments WHERE id_comment =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Comment);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			ConnectDBUtil.close(pst, conn);
			;
		}
		return result;
	}
	public int delItemByNew(int id_News) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "DELETE FROM comments WHERE id_news =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_News);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			ConnectDBUtil.close(pst, conn);
			;
		}
		return result;
	}
	public int delItemByViewer(String name) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "DELETE FROM comments WHERE author =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			ConnectDBUtil.close(pst, conn);
			;
		}
		return result;
	}
	public int addItem(Comment objComment) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO comments (id_news, author, content) VALUES(?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objComment.getObjNew().getId_New());
			pst.setString(2, objComment.getAuthor());
			pst.setString(3, objComment.getContent());
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			ConnectDBUtil.close(pst, conn);
			;
		}
		return result;
	}
	public int getNumberOfItems() {
		conn = ConnectDBUtil.getConnection();
		int number =0;
		String sql = "SELECT COUNT(*) AS c FROM comments";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				number = rs.getInt("c");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return number;
	}
}

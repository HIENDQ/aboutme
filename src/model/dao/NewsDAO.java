package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Cat;
import model.bean.New;
import utils.ConnectDBUtil;
import utils.DefineUtil;

public class NewsDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;

	public ArrayList<New> getItems(int offset) {

		ArrayList<New> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT n.id_news, n.name AS newName, n.preview_text,"
				+ "n.detail_text, n.id_cat,c.name AS catName,"
				+ "n.picture, n.count_number, n.active  FROM news AS n JOIN cat AS c ON n.id_cat= c.id_cat ORDER BY n.id_news DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_NEWS_ADMIM);
			rs = pst.executeQuery();

			while (rs.next()) {
				New objNew = new New(rs.getInt("id_news"), rs.getString("newName"), rs.getString("preview_text"),
						rs.getString("detail_text"), new Cat(rs.getInt("id_cat"), rs.getString("catName")), rs.getString("picture"),
						rs.getInt("count_number"), rs.getInt("active"));

				listItem.add(objNew);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public ArrayList<New> getItemsPagination(int offset) {

		ArrayList<New> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM (SELECT n.id_news, n.name AS newName, n.preview_text,n.detail_text, n.id_cat,c.name AS catName,n.picture, n.count_number, n.active FROM news AS n JOIN cat AS c ON n.id_cat= c.id_cat WHERE active =1 )  AS t ORDER BY t.id_news DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();

			while (rs.next()) {
				New objNew = new New(rs.getInt("id_news"), rs.getString("newName"), rs.getString("preview_text"),
						rs.getString("detail_text"), new Cat(rs.getInt("id_cat"), rs.getString("catName")), rs.getString("picture"),
						rs.getInt("count_number"), rs.getInt("active"));

				listItem.add(objNew);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;
	}

	public New getItem(int id) {
		New objNew = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM news WHERE id_news=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				objNew = new New(rs.getInt("id_news"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), new Cat(rs.getInt("id_cat")), rs.getString("picture"),
						rs.getInt("count_number"), rs.getInt("active"));
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs,pst, conn);
		}
		return objNew;
	}

	public New getItemActive(int id) {
		New objNew = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM (SELECT n.id_news, n.name AS newName, n.preview_text,n.detail_text, n.id_cat,c.name AS catName,n.picture, n.count_number, n.active FROM news AS n JOIN cat AS c ON n.id_cat= c.id_cat WHERE active =1 ) "
				+ " AS t WHERE t.id_news = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				objNew = new New(rs.getInt("id_news"), rs.getString("newName"), rs.getString("preview_text"),
						rs.getString("detail_text"), new Cat(rs.getInt("id_cat"), rs.getString("catName")), rs.getString("picture"),
						rs.getInt("count_number"), rs.getInt("active"));
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs,pst, conn);
		}
		return objNew;
	}
	public int editItem(New objNew) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  news AS n  SET name=?," + " preview_text=?, detail_text=?," + " id_cat =?, picture =?"
				+ " WHERE n.id_news =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objNew.getName_New());
			pst.setString(2, objNew.getPreview_New());
			pst.setString(3, objNew.getDetail_New());
			pst.setInt(4, objNew.getCat_New().getId_Cat());
			pst.setString(5, objNew.getPicture_New());
			pst.setInt(6, objNew.getId_New());
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}

	public int addItem(New objNew) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO news(name, preview_text,detail_text,id_cat,picture)"
				+ "VALUES(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objNew.getName_New());
			pst.setString(2, objNew.getPreview_New());
			pst.setString(3, objNew.getDetail_New());
			pst.setInt(4, objNew.getCat_New().getId_Cat());
			pst.setString(5, objNew.getPicture_New());
			
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

	public int delItem(int id_New) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "DELETE FROM news WHERE id_news =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_New);
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
	public int delItemByCat(int id_Cat) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "DELETE FROM news WHERE id_cat =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Cat);
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}
	public int editItem(int id, int active) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  news  SET active=? WHERE id_news=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, active);
			pst.setInt(2, id);
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close( pst, conn);
		}
		return result;
	}
	public int getNumberOfItems() {
		conn = ConnectDBUtil.getConnection();
		int number =0;
		String sql = "SELECT COUNT(*) AS c FROM news";
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
	public int getNumberNoactive() {
		conn = ConnectDBUtil.getConnection();
		int number =0;
		String sql = "SELECT COUNT(*) AS c FROM news WHERE active =0";
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
	public int getNumberOfActive() {
		conn = ConnectDBUtil.getConnection();
		int number =0;
		String sql = "SELECT COUNT(*) AS c FROM news WHERE active =1";
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
	public ArrayList<New> getItemsByCat(int id_cat , int offset ) {

		ArrayList<New> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM (SELECT n.id_news, n.name AS newName, n.preview_text,n.detail_text, n.id_cat,c.name AS catName,n.picture, n.count_number, n.active FROM news AS n JOIN cat AS c ON n.id_cat= c.id_cat WHERE active =1 )  AS t WHERE id_cat=? ORDER BY id_news  DESC LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_cat);
			pst.setInt(2, offset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE_BY_CAT);
			
			rs = pst.executeQuery();

			while (rs.next()) {
				New objNew = new New(rs.getInt("id_news"), rs.getString("newName"), rs.getString("preview_text"),
						rs.getString("detail_text"), new Cat(rs.getInt("id_cat"), rs.getString("catName")), rs.getString("picture"),
						rs.getInt("count_number"), rs.getInt("active"));

				listItem.add(objNew);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;
	}
	public ArrayList<New> getItemsMostRead(int number) {

		ArrayList<New> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM (SELECT n.id_news, n.name AS newName, n.preview_text,n.detail_text, n.id_cat,c.name AS catName,n.picture, n.count_number, n.active FROM news AS n JOIN cat AS c ON n.id_cat= c.id_cat WHERE active =1 )  AS t ORDER BY count_number DESC LIMIT ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, number);
			rs = pst.executeQuery();

			while (rs.next()) {
				New objNew = new New(rs.getInt("id_news"), rs.getString("newName"), rs.getString("preview_text"),
						rs.getString("detail_text"), new Cat(rs.getInt("id_cat"), rs.getString("catName")), rs.getString("picture"),
						rs.getInt("count_number"), rs.getInt("active"));

				listItem.add(objNew);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;
	}
	public ArrayList<New> getItemsByCat( int id_Cat) {

		ArrayList<New> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql =  "SELECT * FROM (SELECT n.id_news, n.name AS newName, n.preview_text,n.detail_text, n.id_cat,c.name AS catName,n.picture, n.count_number, n.active FROM news AS n JOIN cat AS c ON n.id_cat= c.id_cat WHERE active =1 ) "
				+ " AS t WHERE t.id_cat = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Cat);
			rs = pst.executeQuery();
			while (rs.next()) {
				New objNew = new New(rs.getInt("id_news"), rs.getString("newName"), rs.getString("preview_text"),
						rs.getString("detail_text"), new Cat(rs.getInt("id_cat"), rs.getString("catName")), rs.getString("picture"),
						rs.getInt("count_number"), rs.getInt("active"));

				listItem.add(objNew);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	
	public int increaseView(New objNew) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  news  SET count_number = ? WHERE id_news=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, (objNew.getCount_New()+1));
			pst.setInt(2, objNew.getId_New());
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close( pst, conn);
		}
		return result;
	}
}

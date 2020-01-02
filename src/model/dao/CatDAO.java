package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Cat;
import utils.ConnectDBUtil;

public class CatDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;

	public ArrayList<Cat> getItems() {

		ArrayList<Cat> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM cat";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				// int id, String name, String usreName, String pass, String email, int role
				Cat objCat = new Cat(rs.getInt("id_cat"), rs.getString("name"));

				listItem.add(objCat);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public ArrayList<Cat> getItemsBySTT() {

		ArrayList<Cat> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM cat ORDER BY stt";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Cat objCat = new Cat(rs.getInt("id_cat"), rs.getString("name") , rs.getInt("stt"));
				listItem.add(objCat);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public int addItem(Cat objCat) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO cat (name) VALUES(?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objCat.getName_Cat());
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

	public Cat getItem(int id_Cat) {
		Cat objCat = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM cat WHERE id_cat=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Cat);
			rs = pst.executeQuery();
			while (rs.next()) {
				objCat = new Cat(rs.getInt("id_cat"), rs.getString("name"));

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objCat;
	}

	public int editItem(Cat objCat) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  cat  SET name=? WHERE id_cat=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objCat.getName_Cat());
			pst.setInt(2, objCat.getId_Cat());
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close( pst, conn);
		}
		return result;
	}
	public int delItem(int id_Cat) {
		int result=0;
		conn = ConnectDBUtil.getConnection();
		String sql= "DELETE FROM cat WHERE id_cat =?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id_Cat);
			result=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();;
		}finally {
			ConnectDBUtil.close(pst, conn);;
		}
		return result;
	}
}

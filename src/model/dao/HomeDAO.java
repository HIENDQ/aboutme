package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Home;
import utils.ConnectDBUtil;

public class HomeDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public ArrayList<Home> getItems() {

		ArrayList<Home> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM homes";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Home objHome =new Home(rs.getInt("id_home"),
						rs.getString("preview"), rs.getInt("active"),rs.getString("picture"));

				listItem.add(objHome);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public ArrayList<Home> getItemsByActive() {

		ArrayList<Home> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM homes WHERE active=1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Home objHome =new Home(rs.getInt("id_home"),
						rs.getString("preview"), rs.getInt("active"),rs.getString("picture"));

				listItem.add(objHome);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public int addItem(Home objHome) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO homes (preview, picture) VALUES(?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objHome.getDep());
			pst.setString(2, objHome.getPicture());
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
	public Home getItem(int id_Home) {
		Home objHome = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM homes WHERE id_home=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Home);
			rs = pst.executeQuery();
			while (rs.next()) {
				objHome =new Home(rs.getInt("id_home"),
						rs.getString("preview"), rs.getInt("active"),rs.getString("picture"));

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objHome;
	}
	public int editItem(Home objHome) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  homes  SET preview=?,picture=?,active=active   WHERE id_home=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objHome.getDep());
			pst.setString(2, objHome.getPicture());
			pst.setInt(3, objHome.getId());
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close( pst, conn);
		}
		return result;
	}
	public int editItem( int id, int active) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  homes  SET active=?  WHERE id_home=?";
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
	public int delItem(int id_Home) {
		int result=0;
		conn = ConnectDBUtil.getConnection();
		String sql= "DELETE FROM homes WHERE id_home =?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id_Home);
			result=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();;
		}finally {
			ConnectDBUtil.close(pst, conn);;
		}
		return result;
	}
}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Experience;
import utils.ConnectDBUtil;

public class ExperienceDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public ArrayList<Experience> getItems() {

		ArrayList<Experience> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM experience";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Experience objEx= new Experience(rs.getInt("id_ex"),
						rs.getString("name_ex"),
						rs.getString("time"),
						rs.getString("preview"));

				listItem.add(objEx);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public int addItem(Experience objEx) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO experience (name_ex , time, preview) VALUES(? , ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objEx.getName_ex());
			pst.setString(2, objEx.getTime_ex());
			pst.setString(3, objEx.getDescribe_ex());
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}
	public Experience getItem(int id_Ex) {
		Experience objEx = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM experience WHERE id_ex=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Ex);
			rs = pst.executeQuery();
			if(rs.next()) {
				objEx= new Experience(rs.getInt("id_ex"),
						rs.getString("name_ex"),
						rs.getString("time"),
						rs.getString("preview"));

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objEx;
	}
	public int editItem(Experience objEx) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  experience  SET name_ex=?  , time= ? , preview=? WHERE id_ex=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objEx.getName_ex());
			pst.setString(2, objEx.getTime_ex());
			pst.setString(3, objEx.getDescribe_ex());
			pst.setInt(4, objEx.getId_ex());
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close( pst, conn);
		}
		return result;
	}
	public int delItem(int id_Ex) {
		int result=0;
		conn = ConnectDBUtil.getConnection();
		String sql= "DELETE FROM experience WHERE id_ex =?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id_Ex);
			result=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();;
		}finally {
			ConnectDBUtil.close(pst, conn);;
		}
		return result;
	}
}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import model.bean.Project;
import utils.ConnectDBUtil;

public class ProjectDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public ArrayList<Project> getItems() {

		ArrayList<Project> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM projects ORDER BY id_project DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Project objProject = new Project(rs.getInt("id_project"),
						 rs.getString("name"), 
						 rs.getString("picture"),
						 rs.getString("link")
						 );
				listItem.add(objProject);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public int addItem(Project objProject) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO projects (name,picture, link) VALUES(?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objProject.getName_Project());
			pst.setString(2, objProject.getPicture_Project());
			pst.setString(3, objProject.getLink_Project());
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}
	public Project getItem(int id_Cat) {
		Project objProject = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM projects WHERE id_project=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Cat);
			rs = pst.executeQuery();
			while (rs.next()) {
				objProject = new Project(rs.getInt("id_project"),
						 rs.getString("name"), 
						 rs.getString("picture"),
						 rs.getString("link"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objProject;
	}
	public int editItem(Project objProject) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  projects  SET name=? ,picture=?, link =? WHERE id_project=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objProject.getName_Project());
			pst.setString(2, objProject.getPicture_Project());
			pst.setString(3, objProject.getLink_Project());
			pst.setInt(4, objProject.getId_Project());
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close( pst, conn);
		}
		return result;
	}
	public int delItem(int id_Project) {
		int result=0;
		conn = ConnectDBUtil.getConnection();
		String sql= "DELETE FROM projects WHERE id_project =?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id_Project);
			result=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();;
		}finally {
			ConnectDBUtil.close(pst, conn);;
		}
		return result;
	}
}

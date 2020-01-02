package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Skill;
import utils.ConnectDBUtil;

public class SkillDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public ArrayList<Skill> getItems() {
		ArrayList<Skill> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM skills";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Skill objSkill = new Skill(rs.getInt("id_skill"), rs.getInt("value"), rs.getString("name"));
				listItem.add(objSkill);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public int addItem(Skill objSkill) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO skills (name,value ) VALUES(?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objSkill.getName_Skill());
			pst.setInt(2, objSkill.getValus());
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
	public int delItem(int id_Skill) {
		int result=0;
		conn = ConnectDBUtil.getConnection();
		String sql= "DELETE FROM skills WHERE id_skill =?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id_Skill);
			result=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();;
		}finally {
			ConnectDBUtil.close(pst, conn);;
		}
		return result;
	}
	public Skill getItem(int id_Skill) {
		Skill objSkill = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM skills WHERE id_skill=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Skill);
			rs = pst.executeQuery();
			while (rs.next()) {
				objSkill = new Skill(rs.getInt("id_skill"), rs.getInt("value"), rs.getString("name"));

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objSkill;
	}
	public boolean hasItem(Skill objSkill) {
		conn = ConnectDBUtil.getConnection();
		String sql= "SELECT * FROM skills WHERE name=? AND id_skill!= ? ";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, objSkill.getName_Skill());
			pst.setInt(2, objSkill.getId_skill());
			rs = pst.executeQuery();
			if(rs.next()) {
				ConnectDBUtil.close(rs, pst, conn);
				return  true;
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return false;
	}
	public int editItem(Skill objSkill) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  skills  SET name=? , value =?  WHERE id_skill=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objSkill.getName_Skill());
			pst.setInt(2, objSkill.getValus());
			pst.setInt(3, objSkill.getId_skill());
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close( pst, conn);
		}
		return result;
	}
}

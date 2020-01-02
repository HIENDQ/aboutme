package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import model.bean.Info;
import utils.ConnectDBUtil;

public class InfoDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public Info getItems() {

		Info objInfo = null ;
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM info";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				objInfo = new Info(
						rs.getString("fullname"),
						rs.getString("preview"),
						rs.getString("picture"),
						rs.getString("email"), 
						rs.getString("phone"), 
						rs.getString("address"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return objInfo;
	}

	public Info getInfo() {

		Info objInfo = null ;
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM info";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				objInfo = new Info(rs.getInt("id_info"),
						rs.getInt("active"),
						rs.getString("fullname"),
						rs.getString("preview"),
						rs.getString("picture"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("gt"),
						rs.getString("img")
						);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return objInfo;
	}
	public Info getItem() {
		Info objInfor = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM info";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objInfor = new Info(rs.getString("email"), rs.getString("phone"), rs.getString("address")); 
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objInfor;
	}
	public Info getAboutme() {
		Info objInfo = null ;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM info";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				objInfo = new Info(
						rs.getString("gt"),
						rs.getString("img"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return objInfo;
	}
	public int editItem(Info objInfo) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  info  SET fullname=?, picture=?, preview=? , email =?, phone= ?, address =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objInfo.getFullname());
			pst.setString(2, objInfo.getPicture());
			pst.setString(3, objInfo.getPreview());
			pst.setString(4, objInfo.getEmail());
			pst.setString(5, objInfo.getPhone());
			pst.setString(6, objInfo.getAddress());
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close( pst, conn);
		}
		return result;
	}
	public int editAboutme(Info objInfo) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  info  SET gt=?, img=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objInfo.getCt());
			pst.setString(2, objInfo.getImg());
			
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close( pst, conn);
		}
		return result;
	}


}

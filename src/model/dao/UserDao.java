package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Role;
import model.bean.User;
import utils.ConnectDBUtil;

public class UserDao {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public ArrayList<User> getItems() {

		ArrayList<User> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT u.id, u.name, u.username, u.password, u.email, u.id_role, r.name AS role_name FROM users AS u JOIN roles AS r ON u.id_role=r.id_role";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				User objUser = new User(
						rs.getInt("id"), 
						rs.getString("name"),
						rs.getString("username"),
						rs.getString("password") ,
						rs.getString("email"),
						new Role(rs.getInt("id_role"), rs.getString("role_name"))
						);

				listItem.add(objUser);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public User getItem(int id) {
		User user= null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT u.id, u.name, u.username, u.password, u.email, u.id_role, r.name FROM users AS u JOIN roles AS r ON u.id_role=r.id_role WHERE u.id =?";

		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				user= new User(
						rs.getInt("id"), 
						rs.getString("name"),
						rs.getString("username"),
						rs.getString("password") ,
						rs.getString("email"),
						new Role(rs.getInt("id_role"), rs.getString("name"))
						);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			ConnectDBUtil.close(rs,pst, conn);
		}
		return user;
	}
	public User getItem(User user) {
		User objUser= null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT u.id,"
				+ " u.name, "
				+ "u.username,"
				+ " u.password,"
				+ " u.email,"
				+ " u.id_role,"
				+ " r.name FROM users AS u JOIN roles AS r ON u.id_role=r.id_role  "
				+ " WHERE username= ? AND password= ?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getUsreName());
			pst.setString(2, user.getPass());
			rs = pst.executeQuery();
			if(rs.next()) {
				objUser= new User(
						rs.getInt("id"), 
						rs.getString("name"),
						rs.getString("username"),
						rs.getString("password") ,
						rs.getString("email"),
						new Role(rs.getInt("id_role"), rs.getString("name"))
						);
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objUser;
	}
	public int editItem(User user) {
		int result=0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE  users  SET name=? ,id_role=?, password=? ,email =? WHERE id =?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setInt(2, user.getRole().getId_Role());
			pst.setString(3, user.getPass());
			pst.setString(4, user.getEmail());
			pst.setInt(5, user.getId());
			result =pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}
	public int addItem(User objUser) {
		int result=0;
		conn = ConnectDBUtil.getConnection();
		String sql= "INSERT INTO users(username, password, name, id_role, email ) VALUES(?,?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, objUser.getUsreName());
			pst.setString(2, objUser.getPass());
			pst.setString(3, objUser.getName());
			pst.setInt(4, objUser.getRole().getId_Role());
			pst.setString (5 , objUser.getEmail());
			result=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();;
		}finally {
			ConnectDBUtil.close(pst, conn);;
		}
		return result;
	}
	public boolean hasUser(String user) {
		conn = ConnectDBUtil.getConnection();
		String sql= "SELECT * FROM users WHERE username=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user);
			rs = pst.executeQuery();
			if(rs.next()) {
				return  true;
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return false;
	}
	public int delItem(int id) {
		int result=0;
		conn = ConnectDBUtil.getConnection();
		String sql= "DELETE FROM users WHERE id =?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			result=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();;
		}finally {
			ConnectDBUtil.close(pst, conn);;
		}
		return result;
	}


}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import model.bean.Contact;
import utils.ConnectDBUtil;

public class ContactDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public ArrayList<Contact> getItems() {

		ArrayList<Contact> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM contact ORDER BY id_contact DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Contact objContact = new Contact(rs.getInt("id_contact"), 
						rs.getString("fullname"),  
						rs.getString("email"), 
						rs.getString("address"), 
						rs.getString("phone"), 
						rs.getString("content"));

				listItem.add(objContact);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public int addItem(Contact objContact) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO contact (fullname, email, address, phone, content) VALUES(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objContact.getFullName());
			pst.setString(2, objContact.getEmail());
			pst.setString(3, objContact.getAddress());
			pst.setString(4, objContact.getPhone());
			pst.setString(5, objContact.getContent());
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

	public int delItem(int id_Contact) {
		int result=0;
		conn = ConnectDBUtil.getConnection();
		String sql= "DELETE FROM contact WHERE id_contact =?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id_Contact);
			result=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();;
		}finally {
			ConnectDBUtil.close(pst, conn);;
		}
		return result;
	}
}

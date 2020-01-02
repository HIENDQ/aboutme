package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Role;
import utils.ConnectDBUtil;

public class RoleDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	public ArrayList<Role> getItems() {

		ArrayList<Role> listItem = new ArrayList<>();
		conn = ConnectDBUtil.getConnection();

		String sql = "SELECT * FROM roles ORDER BY id_role DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Role  objRole= new Role(rs.getInt("id_role"), rs.getString("name"), rs.getString("func"));
				listItem.add(objRole);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
}

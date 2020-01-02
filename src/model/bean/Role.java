package model.bean;

public class Role {
	private int id_Role;
	private String name_Role;
	private String func;
	
	public Role(int id_Role, String name_Role, String func) {
		super();
		this.id_Role = id_Role;
		this.name_Role = name_Role;
		this.func = func;
	}
	public String getFunc() {
		return func;
	}
	public void setFunc(String func) {
		this.func = func;
	}
	public int getId_Role() {
		return id_Role;
	}
	public void setId_Role(int id_Role) {
		this.id_Role = id_Role;
	}
	public String getName_Role() {
		return name_Role;
	}
	public void setName_Role(String name_Role) {
		this.name_Role = name_Role;
	}
	public Role(int id_Role, String name_Role) {
		super();
		this.id_Role = id_Role;
		this.name_Role = name_Role;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int id_Role) {
		super();
		this.id_Role = id_Role;
	}
}

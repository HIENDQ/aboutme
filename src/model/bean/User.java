package model.bean;

public class User {
	private int id;
	private String name ;
	private String usreName;
	private String pass;
	private String email;
	private Role role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsreName() {
		return usreName;
	}
	public void setUsreName(String usreName) {
		this.usreName = usreName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User(int id, String name, String usreName, String pass, String email, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.usreName = usreName;
		this.pass = pass;
		this.email = email;
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String usreName, String pass) {
		super();
		this.usreName = usreName;
		this.pass = pass;
	}
	public User(String name, String usreName, String pass, String email, Role role) {
		super();
		this.name = name;
		this.usreName = usreName;
		this.pass = pass;
		this.email = email;
		this.role = role;
	}
	public User(int id ,String name, String pass, String email, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.role = role;
	}
}

package model.bean;

public class Home {
	private int id;
	private String dep;
	private int active;
	private String picture;
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Home [id=" + id + ", dep=" + dep + ", active=" + active + ", picture=" + picture + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Home(int id, String dep, int active, String picture) {
		super();
		this.id = id;
		this.dep = dep;
		this.active = active;
		this.picture = picture;
	}
	public Home(int id, String dep, String picture) {
		super();
		this.id = id;
		this.dep = dep;
		this.picture = picture;
	}
	public Home(String picture, String dep) {
		super();
		this.picture = picture;
		this.dep = dep;
	}
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

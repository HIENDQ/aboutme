package model.bean;

public class Project {
	private int id_Project;
	private String name_Project;
	private String picture_Project;
	private String link_Project;

	public int getId_Project() {
		return id_Project;
	}
	public void setId_Project(int id_Project) {
		this.id_Project = id_Project;
	}
	public String getName_Project() {
		return name_Project;
	}
	public void setName_Project(String name_Project) {
		this.name_Project = name_Project;
	}
	public String getPicture_Project() {
		return picture_Project;
	}
	public void setPicture_Project(String picture_Project) {
		this.picture_Project = picture_Project;
	}
	public String getLink_Project() {
		return link_Project;
	}
	public void setLink_Project(String link_Project) {
		this.link_Project = link_Project;
	}

	public Project(int id_Project, String name_Project, String picture_Project, String link_Project) {
		super();
		this.id_Project = id_Project;
		this.name_Project = name_Project;
		this.picture_Project = picture_Project;
		this.link_Project = link_Project;
		
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String name_Project, String picture_Project, String link_Project) {
		super();
		this.name_Project = name_Project;
		this.picture_Project = picture_Project;
		this.link_Project = link_Project;
	}
	@Override
	public String toString() {
		return "Project [id_Project=" + id_Project + ", name_Project=" + name_Project + ", picture_Project="
				+ picture_Project + ", link_Project=" + link_Project + "]";
	}
	
}

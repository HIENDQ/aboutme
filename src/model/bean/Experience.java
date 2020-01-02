package model.bean;

public class Experience {
	private int id_ex;
	private String name_ex;
	private String time_ex;
	private String describe_ex;
	public int getId_ex() {
		return id_ex;
	}
	public void setId_ex(int id_ex) {
		this.id_ex = id_ex;
	}
	public String getName_ex() {
		return name_ex;
	}
	public void setName_ex(String name_ex) {
		this.name_ex = name_ex;
	}
	public String getTime_ex() {
		return time_ex;
	}
	public void setTime_ex(String time_ex) {
		this.time_ex = time_ex;
	}
	public String getDescribe_ex() {
		return describe_ex;
	}
	public void setDescribe_ex(String describe_ex) {
		this.describe_ex = describe_ex;
	}
	public Experience(int id_ex, String name_ex, String time_ex, String describe_ex) {
		super();
		this.id_ex = id_ex;
		this.name_ex = name_ex;
		this.time_ex = time_ex;
		this.describe_ex = describe_ex;
	}
	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Experience(String name_ex, String time_ex, String describe_ex) {
		super();
		this.name_ex = name_ex;
		this.time_ex = time_ex;
		this.describe_ex = describe_ex;
	}
	

}

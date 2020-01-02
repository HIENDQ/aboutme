package model.bean;

public class Info {
	private int id_Info;
	private int active;
	private String fullname;
	private String preview;
	private String picture;
	private String email;
	private String phone;
	private String address;
	private String ct;
	private String img;
	
	
	
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Info(String ct, String img) {
		super();
		this.ct = ct;
		this.img = img;
	}
	public Info(int id_Info, int active, String fullname, String preview, String picture, String email, String phone,
			String address, String ct, String img) {
		super();
		this.id_Info = id_Info;
		this.active = active;
		this.fullname = fullname;
		this.preview = preview;
		this.picture = picture;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.ct = ct;
		this.img = img;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId_Info() {
		return id_Info;
	}
	public void setId_Info(int id_Info) {
		this.id_Info = id_Info;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getFullname() {
		return fullname;
	}
	public Info(String email, String phone, String address) {
		super();
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	

	public Info(  String fullname, String preview, String picture ,String email, String phone, String address) {
		super();
		this.fullname = fullname;
		this.preview = preview;
		this.picture = picture;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Info [id_Info=" + id_Info + ", active=" + active + ", fullname=" + fullname + ", preview=" + preview
				+ ", picture=" + picture + ", email=" + email + ", phone=" + phone + ", address=" + address + ", ct="
				+ ct + ", img=" + img + "]";
	}
	
	
	
}

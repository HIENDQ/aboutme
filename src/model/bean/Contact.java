package model.bean;

public class Contact {
	private int idContact;
	private String fullName;
	private String email;
	private String address;
	private String phone;
	private String content;
	public int getIdContact() {
		return idContact;
	}
	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Contact(int idContact, String fullName, String email, String address, String phone, String content) {
		super();
		this.idContact = idContact;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.content = content;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String fullName, String email, String address, String phone, String content) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.content = content;
	}
	@Override
	public String toString() {
		return "Contact [idContact=" + idContact + ", fullName=" + fullName + ", email=" + email + ", address="
				+ address + ", phone=" + phone + ", content=" + content + "]";
	}
	
}

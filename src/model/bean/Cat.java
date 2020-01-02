package model.bean;

public class Cat {
	private int id_Cat;
	private String name_Cat;
	private int stt;
	
	public Cat(int id_Cat, String name_Cat, int stt) {
		super();
		this.id_Cat = id_Cat;
		this.name_Cat = name_Cat;
		this.stt = stt;
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public int getId_Cat() {
		return id_Cat;
	}
	public void setId_Cat(int id_Cat) {
		this.id_Cat = id_Cat;
	}
	public String getName_Cat() {
		return name_Cat;
	}
	public void setName_Cat(String name_Cat) {
		this.name_Cat = name_Cat;
	}
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cat(int id_Cat, String name_Cat) {
		super();
		this.id_Cat = id_Cat;
		this.name_Cat = name_Cat;
	}
	
	public Cat(int id_Cat) {
		super();
		this.id_Cat = id_Cat;
	}
	public Cat(String name_Cat) {
		super();
		this.name_Cat = name_Cat;
	}
}

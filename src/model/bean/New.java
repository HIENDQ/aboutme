package model.bean;

public class New {
	private int id_New;
	private String name_New;
	private String preview_New;
	private String detail_New;
	private Cat cat_New;
	private String picture_New;
	private int count_New;
	private int active_New;
	
	public New(int id_New, String name_New) {
		super();
		this.id_New = id_New;
		this.name_New = name_New;
	}
	public int getId_New() {
		return id_New;
	}
	public void setId_New(int id_New) {
		this.id_New = id_New;
	}
	public String getName_New() {
		return name_New;
	}
	public void setName_New(String name_New) {
		this.name_New = name_New;
	}
	public String getPreview_New() {
		return preview_New;
	}
	public void setPreview_New(String preview_New) {
		this.preview_New = preview_New;
	}
	public String getDetail_New() {
		return detail_New;
	}
	public void setDetail_New(String detail_New) {
		this.detail_New = detail_New;
	}
	public Cat getCat_New() {
		return cat_New;
	}
	public void setCat_New(Cat cat_New) {
		this.cat_New = cat_New;
	}
	public String getPicture_New() {
		return picture_New;
	}
	public void setPicture_New(String picture_New) {
		this.picture_New = picture_New;
	}
	public int getCount_New() {
		return count_New;
	}
	public void setCount_New(int count_New) {
		this.count_New = count_New;
	}
	public int getActive_New() {
		return active_New;
	}
	public void setActive_New(int active_New) {
		this.active_New = active_New;
	}
	public New(int id_New, String name_New, String preview_New, String detail_New, Cat cat_New, String picture_New,
			int count_New, int active_New) {
		super();
		this.id_New = id_New;
		this.name_New = name_New;
		this.preview_New = preview_New;
		this.detail_New = detail_New;
		this.cat_New = cat_New;
		this.picture_New = picture_New;
		this.count_New = count_New;
		this.active_New = active_New;
	}
	public New(int id_New, String name_New, String preview_New, String detail_New, Cat cat_New, String picture_New ) {
		super();
		this.id_New = id_New;
		this.name_New = name_New;
		this.preview_New = preview_New;
		this.detail_New = detail_New;
		this.cat_New = cat_New;
		this.picture_New = picture_New;
	}
	public New( String name_New, String preview_New, String detail_New, Cat cat_New, String picture_New ) {
		super();
		this.name_New = name_New;
		this.preview_New = preview_New;
		this.detail_New = detail_New;
		this.cat_New = cat_New;
		this.picture_New = picture_New;
	}
	public New(int id_New ) {
		super();
		this.id_New = id_New;
	}
	public New() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "New [id_New=" + id_New + ", name_New=" + name_New + ", preview_New=" + preview_New + ", detail_New="
				+ detail_New + ", cat_New=" + cat_New.getId_Cat() + ", picture_New=" + picture_New + ", count_New=" + count_New
				+ ", active_New=" + active_New + "]";
	}
	

}

package model.bean;

import java.sql.Date;
import java.sql.Time;

public class Comment {
	private int id_Comment;
	private New objNew;
	private String author;
	private String content;
	private Date date;
	private Time time;
	
	
	
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	public Comment(int id_Comment, New objNew, String author, String content, Date date, Time time) {
		super();
		this.id_Comment = id_Comment;
		this.objNew = objNew;
		this.author = author;
		this.content = content;
		this.date = date;
		this.time = time;
	}
	public int getId_Comment() {
		return id_Comment;
	}
	public void setId_Comment(int id_Comment) {
		this.id_Comment = id_Comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public New getObjNew() {
		return objNew;
	}
	public void setObjNew(New objNew) {
		this.objNew = objNew;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Comment( New objNew, String author, String content) {
		super();
		this.objNew = objNew;
		this.author = author;
		this.content = content;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}

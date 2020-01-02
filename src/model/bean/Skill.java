package model.bean;

public class Skill {
	private int id_skill;
	private int valus;
	private String name_Skill;
	public int getId_skill() {
		return id_skill;
	}
	public void setId_skill(int id_skill) {
		this.id_skill = id_skill;
	}
	public int getValus() {
		return valus;
	}
	public void setValus(int valus) {
		this.valus = valus;
	}
	public String getName_Skill() {
		return name_Skill;
	}
	public void setName_Skill(String name_Skill) {
		this.name_Skill = name_Skill;
	}
	@Override
	public String toString() {
		return "Skill [id_skill=" + id_skill + ", valus=" + valus + ", name_Skill=" + name_Skill + "]";
	}
	public Skill(int id_skill, int valus, String name_Skill) {
		super();
		this.id_skill = id_skill;
		this.valus = valus;
		this.name_Skill = name_Skill;
	}
	public Skill( String name_Skill, int valus) {
		super();
		this.valus = valus;
		this.name_Skill = name_Skill;
	}
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

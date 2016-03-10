package it.lab.sondaggio.model;

import java.util.ArrayList;

public class Survey {
	private String name;
	private Integer idUsr;
	private String category;
	private ArrayList<Question> quesAns = new ArrayList<Question>();
	
	
	
	public Integer getIdUsr() {
		return idUsr;
	}

	public void setIdUsr(Integer idUsr) {
		this.idUsr = idUsr;
	}

	public void addQuestion(Question q){
		quesAns.add(q);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Question> getQuesAns() {
		return quesAns;
	}

	public void setQuesAns(ArrayList<Question> quesAns) {
		this.quesAns = quesAns;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	
	
}

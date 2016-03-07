package it.lab.sondaggio.model;

public class Question {
	private String question;
	private String rispA;
	private String rispB;
	private String rispC;
	private String rispD;
	
	public String getRispA() {
		return rispA;
	}

	public void setRispA(String rispA) {
		this.rispA = rispA;
	}

	public String getRispB() {
		return rispB;
	}

	public void setRispB(String rispB) {
		this.rispB = rispB;
	}

	public String getRispC() {
		return rispC;
	}

	public void setRispC(String rispC) {
		this.rispC = rispC;
	}

	public String getRispD() {
		return rispD;
	}

	public void setRispD(String rispD) {
		this.rispD = rispD;
	}

	public Question(String question,String rispA, String rispB){
		this.question = question;
		this.rispA = "sì";
		this.rispB = "no";
	}
	
	public Question(String question,String A, String B, String C, String D){
		this.question = question;
		rispA = A; rispB = B;
		rispC = C; rispD = D;
	}
	
	public Question(){
	}
	
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
}

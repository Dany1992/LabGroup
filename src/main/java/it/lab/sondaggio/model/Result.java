package it.lab.sondaggio.model;

public class Result {
	private String question;
	private int rispA;
	private int rispB;
	private int rispC;
	private int rispD;
	
	public Result(String question, int rispA, int rispB, int rispC, int rispD) {
		setQuestion(question);
		setRispA(rispA);
		setRispB(rispB);
		setRispC(rispC);
		setRispD(rispD);
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getRispA() {
		return rispA;
	}
	public void setRispA(int rispA) {
		this.rispA = rispA;
	}
	public int getRispB() {
		return rispB;
	}
	public void setRispB(int rispB) {
		this.rispB = rispB;
	}
	public int getRispC() {
		return rispC;
	}
	public void setRispC(int rispC) {
		this.rispC = rispC;
	}
	public int getRispD() {
		return rispD;
	}
	public void setRispD(int rispD) {
		this.rispD = rispD;
	}
	
	
	
}

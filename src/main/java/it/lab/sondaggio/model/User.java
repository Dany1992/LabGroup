package it.lab.sondaggio.model;

import java.util.ArrayList;

public class User {
	private int idUser;
	private String name;
	private String surname;
	private String email;
	private String password;
	private ArrayList<String> categorie;
	
	
	public ArrayList<String> getCategorie() {
		return categorie;
	}

	public void setCategorie(ArrayList<String> categorie) {
		this.categorie = categorie;
	}

	public int getIdUser() {
		return idUser;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

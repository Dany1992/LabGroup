package it.lab.sondaggio.model;

import java.util.ArrayList;

/**
 * Questa classe contine semplicemente i dati che l'utente inserisce in fase di
 * registrazione e tutti i get e set
 * @author Danilo Butrico
 * @version 22-02-2016
 *
 */

public class User {
	private int idUser;
	private String name;
	private String surname;
	private String email;
	private String password;
	private ArrayList<String> userCategory;
	
	
	public ArrayList<String> getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(ArrayList<String> categorie) {
		this.userCategory = categorie;
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

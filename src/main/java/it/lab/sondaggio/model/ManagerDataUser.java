package it.lab.sondaggio.model;

import it.lab.sondaggio.view.User;
import utility.DataBase;

public class ManagerDataUser extends DataBase {
	private String query;	
	
	public int saveUser(User usr){
		query = "INSERT INTO User(name,surname,email,password) VALUES ('" +
				usr.getName() + "', " +
				usr.getSurname() + ", " +
				usr.getEmail() + ", " +
				usr.getPassword() +");";
		return insertToDB(query);
	}
	
	public String getEmail(User usr){
		query = "SELECT email FROM User WHERE idUser = " + usr.getIdUser();
		/*
		 * Il metodo queryToDB restituisce l'array degli elementi estratti dalla query
		 * in questo caso la query restituisce un solo valore e quindi lo si prende
		 * con get(0) in prima posizione
		 */
		return queryToDB(query).get(0);
	}
	
	public boolean _editPassword(String password){
		return true;
	}

}

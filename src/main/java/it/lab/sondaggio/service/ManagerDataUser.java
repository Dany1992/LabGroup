package it.lab.sondaggio.service;


import java.util.ArrayList;
import java.util.Iterator;

import it.lab.sondaggio.model.User;
import utility.DataBase;


/**
 * Questa classe permette di eseguire tutte le operazioni di scrittura e lettura dal database
 * riguardante user
 * @author Danilo Butrico
 * @version 26-02-2016
 *
 */
public class ManagerDataUser extends DataBase {
	private String query;
	private static boolean SUCCESS = true;
	private static boolean ERROR = false;
	ArrayList<String> resQuery;
	
	/**
	 * Questa metodo permette di salvare i dati di un user nel db
	 * per fare ciò prima crea una query in mysql e poi sfruttando la classe
	 * Database utilizza il metodo insertToDB che provvede a scrivere nel DB
	 * fatto cio chiama un metodo per salvare le categorie che l'utente ha selezionato
	 * @param usr User
	 * @return int
	 */
	public int saveUser(User usr){
		query = "INSERT INTO user(name,surname,email,password,type) VALUES ('" +
				usr.getName() + "', '" +
				usr.getSurname() + "', '" +
				usr.getEmail() + "', '" +
				usr.getPassword() +"',2);";
		int resultSaveUser=insertToDB(query);
		query = "SELECT idUser FROM user WHERE email = " + "'"+usr.getEmail()+"'";
		String idUser = queryToDB(query).get(0);
		int resultSaveCategory = saveCategoryUser(idUser, usr.getUserCategory());
		/*if serve per controllare che sia il salvataggio dei dati user
		 * che il salvataggio dalle categorie, dato dal metodo saveCategoryUser, siano
		 * andati a buon fine
		*/
		if (resultSaveCategory == 1 && resultSaveUser == 1){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * Il seguente metodo consente di memorizzare nel db tutte le categorie che ha selezionato 
	 * l'utente in fase di registrazione
	 * @param idUser String
	 * @param category ArrayList<String>
	 * @return int 
	 */
	
	public int saveCategoryUser(String idUser,ArrayList<String> category){
		String query;
		System.out.println(category.get(0));
		for (Iterator<String> iterator = category.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
			query = "INSERT INTO chooseCategory(idUser,nameCategory) VALUES ('" +
					idUser + "', '" +
					string +"');";
			if(insertToDB(query) == 0){
				return 0;
			}
		}
		return 1;
	}

	/*
	 * sfrutta i metodi get per recuperare tutte le informazioni che riguardano
	 * un utente.
	 */
	public User getUserToDb(User usr){
		usr.setIdUser(Integer.parseInt(getIdUser(usr)));
		usr.setName(getName(usr));
		usr.setSurname(getSurname(usr));
		usr.setEmail(getEmail(usr));
		usr.setPassword(getPassword(usr));
		usr.setType(Integer.parseInt(getType(usr)));
		return usr;
	}
	
	public Boolean checkUser(User usr){
		
	query = "SELECT idUser FROM user WHERE email='" + usr.getEmail() + "'" +
				" and password='" + usr.getPassword() + "';";
		
		resQuery = queryToDB(query);
		if(resQuery.size() == 0){
			
			return ERROR;
			
		}
		
		return SUCCESS;
	
	}
	
	public String getEmail(User usr){
		query = "SELECT email FROM user WHERE email='" + usr.getEmail() + "'" +
				" and password='" + usr.getPassword() + "';";
		/*
		 * Il metodo queryToDB restituisce l'array degli elementi estratti dalla query
		 * in questo caso la query restituisce un solo valore e quindi lo si prende
		 * con get(0) in prima posizione
		 */
		return queryToDB(query).get(0);
	}
	
	public String getIdUser(User usr){
		query = "SELECT idUser FROM user WHERE email='" + usr.getEmail() + "'" +
				" and password='" + usr.getPassword() + "';";
		/*
		 * Il metodo queryToDB restituisce l'array degli elementi estratti dalla query
		 * in questo caso la query restituisce un solo valore e quindi lo si prende
		 * con get(0) in prima posizione
		 */
		return queryToDB(query).get(0);
	}
	
	public String getName(User usr){
		query = "SELECT name FROM user WHERE email='" + usr.getEmail() + "'" +
				" and password='" + usr.getPassword() + "';";
		/*
		 * Il metodo queryToDB restituisce l'array degli elementi estratti dalla query
		 * in questo caso la query restituisce un solo valore e quindi lo si prende
		 * con get(0) in prima posizione
		 */
		return queryToDB(query).get(0);
	}
	
	public String getSurname(User usr){
		query = "SELECT surname FROM user WHERE email='" + usr.getEmail() + "'" +
				" and password='" + usr.getPassword() + "';";
		/*
		 * Il metodo queryToDB restituisce l'array degli elementi estratti dalla query
		 * in questo caso la query restituisce un solo valore e quindi lo si prende
		 * con get(0) in prima posizione
		 */
		return queryToDB(query).get(0);
	}
	
	public String getType(User usr){
		query = "SELECT type FROM user WHERE email='" + usr.getEmail() + "'" +
				" and password='" + usr.getPassword() + "';";
		/*
		 * Il metodo queryToDB restituisce l'array degli elementi estratti dalla query
		 * in questo caso la query restituisce un solo valore e quindi lo si prende
		 * con get(0) in prima posizione
		 */
		return queryToDB(query).get(0);
	}
	
	public String getPassword(User usr){
		query = "SELECT password FROM user WHERE email='" + usr.getEmail() + "'" +
				" and password='" + usr.getPassword() + "';";
		/*
		 * Il metodo queryToDB restituisce l'array degli elementi estratti dalla query
		 * in questo caso la query restituisce un solo valore e quindi lo si prende
		 * con get(0) in prima posizione
		 */
		return queryToDB(query).get(0);
	}
}

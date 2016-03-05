package it.lab.sondaggio.service;


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
	
	/**
	 * Questa metodo permette di salvare i dati di un user nel db
	 * per fare ciò prima crea una query in mysql e poi sfruttando la classe
	 * Database utilizza il metodo insertToDB che provvede a scrivere nel DB
	 * la query e restiuisce:
	 * 		0 se qualcosa è andata male e non ha salvato i dati nel db
	 * 		1 tutto è andato a buon fine e ha salvato i dati nel db
	 * @param usr User
	 * @return int
	 */
	public int saveUser(User usr){
		query = "INSERT INTO User(name,surname,email,password,type) VALUES ('" +
				usr.getName() + "', '" +
				usr.getSurname() + "', '" +
				usr.getEmail() + "', '" +
				usr.getPassword() +"',2);";
		System.out.println(query);
		return insertToDB(query);
	}

}

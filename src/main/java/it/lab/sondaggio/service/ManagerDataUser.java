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
public class ManagerDataUser extends DataBase{
	private String query;
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

	public User checkUser(User usr){
		query ="SELECT idUser, name, surname, email, password, type FROM user WHERE email='" + usr.getEmail() + "'" +
				" and password='" + usr.getPassword() + "';";;
		
		resQuery = queryToDB(query);
		if(resQuery.size() == 0){
			
			return null;
			
		}

		usr.setIdUser(Integer.parseInt(resQuery.get(0)));
		usr.setName(resQuery.get(1));
		usr.setSurname(resQuery.get(2));
		usr.setEmail(resQuery.get(3));
		usr.setPassword(resQuery.get(4));
		usr.setType(Integer.parseInt(resQuery.get(5)));

		return usr;
	
	}
}

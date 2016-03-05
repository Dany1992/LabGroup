package it.lab.sondaggio.service;


import java.util.ArrayList;


/**
 * Questa classe permette di eseguire tutte le operazioni riguardanti la category
 * @author Danilo Butrico
 * @version 4-03-2016
 */
import utility.DataBase;

public class ManagerDataCategory extends DataBase {
	String query;
	ArrayList<String> category;
	
	/**
	 * Questo metodo consente di ottenere tutte le category che sono presenti nel db
	 * e le restituisce sottoforma di un Array list di Stringhe
	 * 
	 * @return category ArrayList
	 */
	public ArrayList<String> selectAllCategory(){
		query = "SELECT nameCategory FROM category";
		category = queryToDB(query);
		System.out.println(category);
		return category;
	}
	
	

}

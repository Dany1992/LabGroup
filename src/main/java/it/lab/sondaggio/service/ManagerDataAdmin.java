package it.lab.sondaggio.service;

import it.lab.sondaggio.model.*;
import utility.DataBase;


/**
 * Questa classe permette di eseguire tutte le operazioni di scrittura e lettura dal database
 * riguardante l'admin
 * @author Pierfrancesco Tommasino 
 * @author Dario Onorati
 * @version 07-03-2016
 *
 */

public class ManagerDataAdmin extends DataBase{
	private String query1;
	private String query2;
	
	
	/**
	 * Questa metodo permette di aggiungere un nuovo sondaggio nel db da parte dell'amministratore
	 * per fare ciò creo due query in mysql dove nella prima inserisco il nome del sondaggio e
	 *  il nome della categoria  e nella seconda inserisco i campi delle domande(nome sondaggio,
	 *  nome domanda , risposta1,risposta2,risposta3,risposta4) ; sfruttando la classe
	 * Database utilizzo il metodo insertToDB che provvede a scrivere nel DB i dati acquisiti;
	 * 
	 * @param s Survey
	 * @return int
	 */
	
	public int addSurvey(Survey s){
		int res1=0;//attributo di tipo intero dove memorizzo il risultato intero della risposta della query
		int res2=0;
		s.getQuesAns();
		query1 = "INSERT INTO survey values('"+s.getName()+"','"+s.getCategory()+"');";
		res1=insertToDB(query1);
		if(res1!=1) return 0; //Se la variabile res1 ha valore diverso da 1 la query non è stata eseguita correttamente ritornado un messaggio di errore 
		
		System.out.println(query1);
		
		// Ciclo for: Scorro la lista dove sono memorizzate le 5 domande inserite dall'amministartore inserendo uno alla volta nel db tramite query 
		for(int j=0 ; j<s.getQuesAns().size();j++){
			query2 = "INSERT INTO question(nameSurvey,question,answer1,answer2,answer3,answer4)values('"+
						s.getName()+"','"+
						s.getQuesAns().get(j).getQuestion()+"','"+
						s.getQuesAns().get(j).getRispA()+"','"+
						s.getQuesAns().get(j).getRispB()+"','"+
						s.getQuesAns().get(j).getRispC()+"','"+
						s.getQuesAns().get(j).getRispD()+"');";
			res2=insertToDB(query2);
			System.out.println(query2);
			if (res2!=1) return 0;
			
		}
		
		return 1;
		
	}
	
}

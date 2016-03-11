package it.lab.sondaggio.service;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import it.lab.sondaggio.model.Result;
//import it.lab.sondaggio.model.Survey;
import utility.DataBase;


public class ManagerDataSurvey extends DataBase{
	/*Attributi per il metodo showResult()*/
	private String query1;
	private String query2;
	private String query3;
	private String query4;
	private String query5;
	private ArrayList<String> question;
	private ArrayList<String> answer1;
	private ArrayList<String> answer2;
	private ArrayList<String> answer3;
	private ArrayList<String> answer4;
	/*Attributi per il metodo selectAllSurvey()*/
	private ArrayList<String> result =new ArrayList<String>();
	private ArrayList<Result> allResult =new ArrayList<Result>();
	
	private String query6;
	private ArrayList<String> survey;
	
	/**
	 * Questo metodo consente di ottenere quanti utenti hanno votato per ogni risposta di ogni domanda di un determinato sondaggio
	 * 
	 * @return result ArrayList
	 */
	
	public ArrayList<Result> showResult(String survey){  //oggetto di tipo survey o di tipo stringa
		
		
		query1="SELECT question.question FROM question WHERE nameSurvey='"+survey+"' order by question.idQuestion";
		System.out.println(query1);
		question = queryToDB(query1);
		
		query2="SELECT a1.answer1 FROM ( SELECT question.idQuestion, count(userResponse.answer)as answer1 FROM question, userResponse WHERE question.nameSurvey='"+survey+"' and userResponse.idQuestion=question.idQuestion and userResponse.answer=question.answer1 group by question.idQuestion UNION ( SELECT question.idQuestion, 0 FROM question WHERE nameSurvey='"+survey+"' ) ) as a1 group by a1.idQuestion";
		answer1=queryToDB(query2);
		
		query3="SELECT a1.answer2 FROM ( SELECT question.idQuestion, count(userResponse.answer)as answer2 FROM question, userResponse WHERE question.nameSurvey='"+survey+"' and userResponse.idQuestion=question.idQuestion and userResponse.answer=question.answer2 group by question.idQuestion UNION ( SELECT question.idQuestion, 0 FROM question WHERE nameSurvey='"+survey+"' ) ) as a1 group by a1.idQuestion";
		answer2=queryToDB(query3);
		
		query4="SELECT a1.answer3 FROM ( SELECT question.idQuestion, count(userResponse.answer)as answer3 FROM question, userResponse WHERE question.nameSurvey='"+survey+"' and userResponse.idQuestion=question.idQuestion and userResponse.answer=question.answer3 group by question.idQuestion UNION ( SELECT question.idQuestion, 0 FROM question WHERE nameSurvey='"+survey+"' ) ) as a1 group by a1.idQuestion";
		answer3=queryToDB(query4);
		
		query5="SELECT a1.answer4 FROM ( SELECT question.idQuestion, count(userResponse.answer)as answer4 FROM question, userResponse WHERE question.nameSurvey='"+survey+"' and userResponse.idQuestion=question.idQuestion and userResponse.answer=question.answer4 group by question.idQuestion UNION ( SELECT question.idQuestion, 0 FROM question WHERE nameSurvey='"+survey+"' ) ) as a1 group by a1.idQuestion";
		answer4=queryToDB(query5);
		
		for (int i=0;i<question.size();i++) {
			result.add(question.get(i));
			result.add(answer1.get(i));
			result.add(answer2.get(i));
			result.add(answer3.get(i));
			result.add(answer4.get(i));
		}
		
		for (int j = 0; j < result.size(); j=j+5) {
			allResult.add(new Result(result.get(j), Integer.parseInt(result.get(j+1)), Integer.parseInt(result.get(j+2)), Integer.parseInt(result.get(j+3)), Integer.parseInt(result.get(j+4))));
			
		}
		
		return allResult;
		
		}
	
	
	/**
	 * Questo metodo consente di ottenere tutti i survey che sono presenti nel db
	 * e le restituisce sottoforma di un Array list di Stringhe
	 * 
	 * @return survey ArrayList
	 */
	

	public ArrayList<String> selectAllSurvey(){
	    Map<String,Object> session=ActionContext.getContext().getSession();
		query6 = "SELECT nameSurvey FROM survey where idUser="+(Integer)session.get("id")+" ;";
		survey = queryToDB(query6);
		return survey;
	
	}
	
	
	
	
	
	
	
	
	
	
	
}

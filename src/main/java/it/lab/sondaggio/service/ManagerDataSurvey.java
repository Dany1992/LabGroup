package it.lab.sondaggio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.print.DocFlavor.STRING;

import com.opensymphony.xwork2.ActionContext;

import it.lab.sondaggio.model.Question;
import it.lab.sondaggio.model.Result;
//import it.lab.sondaggio.model.Survey;
import utility.DataBase;

/**
 * 
 * @author Danilo Butrico, Pierfrancesco Tommasino, Dario Onorati
 *
 */
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
	Map session = ActionContext.getContext().getSession();
	
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
	
	/**
	 * Questa classe permette di selezionare tutti i sondaggi che un user non ha fatto
	 * e riferenti alle categorie che lui in fase di registrazione ha selezionato
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getSurveysUser(int idUser) {
		String query = "SELECT b.nameSurvey FROM ( ( SELECT question.nameSurvey "
				+ "FROM question, userResponse WHERE userResponse.idQuestion = question.idQuestion "
				+ "AND idUser = "+idUser+" ) as a RIGHT JOIN ( SELECT nameSurvey FROM survey) as b on a.nameSurvey = b.nameSurvey ) "
				+ "WHERE a.nameSurvey is null;";
		return queryToDB(query);
	}
	
	public ArrayList<Question> getQuestionsSurvey(String nameSurvey){
		ArrayList<String> resultQuery = new ArrayList<String>();
		ArrayList<Question> querySurvey = new ArrayList<Question>();
		String query = "SELECT question, answer1, answer2, answer3, answer4 "
				+ "FROM question WHERE nameSurvey = " +"'"+ nameSurvey +"'"+ ";";
		resultQuery = queryToDB(query);
		for (int i = 0; i < 25; i=i+5) {
				Question question = new Question();
				question.setQuestion(resultQuery.get(i));
				question.setRispA(resultQuery.get(i+1));
				question.setRispB(resultQuery.get(i+2));
				question.setRispC(resultQuery.get(i+3));
				question.setRispD(resultQuery.get(i+4));
				querySurvey.add(question);
		}
		return querySurvey;
	}	
	
	public String saveAnswer(HashMap<String, String> answerSurvey){
		return "success";
	}
}

package it.lab.sondaggio.service;

import it.lab.sondaggio.model.*;
import utility.DataBase;

public class ManagerDataAdmin extends DataBase{
	private String query1;
	private String query2;
	
	public int addSurvey(Survey s){
		int res1=0;
		int res2=0;
		s.getQuesAns();
		query1 = "INSERT INTO survey values('"+s.getName()+"','"+s.getCategory()+"');";
		res1=insertToDB(query1);
		if(res1!=1) return 0;
		
		System.out.println(query1);
		
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

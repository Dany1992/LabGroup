package it.lab.sondaggio.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import it.lab.sondaggio.model.Result;
import it.lab.sondaggio.service.ManagerDataSurvey;
import it.lab.sondaggio.utils.Parameter;

public class ShowResultAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	 ArrayList<Result> allResult = new ArrayList<Result>();
	 String nameSurvey ;
	 
	
	

	 
	public String getNameSurvey() {
		return nameSurvey;
	}




	public void setNameSurvey(String nameSurvey) {
		this.nameSurvey = nameSurvey;
	}




	public ArrayList<Result> getAllResult() {
		return allResult;
	}




	public void setAllResult(ArrayList<Result> allResult) {
		this.allResult = allResult;
	}




	public String execute() throws Exception {
		ManagerDataSurvey mda = new ManagerDataSurvey();
		mda.setPath(Parameter.JDBC_SONDAGGIO);
		allResult=mda.showResult(nameSurvey);
		return SUCCESS;
	}

}

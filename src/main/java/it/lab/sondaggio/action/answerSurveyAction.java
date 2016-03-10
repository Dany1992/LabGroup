package it.lab.sondaggio.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import it.lab.sondaggio.model.Question;
import it.lab.sondaggio.service.ManagerDataSurvey;
import it.lab.sondaggio.utils.Parameter;

public class answerSurveyAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	ArrayList<String> surveysUser = new ArrayList<String>();
	Map session = ActionContext.getContext().getSession();
	String attribute = new String();
	ArrayList<Question> questionSurvey = new ArrayList<Question>();
	int changePage = 1;
	String answer,answer1,answer2,answer3,answer4;
	HashMap<String, String> answerSurvey = new HashMap<String, String>();
	
	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public String getAnswer1() {
		return answer1;
	}


	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}


	public String getAnswer2() {
		return answer2;
	}


	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}


	public String getAnswer3() {
		return answer3;
	}


	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}


	public String getAnswer4() {
		return answer4;
	}


	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}


	public int getChangePage() {
		return changePage;
	}


	public void setChangePage(int changePage) {
		this.changePage = changePage;
	}


	public ArrayList<Question> getQuestionSurvey() {
		return questionSurvey;
	}


	public void setQuestionSurvey(ArrayList<Question> questionSurvey) {
		this.questionSurvey = questionSurvey;
	}


	public String getAttribute() {
		return attribute;
	}


	public void setAttribute(String atrribute) {
		this.attribute = atrribute;
	}



	public ArrayList<String> getSurveysUser() {
		return surveysUser;
	}

	

	public void setSurveysUser(ArrayList<String> surveysUser) {
		this.surveysUser = surveysUser;
	}

	public String execute() throws Exception {
		ManagerDataSurvey mds = new ManagerDataSurvey();
		int idUser = (Integer) session.get("id");
		mds.setPath(Parameter.JDBC_SONDAGGIO);
		surveysUser = mds.getSurveysUser(idUser);
		return SUCCESS;
	}
	
	public String execute2() throws Exception {
		ManagerDataSurvey mds = new ManagerDataSurvey();
		mds.setPath(Parameter.JDBC_SONDAGGIO);
		questionSurvey = mds.getQuestionsSurvey(attribute);
		return SUCCESS;
	}
	
	public String execute3() {
		ManagerDataSurvey mds = new ManagerDataSurvey();
		mds.setPath(Parameter.JDBC_SONDAGGIO);
		return SUCCESS;
	}
	
	
}

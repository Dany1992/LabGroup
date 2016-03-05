package it.lab.sondaggio.action;

import java.util.ArrayList;

//import java.util.ArrayList;
//import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.lab.sondaggio.service.ManagerDataAdmin;
import it.lab.sondaggio.service.ManagerDataCategory;
import it.lab.sondaggio.utils.Parameter;
import it.lab.sondaggio.model.Question;
import it.lab.sondaggio.model.Survey;




public class NewSurveyAction extends ActionSupport {
	
	ArrayList<String> allCategory = new ArrayList<String>();
	ArrayList<String> userCategory = new ArrayList<String>();
	
	public ArrayList<String> getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(ArrayList<String> userCategory) {
		this.userCategory = userCategory;
	}

	public ArrayList<String> getAllCategory() {
		return allCategory;
	}

	public void setAllCategory(ArrayList<String> allCategory) {
		this.allCategory = allCategory;
	}
	
	private static final long serialVersionUID = 1L;
	
	private ManagerDataAdmin mda = new ManagerDataAdmin();

	
	private Survey s = new Survey();
	
	private Question q0= new Question();
	private Question q1= new Question();
	private Question q2= new Question();
	private Question q3= new Question();
	private Question q4= new Question();
	
	public Question getQ0() {
		return q0;
	}

	public void setQ0(Question q0) {
		this.q0 = q0;
	}

	public Question getQ1() {
		return q1;
	}

	public void setQ1(Question q1) {
		this.q1 = q1;
	}

	public Question getQ2() {
		return q2;
	}

	public void setQ2(Question q2) {
		this.q2 = q2;
	}

	public Question getQ3() {
		return q3;
	}

	public void setQ3(Question q3) {
		this.q3 = q3;
	}

	public Question getQ4() {
		return q4;
	}

	public void setQ4(Question q4) {
		this.q4 = q4;
	}

	public String execute() throws Exception {
		
		s.addQuestion(q0);
		s.addQuestion(q1);
		s.addQuestion(q2);
		s.addQuestion(q3);
		s.addQuestion(q4);
		//s.setCategory(allCategory);//allCategory è una lista invece survey come categoria ha una stringa
		
		this.mda.setPath(Parameter.JDBC_SONDAGGIO);
		
		int result = this.mda.addSurvey(s);
		
		if (result == 1){
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
public String execute2() throws Exception {
		
	ManagerDataCategory mdc = new ManagerDataCategory();
	mdc.setPath(Parameter.JDBC_SONDAGGIO);
	allCategory=mdc.selectAllCategory();
	return SUCCESS;
}


	

	public Survey getS() {
		return s;
	}

	public void setS(Survey s) {
		this.s = s;
	}




	
	
	
	
}

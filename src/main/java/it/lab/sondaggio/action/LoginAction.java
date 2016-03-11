package it.lab.sondaggio.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import it.lab.sondaggio.model.User;
import it.lab.sondaggio.service.ManagerDataSurvey;
import it.lab.sondaggio.service.ManagerDataUser;
import it.lab.sondaggio.utils.Parameter;

public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;	
	private SessionMap<String, Object> session;
	private User usr = new User();
	private User userTmp;
	//allSurvey contiene tutti i sondaggi svolti dal determinato amministratore
	ArrayList<String> allSurvey = new ArrayList<String>();
	
	
	
	public ArrayList<String> getAllSurvey() {
		return allSurvey;
	}

	public void setAllSurvey(ArrayList<String> allSurvey) {
		this.allSurvey = allSurvey;
	}

	@Override
	public String execute() throws Exception {
		
		/*
		 * Occorre creare un singelton per il MandagerDataUser
		 * in quanto non si puo creare un ogetto MandagerDataUser ogni volta che si
		 * vuole scrivere o leggere da DB
		 */
		// La classe ManagerDataUser si occupa della scrittura sul database
		ManagerDataUser mdu = new ManagerDataUser();
		
		// Imposto il percorso del database
		mdu.setPath(Parameter.JDBC_SONDAGGIO);
		
		userTmp = mdu.checkUser(usr);
		if(userTmp == null){
			return ERROR;
		}
		
		session.put("id", userTmp.getIdUser());
		session.put("name", userTmp.getName());
		session.put("surname", userTmp.getSurname());
		session.put("email", userTmp.getEmail());
		session.put("type",userTmp.getType());
		
		//return SUCCESS;
		if (session.get("type").equals(2)) {
			return "user";
		}
		
		if (session.get("type").equals(1)) {
			ManagerDataSurvey mda = new ManagerDataSurvey();
			mda.setPath(Parameter.JDBC_SONDAGGIO);
			allSurvey=mda.selectAllSurvey();
			if (allSurvey ==null) {
				return ERROR;
			}
			else {
				return "admin";
			}
			
		}
		
		ManagerDataSurvey mda = new ManagerDataSurvey();
		mda.setPath(Parameter.JDBC_SONDAGGIO);
		allSurvey=mda.selectAllSurvey();
		if (allSurvey == null) {
			return ERROR;
		}
		return "superadmin";
	}

	public User getUsr(){
		return usr;
	}
	
	public void setUsr(User usr){
		this.usr=usr;
	}


	public void setSession(Map<String, Object> session) {
		this.session=(SessionMap<String, Object>)session;
	}
	
}

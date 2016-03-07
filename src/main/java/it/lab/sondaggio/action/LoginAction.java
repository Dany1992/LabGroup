package it.lab.sondaggio.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import it.lab.sondaggio.model.User;
import it.lab.sondaggio.service.ManagerDataUser;
import it.lab.sondaggio.utils.Parameter;

public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> session;
	
	private User usr = new User();
	
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
		
		if(mdu.checkUser(usr) == false){
			return ERROR;
		}
		
		usr = mdu.getUserToDb(usr);
		session.put("id", usr.getIdUser());
		session.put("name", usr.getName());
		session.put("surname", usr.getSurname());
		session.put("email", usr.getEmail());
		return SUCCESS;
	}

	public User getUsr(){
		return usr;
	}
	
	public void setUsr(User usr){
		this.usr=usr;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=(SessionMap<String, Object>)session;
	}
	
}

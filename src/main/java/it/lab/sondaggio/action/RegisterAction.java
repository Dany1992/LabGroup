package it.lab.sondaggio.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import it.lab.sondaggio.model.User;
import it.lab.sondaggio.service.ManagerDataCategory;
import it.lab.sondaggio.service.ManagerDataUser;
import it.lab.sondaggio.utils.Parameter;


public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	User usr = new User();
	
	public User getUsr(){
		return usr;
	}
	
	public void setUsr(User usr){
		this.usr=usr;
	}
	
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

	public String execute() throws Exception {
		ManagerDataCategory mdc = new ManagerDataCategory();
		mdc.setPath(Parameter.JDBC_SONDAGGIO);
		allCategory=mdc.selectAllCategory();
		return SUCCESS;
	}
	
	public String execute2() throws Exception{
		/*
		 * Occorre creare un singelton per il MandagerDataUser
		 * in quanto non si puo creare un ogetto MandagerDataUser ogni volta che si
		 * vuole scrivere o leggere da DB
		 */
		// La classe ManagerDataUser si occupa della scrittura sul database
		ManagerDataUser mdu = new ManagerDataUser();
		// Imposto il percorso del database
		mdu.setPath(Parameter.JDBC_SONDAGGIO);
		int result = mdu.saveUser(usr);
		if (result == 1){
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
}

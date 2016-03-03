package it.lab.sondaggio.action;

import com.opensymphony.xwork2.ActionSupport;

import it.lab.sondaggio.model.ManagerDataUser;
import it.lab.sondaggio.view.User;


public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	User usr = new User();
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
		mdu.setPath("jdbc:mysql://localhost/sondaggio");
		int result = mdu.saveUser(usr);
		if (result == 1){
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public User getUsr(){
		return usr;
	}
	
	public void setUsr(User usr){
		this.usr=usr;
	}
}

package it.lab.sondaggio.action;

import com.opensymphony.xwork2.ActionSupport;

import it.lab.sondaggio.model.ManagerDataUser;
import it.lab.sondaggio.view.User;

public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		User usr = new User();
		ManagerDataUser mdu = new ManagerDataUser();
		mdu.saveUser(usr);
		return SUCCESS;
	}
	
}

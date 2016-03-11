package it.lab.sondaggio.action;
import java.util.ArrayList;
import it.lab.sondaggio.model.User;
import it.lab.sondaggio.service.ManagerDataUser;
import it.lab.sondaggio.utils.Parameter;

import com.opensymphony.xwork2.ActionSupport;


public class CreateAdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList<User> allUser = new ArrayList<User>();

	
	public ArrayList<User> getAllUser() {
		return allUser;
	}

	public void setAllUser(ArrayList<User> allUser) {
		this.allUser = allUser;
	}

	public String execute() throws Exception{
		ManagerDataUser mdu = new ManagerDataUser();
		mdu.setPath(Parameter.JDBC_SONDAGGIO);
		allUser = mdu.selectAllUser();
		for (User i : allUser) {
			i.printUser();
		}
		return SUCCESS;
	}
	
}

package it.lab.sondaggio.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogOutAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> session;
	
	@Override
	public String execute() throws Exception {
		session.invalidate();
		return SUCCESS;
	}

	public void setSession(Map<String, Object> sess) {
		session = (SessionMap<String, Object>) sess;

	}

}

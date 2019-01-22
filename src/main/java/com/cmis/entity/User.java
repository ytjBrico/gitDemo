package com.cmis.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = -309857044036575286L;

	private String actorno;
	private String telnum;
	private String ACTORNAME;
	private String NICKNAME;
	private String STATE;
	
	public User(String actorno, String telnum, String actorname, String nickname, String state) {
		super();
		this.actorno = actorno;
		this.telnum = telnum;
		ACTORNAME = actorname;
		NICKNAME = nickname;
		STATE = state;
	}
	public User() {

	}
	public String getActorno() {
		return actorno;
	}
	public void setActorno(String actorno) {
		this.actorno = actorno;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public String getACTORNAME() {
		return ACTORNAME;
	}
	public void setACTORNAME(String aCTORNAME) {
		ACTORNAME = aCTORNAME;
	}
	public String getNICKNAME() {
		return NICKNAME;
	}
	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	
	
	
	
}

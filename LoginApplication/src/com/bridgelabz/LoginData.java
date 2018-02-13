package com.bridgelabz;

public class LoginData {
	
	private String id;
	private String Fname;
	private String Lname;
	private String Uname;
	private String Pass;
	
	public LoginData(){
		
	}

	public LoginData(String id, String fname, String lname, String uname, String pass) {
		super();
		this.id = id;
		Fname = fname;
		Lname = lname;
		Uname = uname;
		Pass = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}
	
	
}

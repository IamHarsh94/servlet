package com.bridgelabz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regexvalidaton {

	
	private static Pattern Emailpattern;
	private static Pattern passPattern;
	private static Matcher Emailmatcher;
	private static Matcher Passmatcher;  

	  private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,30}$";
	  private static final String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	  
	  public Regexvalidaton(){
		  Emailpattern = Pattern.compile(USERNAME_PATTERN);
		  passPattern =Pattern.compile(passwordPattern);
	  }

	  public boolean ValidateEmail(final String username){
		  
		  Emailmatcher = Emailpattern.matcher(username);
		  System.out.println("in username validate");
		  return Emailmatcher.matches();

	  }
	  
	  public boolean validatePassword(String pass){
		 
		  Passmatcher=passPattern.matcher(pass);	
		  System.out.println("in password validate");
		    return Passmatcher.matches();
		   
		}
	  
	  @SuppressWarnings("static-access")
	public static void main(String args[]){
		  Regexvalidaton obj = new Regexvalidaton();
		 System.out.println("Emain: "+obj.ValidateEmail("harshalfegade94"));
		 System.out.println("pass: "+obj.validatePassword("Harshal94@"));
		  
	  }
}

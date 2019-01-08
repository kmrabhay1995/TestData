package com.jlc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> cls) {
		// TODO Auto-generated method stub
		return UserCommand.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
	
	  UserCommand u=(UserCommand) obj;
	  
	  
	  if(u.getUname()==null || u.getUname().length()==0)
		  errors.rejectValue("uname", null,"Username is required");
	  
	if(u.getPass()==null || u.getPass().length()==0)
		  errors.rejectValue("pass",null, "Password is required");
	  
	  
	  
	  if(u.getFname()==null || u.getFname().length()==0)
		  errors.rejectValue("fname", null,"Father Name is required");
	  
	  if(u.getMname()==null || u.getMname().length()==0)
		  errors.rejectValue("mname", null,"Mother Name is required");
	  
	  
	  if(u.getPhone()==null || u.getPhone().length()==0)
		  errors.rejectValue("phone",null, "Phone is required");
	  
	  
	  if(u.getAdhar()==null || u.getAdhar().length()==0)
		  errors.rejectValue("adhar", null,"Aadhar is required");
  
	
	 
	}

}

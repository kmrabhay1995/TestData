package com.jlc;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.ObjectNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class UserException {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ModelAndView obj(HttpServletRequest req)
	{
	
		String name=req.getRequestURI();
		System.out.println(name);
		if(name.endsWith("deleteafter.jlc"))
			return new ModelAndView("delete","msg","Username is not found");
		if(name.endsWith("forgotafter.jlc"))
			return new ModelAndView("forgot","msg","Username is not found");
		else
			return new ModelAndView("index","msg","Username is not found");
	
		
	}
}

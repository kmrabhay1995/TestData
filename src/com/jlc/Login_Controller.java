package com.jlc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



@Controller
public class Login_Controller {
	
	@Autowired
	UserValidator valid;
	
	@Autowired
	UserService us;
	
	@RequestMapping("/login")
	String login(@ModelAttribute("usercommand") UserCommand ucommand,HttpSession session,Model model)
	{
		int captcha=RandomNoGenerator.random(5*1000000, 8*1000000);
		//String captcha=Captcha.generateCaptcha();
		session.setAttribute("captcha",captcha);
		
		return "login";
	}
	
	@ModelAttribute("state")
	public List state()
	{
       ArrayList<String> a=new ArrayList<String>();
		a.add("U.P");
		a.add("Bihar");
		a.add("M.P");
		a.add("Jharkhand");
		a.add("Karnataka");
		return a;
	}

	
	@RequestMapping(value="/city",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody String district(@RequestParam("name") String name) 
	{
		
		ArrayList<String> a=new ArrayList<String>();
		System.out.println("State is "+name);
		
		if(name.equals("U.P"))
		{
			a.add("Gorakhpur");
			a.add("Deoria");
			a.add("Noida");
		}
		else if(name.equals("M.P"))
		{
			a.add("Bhopal");
			a.add("Ujjain");
		}
		else if(name.equals("Bihar"))
		{
			a.add("Mairwa");
			a.add("Siwan");
			a.add("Patna");
		}
		else if(name.equals("Jharkhand"))
		{
			a.add("Ranchi");
			a.add("Devghar");
			a.add("Kola");
		}
		else if(name.equals("Karnataka"))
		{
			a.add("Bangalore");
			a.add("Mangalore");
			a.add("Tiruppati");
		}
		
		
		JSONArray js=new JSONArray();
		JSONObject ob=new JSONObject();
		
		for(String al:a)
		{
			ob.put("city", al);
			js.add(ob);
			System.out.println(al);
			
		}
			
		
		System.out.println("city is "+js);
			return js.toString();
	
	}
	
	
	
	@RequestMapping("/delete")
	String delete()
	{
		
		return "delete";       
	}
	
	
	@RequestMapping("/adminform")
	String admin()
	{
		
		return "admin";       
	}
	
	@RequestMapping("/forgot")
	String forgot()
	{
		
		return "forgot";
	}
	
	
	
	@RequestMapping("/forgotafter")
	String forgotafter(@RequestParam("un") String uname,@RequestParam("fn") String fname,@RequestParam("mn") String mname,Model model)
	{
		String info=us.forgotPass(uname, fname, mname);
		model.addAttribute("msg",info);
		return "forgot";
	}
	
	
	
	@RequestMapping("/search")
	String search()
	{
		
		return "search";
	}
	

	@RequestMapping("/admin")
	String adminsubmit(@RequestParam("uname") String uname,@RequestParam("pass") String pass,Model model)
	{
		boolean x=us.adminVerify(uname, pass);
		if(x)
		return "adminlogin";   
		else
		{
			model.addAttribute("msg","You are not authorized as a Admin");
			return "admin";
		}
	}
	
	
	@RequestMapping("/alluser")
	String alluser(Model model)
	{
		List<UserTO> li=us.getAllUser();
		if(li.size()>0)
		{
			System.out.println("length are "+li.size());
			model.addAttribute("ut",li);
			model.addAttribute("msg","Total User's Recors are:");
		}
		else
			model.addAttribute("msg","No Records are found");
		return "adminlogin";
	}
	
	@RequestMapping("/address")
	String addressform()
	{
		
		return "addressform";
	}
	
	@RequestMapping("/getByAddress")
	String alluserByAddress(@RequestParam("add") String add,Model model,HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List<UserTO> li=us.getAllUserByAddress(add);
		if(li.size()>0)
		{
			
			model.addAttribute("ut",li);
			model.addAttribute("msg","Total User's Recors are:");
		}
		else
			model.addAttribute("msg","No Records are found");
		return "addressform";
	}
	
	
	@RequestMapping("/searchafter")
	String searchafter(@RequestParam("un") String uname,Model model)
	{
		List<UserTO> ut=us.searchUser(uname);
		
		if(ut.size()==0)
			model.addAttribute("msg","No User Found");
		else{
			model.addAttribute("ut",ut);
			model.addAttribute("msg1","User details are---");
		}
		return "search";
	}
	
	
	@RequestMapping("/update")
	String update(@ModelAttribute("usercommand") UserCommand ucmd,HttpSession session,Model model)
	{
		String uname=(String) session.getAttribute("uname");
		UserTO ut=us.update(uname);
		model.addAttribute("ut",ut);
		return "update";
	}
	
	@RequestMapping("/deletemain")
	String deletemain(HttpServletRequest req)
	{
		String uname=req.getParameter("uname");
		us.delete(uname);
		List<UserTO> li=us.getAllUser();
		req.setAttribute("ut", li);
		return "adminlogin";
	}
	
	
	@RequestMapping("/deleteafter")
	String deleteafter(@RequestParam("nm") String uname,Model m)
	{
		System.out.println("name is "+uname);
		boolean x=us.delete(uname);
		if(x)
			m.addAttribute("msg","Delete Successfully");
		else
			m.addAttribute("msg","Delete not Successfully");
		return "delete";
	}

	@RequestMapping("/updateafter")
	String updateafter(@ModelAttribute("usercommand") UserCommand ucommand,BindingResult error,HttpSession session,Model model)
	{
		
		String uname=(String) session.getAttribute("uname");
		ucommand.setUname(uname);
		UserTO ut=new UserTO(ucommand.getUname(),ucommand.getPass(),ucommand.getFname(),ucommand.getMname()
				,ucommand.getPhone(),ucommand.getAdd(),ucommand.getAdhar());
		valid.validate(ucommand, error);
		
		
		if(error.hasErrors())
		{
			System.out.println("address is"+ucommand.getAdd());
			return "update";
		}
		
		
		us.updateafter(ut, uname);
		model.addAttribute("msg","Update Successfully");
		return "loginafter";
	}

	
	@RequestMapping("/log")
	String verify(@RequestParam("uname") String uname,@RequestParam("pass") String pass,Model model,HttpSession session)
	{
		
		boolean x=us.verify(uname, pass);
		if(x==false)
		{

			model.addAttribute("msg","Inavlid Userename or Password...Please sign up!!!!");
			return "index";
		}
		else
		{
			session.setAttribute("uname", uname);
			return "loginafter";
		}
			
		
	}
	
	
	@RequestMapping("/submit")
	ModelAndView submit(@ModelAttribute("usercommand") UserCommand ucommand,BindingResult errors,HttpSession session)
	{
		UserTO ut=new UserTO(ucommand.getUname(),ucommand.getPass(),ucommand.getFname(),ucommand.getMname()
				,ucommand.getPhone(),ucommand.getAdd(),ucommand.getAdhar());
		
		
		System.out.println(ucommand.getCity());
		System.out.println(ucommand.getState());
		
		valid.validate(ucommand, errors);
		if(errors.hasErrors())
		return new ModelAndView("login");
		String cp= (String) session.getAttribute("captcha").toString();
		System.out.println("captcha gen "+cp);
		System.out.println("enter cap is "+ucommand.getCaptcha());
		if(ucommand.getCaptcha().equals(cp)){
		us.addUser(ut);
		return new ModelAndView("index","msg","Added Successfully");
		}
		else
			return new ModelAndView("login","captchamsg","Please Enter Correct Captcha");
		
	}
}

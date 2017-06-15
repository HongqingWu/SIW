package it.uniroma3.siw.galleria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// controller to access the login page
@Controller
public class MainController {

	
	@RequestMapping(value={"/","index"})
	public String home(){
		return "index";
	}

	@RequestMapping(value={"/signIn"})
	public String login(){
		return "signIn";
	}
	@RequestMapping("/login-error.html")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "signIn";
	  }

	@RequestMapping(value="/403")
	public String Error403(){
		return "403";

	}
}
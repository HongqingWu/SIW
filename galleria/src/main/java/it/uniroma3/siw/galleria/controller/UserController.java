package it.uniroma3.siw.galleria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.galleria.service.UserService;

import it.uniroma3.siw.galleria.model.Users;
import it.uniroma3.siw.galleria.model.Users;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService; 

	@ModelAttribute("user")
	public Users costructUser(){
		return new Users();
	}
	
	
	@GetMapping("/userRegistration")
	public  String showForm(Users user){
		return "signUp";
	}
	@GetMapping("/login")
	public String goToLoginPage(Users user){
		return "signIn";
	}
	
	@PostMapping("/userRegistration")
	public String checkUserInfo(@Valid @ModelAttribute Users user, 
			BindingResult bindingResult, Model model) {

		if(!bindingResult.hasErrors()){
			
			if(this.userService.emailExist(user.getEmail()))
				if(this.userService.add(user)){
					model.addAttribute(user);
					model.addAttribute("successo", "user registrata correttamente");
					
				}
				else
					model.addAttribute("fallito", "user registrata non correttamente");
			else
				model.addAttribute("errore", "email già registrato, fare login");
			
		}
		return "signUp";
		
	}
	
	@PostMapping("/login")
    public String checkUserLogin(@Valid @ModelAttribute Users user, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "signIn";
        }
        else {
        	model.addAttribute(user);
            userService.add(user); 
        }
        return "homePage";
    }



}

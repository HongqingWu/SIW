package it.uniroma3.siw.galleria.controller;
import static it.uniroma3.siw.galleria.costanti.CostantiRuoli.UTENTE;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.siw.galleria.service.RuoloUtenteService;
import it.uniroma3.siw.galleria.service.UserService;
import it.uniroma3.siw.galleria.service.RuoloUtenteService;
import it.uniroma3.siw.galleria.model.RuoloUtente;
import it.uniroma3.siw.galleria.model.Users;
import it.uniroma3.siw.galleria.model.Users;

@Controller
public class RegisterController {
	
	
	@Autowired
	private RuoloUtenteService ruoloUtenteService;

	
	@Autowired
	private UserService userService; 

	@ModelAttribute("user")
	public Users costructUser(){
		return new Users();
	}
	
	
	@GetMapping("/userRegistration")
	public  String showFormRegistration(Users user){
		return "signUp";
	}

	
	@PostMapping("/userRegistration")
	public String checkUserInfo(@Valid @ModelAttribute Users user, 
			BindingResult bindingResult, Model model) {

//		if(bindingResult.hasErrors() && this.userService.emailExist(user.getEmail())){
//			
//			
//		
//		return "signUp";
//		}else
//		{
//			this.userService.add(user);
//			
//			return "index";
//		}
		
		if (!bindingResult.hasErrors()) {
			if (!userService.emailExist(user.getEmail())) {
				userService.save(user);

				RuoloUtente ruolo = new RuoloUtente(user, UTENTE);
				ruoloUtenteService.add(ruolo);
				
				model.addAttribute("utente", new Users());
				model.addAttribute("successo", "Utente registrato correttamente");
				return "index";
				
			} else {
				model.addAttribute("errore", "Un utente con questo username è già presente nel sistema.");
				return "signUp"; 
			}
		}
		else 
			
			return "signUp"; 
		
		
	}

	@GetMapping("/accedi")
	public  String showFormLogin(Users user){
		return "signIn";
	}
	
	
	
	@PostMapping("/home")
	public  String showFormHome(@Valid @ModelAttribute Users user, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) 
			return "signIn";
		return "homePage";
	}

}

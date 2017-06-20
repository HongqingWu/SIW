package it.uniroma3.galleriaNew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.galleriaNew.model.Utente;
import it.uniroma3.galleriaNew.service.UtenteService;


// controller to access the login page
@Controller
@SessionAttributes("current_username")
public class HomeController {
	
	@Autowired
	private UtenteService utenteService;
	
	@GetMapping("/")
	public String homepage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			Utente utente = utenteService.findByEmail(authentication.getName());
		    model.addAttribute(utente);
		    model.addAttribute("current_email", utente.getUsername());
		}
		
		return "home";
	}
}

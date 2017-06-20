package it.uniroma3.galleriaNew.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.galleriaNew.model.RuoloUtente;
import it.uniroma3.galleriaNew.model.Utente;
import it.uniroma3.galleriaNew.service.RuoloUtenteService;
import it.uniroma3.galleriaNew.service.UtenteService;



@Controller
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private RuoloUtenteService ruoloUtenteService;

	@RequestMapping("/accedi")
	public String accedi(@Valid @ModelAttribute Utente utente, Model model) {
		
		return "accesso";
	
	}
	@RequestMapping("/registrazione")
	public String registazione(@Valid @ModelAttribute Utente utente, Model model) {
		
		return "registrazione";
	
	}
	
	
	
	@PostMapping("/registrazione")
	public String registraUtente(@Valid @ModelAttribute Utente utente, BindingResult bindingResult, Model model){
		String nextPage = "registrazione";
		model.addAttribute("navAccesso", "active");
		
		if (!bindingResult.hasErrors()) {
			if (!utenteService.alreadyExists(utente.getUsername())) {
				utenteService.save(utente);

				RuoloUtente ruolo = new RuoloUtente(utente, "ROLE_UTENTE");
				ruoloUtenteService.add(ruolo);
				
				model.addAttribute("utente", new Utente());
				 nextPage = "home";
			} else {
				model.addAttribute("errore", "Un utente con questo username è già presente nel sistema.");
				nextPage = "registrazione";
			}
		}
		return nextPage;
	}
	
	@GetMapping("/utente/cercaOpera")
	public String goCercaOperePage(Model model){
		model.addAttribute("formCercaOpera", true);
		return "formUtente";
	}
	
}

package it.uniroma3.galleriaNew.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.galleriaNew.model.Autore;
import it.uniroma3.galleriaNew.model.Opera;
import it.uniroma3.galleriaNew.service.AutoreService;


@Controller
@SessionAttributes("current_username")
public class AutoreController {
	
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/admin/newAutore")
	public String mostraForm(Autore autore, Model model) {
		model.addAttribute("formAutore",true);
		
		return "formAdmin";
	}
	
	@PostMapping("/admin/newAutore")
	public String registraAutore(@Valid @ModelAttribute Autore autore, BindingResult bindingResult, Model model){
		String nextPage = "formAdmin";
		model.addAttribute("formAutore",true);
		if (!bindingResult.hasErrors()) {
			if (!autoreService.alreadyExists(autore.getFirstName(), autore.getLastName())) {
				autoreService.save(autore);
				model.addAttribute("autore", new Autore());
				nextPage = "redirect:/";
			} else {
				model.addAttribute("errore", "Autore già presente nel sistema.");
				nextPage = "formAdmin";
			}
		}
		return nextPage;
	}
	
	@GetMapping("/admin/visualizzaAutori")
	public String mostraAutoreAdmin(Autore autore, Model model) {
		List<Autore> autori = autoreService.findAllAutore();
		model.addAttribute("autori", autori);
		model.addAttribute("formViewAutore",true);
		return "formAdmin";
	}
	

	
	@GetMapping("/admin/visualizzaAutore/{id}")
	public String mostraAutorePerIdAdmin(@PathVariable("id") Long id, Model model){
		Autore autore = autoreService.findOne(id);
		
		model.addAttribute("autore", autore);
		return "viewAutore";
	}
	
	@GetMapping("/utente/visualizzaAutore/{id}")
	public String mostraAutorePerIdUtente(@PathVariable("id") Long id, Model model){
		Autore autore = autoreService.findOne(id);
		
		model.addAttribute("autore", autore);
		return "viewAutore";
	}
	

}

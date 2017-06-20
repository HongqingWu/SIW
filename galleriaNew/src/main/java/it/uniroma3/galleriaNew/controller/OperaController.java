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
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.galleriaNew.model.Autore;
import it.uniroma3.galleriaNew.model.Opera;

import it.uniroma3.galleriaNew.service.AutoreService;
import it.uniroma3.galleriaNew.service.OperaService;


@Controller
public class OperaController {
	@Autowired
	private OperaService operaService;
	
	@Autowired
	private AutoreService autoreService;
	
	
	@GetMapping("/admin/newOpera")
	public String mostraForm(Opera opera, Model model) {
		List<Autore> autori = autoreService.findAllAutore();
		model.addAttribute("autori", autori);
		model.addAttribute("formOpera",true);
		return "formAdmin";
	}
	
	@PostMapping("/admin/newOpera")
	public String registraOpera( @RequestParam(defaultValue="") Long autoreID, @Valid @ModelAttribute Opera opera, BindingResult bindingResult, Model model){
		String nextPage = "formAdmin";
		model.addAttribute("formOpera",true);
		if (!bindingResult.hasErrors()) {
			if (!operaService.alreadyExists(opera.getTitolo())) {
				opera.setAutore(autoreService.findOne(autoreID));
				operaService.save(opera);
				model.addAttribute("opera", new Opera());
				nextPage = "redirect:/";
			} else {
				model.addAttribute("errore", "Opera già presente nel sistema.");
				nextPage = "formAdmin";
			}
		}
		return nextPage;
	}
	
	@GetMapping("/admin/visualizzaOpera")
	public String mostraOpere(Opera opera, Model model) {
		List<Opera> opere = operaService.findAllOpera();
		model.addAttribute("opere", opere);
		model.addAttribute("formViewOpera",true);
		return "formAdmin";
	}
	
	@GetMapping("/utente/visualizzaOpera")
	public String mostraOpereUtente(Opera opera, Model model) {
		List<Opera> opere = operaService.findAllOpera();
		model.addAttribute("opere", opere);
		model.addAttribute("formViewOperaUtente",true);
		return "formUtente";
	}
	
	@PostMapping("/admin/deleteOpera/{id}")
	public String deleteOpera(@PathVariable("id") Long id, Model model){
		Opera opera = operaService.findOne(id);
		operaService.delete(opera);
		model.addAttribute("formViewOpera",true);
		return "redirect:/admin/visualizzaOpera";
	}
	
	@PostMapping("/utente/cercaOpera")
	public String CercaOperaDelAutore( @RequestParam(defaultValue="") String firstName,@RequestParam(defaultValue="") String lastName, Model model){
		List<Opera> opereCercate = operaService.findByAutoreNames(firstName, lastName);
		if(opereCercate.size()!=0){
			model.addAttribute("Opera", true);
			model.addAttribute("opereCercate", opereCercate);

			return "opereView";
		}
		model.addAttribute("erroreOpera", true);
		
		model.addAttribute("erroreCercate", "Non ci sono opere di questo autore");

		return "opereNonTrovate";
	}
}

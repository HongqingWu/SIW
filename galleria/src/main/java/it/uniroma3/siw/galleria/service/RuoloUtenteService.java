package it.uniroma3.siw.galleria.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.galleria.model.RuoloUtente;
import it.uniroma3.siw.galleria.repository.RuoloUtenteRepository;


@Service
public class RuoloUtenteService {
	
	@Autowired
	private RuoloUtenteRepository ruoloUtenteRepository;
	
	@Transactional
	public void add(final RuoloUtente ruoloUtente) {
		this.ruoloUtenteRepository.save(ruoloUtente);
	}
}
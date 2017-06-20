package it.uniroma3.galleriaNew.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleriaNew.model.RuoloUtente;
import it.uniroma3.galleriaNew.repository.RuoloUtenteRepository;


@Service
public class RuoloUtenteService {
	
	@Autowired
	private RuoloUtenteRepository ruoloUtenteRepository;
	
	@Transactional
	public void add(final RuoloUtente ruoloUtente) {
		this.ruoloUtenteRepository.save(ruoloUtente);
	}
}
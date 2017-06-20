package it.uniroma3.galleriaNew.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.galleriaNew.model.Utente;
import it.uniroma3.galleriaNew.repository.UtenteRepository;




@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Utente findByEmail(String username) {
		return this.utenteRepository.findByUsername(username);
	}

	public boolean alreadyExists(String username) {
		return (this.utenteRepository.findByUsername(username)!=null);	
	}

	@Transactional
	public void save(final Utente utente) {		
		utente.setPassword(bCryptPasswordEncoder.encode(utente.getPassword()));
		utente.setEnabled(true);
		
		this.utenteRepository.save(utente);
	}
}

package it.uniroma3.galleriaNew.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleriaNew.model.Autore;

import it.uniroma3.galleriaNew.repository.AutoreRepository;

@Service
public class AutoreService {
	@Autowired
	private AutoreRepository autoreRepository;
	
	
	public boolean alreadyExists(String firstName, String lastName) {
		return (this.autoreRepository.findByFirstNameAndLastName(firstName, lastName)!=null);	
	}

	@Transactional
	public void save(final Autore autore) {
		this.autoreRepository.save(autore);
		
	}
	
	public List<Autore> findAllAutore(){
		return this.autoreRepository.findAll();
		
	}

	public Autore findOne(Long autoreID) {
		return this.autoreRepository.findOneById(autoreID);
		
	}
	
	
	
}

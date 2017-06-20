package it.uniroma3.galleriaNew.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.galleriaNew.model.Utente;



public interface UtenteRepository extends CrudRepository<Utente, String> {
	
	public Utente findByUsername(String username);
	

}

package it.uniroma3.galleriaNew.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.galleriaNew.model.Autore;


public interface AutoreRepository extends CrudRepository<Autore, Integer> {
	public List<Autore> findAll();
	public Autore findByFirstNameAndLastName(String firstName, String lastName);
	
	public Autore findOneById(Long id);
}

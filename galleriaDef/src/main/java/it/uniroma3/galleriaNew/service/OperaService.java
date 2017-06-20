package it.uniroma3.galleriaNew.service;

import static org.mockito.Matchers.longThat;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleriaNew.model.Autore;
import it.uniroma3.galleriaNew.model.Opera;
import it.uniroma3.galleriaNew.repository.AutoreRepository;
import it.uniroma3.galleriaNew.repository.OperaRepository;


@Service
public class OperaService {
	
	@Autowired
	private OperaRepository operaRepository;
	
	@Autowired
	private AutoreRepository autoreRepository;

	public boolean alreadyExists(String titolo) {
		
		return (this.operaRepository.findByTitolo(titolo)!=null);
	}
	@Transactional
	public void save(final Opera opera) {
		
		this.operaRepository.save(opera);
	}
	public List<Opera> findAllOpera() {
		return this.operaRepository.findAll();
	}
	public Opera findOne(Long id) {
		
		return this.operaRepository.findById(id);
	}
	public void delete(Opera opera){
		this.operaRepository.delete(opera);
	}
	public List<Opera> findByAutoreNames(String firstName, String lastName) {
		
		Autore autore = this.autoreRepository.findByFirstNameAndLastName(firstName, lastName);
		
		
		return this.operaRepository.findByAutore(autore);
	}
	
}

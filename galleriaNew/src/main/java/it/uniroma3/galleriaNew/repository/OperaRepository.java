package it.uniroma3.galleriaNew.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.galleriaNew.repository.OperaRepository;
import it.uniroma3.galleriaNew.model.Autore;
import it.uniroma3.galleriaNew.model.Opera;


public interface OperaRepository extends CrudRepository<Opera, Integer> {
	public List<Opera> findAll();
	public Opera findByTitolo(String titolo);
	public Opera findById(Long id);
	public List<Opera> findByAutore(Autore autore);
	
}

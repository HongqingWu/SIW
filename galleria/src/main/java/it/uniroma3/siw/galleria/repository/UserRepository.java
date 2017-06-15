package it.uniroma3.siw.galleria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.galleria.model.User;


public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByEmail(String email);

    List<User> findByFirstName(String lastName);
    
   
}

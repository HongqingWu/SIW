package it.uniroma3.siw.galleria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.galleria.model.Users;


public interface UserRepository extends CrudRepository<Users, Long> {

	

    List<Users> findByFirstName(String lastName);

    Users findByEmail(String email);
    
   
}

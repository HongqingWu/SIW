package it.uniroma3.siw.galleria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.galleria.model.Users;

import it.uniroma3.siw.galleria.repository.UserRepository;

@Service
public class UserService  {
	@Autowired
	private UserRepository userRepository; 

	public Iterable<Users> findAll() {
		return this.userRepository.findAll();
	}

	@Transactional
	public boolean add(final Users user) {
		Iterable<Users> elencoUsers =this.userRepository.findAll();
		for(Users u:elencoUsers){
			if(u.getEmail().equals(user.getEmail())){
				return false;
			}
		}
		this.userRepository.save(user);
		return true;
	}

	public Users findbyId(Long id) {
		return this.userRepository.findOne(id);
	}

	public boolean emailExist(String email) {
		List<Users> users = this.userRepository.findByEmail(email);
		
		if (users != null) {
			return true;
		}
		return false;
	}



}

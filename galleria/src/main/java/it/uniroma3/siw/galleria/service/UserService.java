package it.uniroma3.siw.galleria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.galleria.model.Users;

import it.uniroma3.siw.galleria.repository.UserRepository;

@Service
public class UserService  {
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Iterable<Users> findAll() {
		return this.userRepository.findAll();
	}

//	@Transactional
//	public boolean add(final Users user) {
//		Iterable<Users> elencoUsers =this.userRepository.findAll();
//		for(Users u:elencoUsers){
//			if(u.getEmail().equals(user.getEmail())){
//				return false;
//			}
//		}
//		this.save(user);
//		return true;
//	}

	public Users findbyId(Long id) {
		return this.userRepository.findOne(id);
	}
	
	public Users findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	
	public boolean emailExist(String email) {
		
		return (this.userRepository.findByEmail(email)!=null);	
	}
	
	@Transactional	
	public void save(final Users user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		
		this.userRepository.save(user);
	}


}

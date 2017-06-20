package it.uniroma3.siw.galleria.service;

import it.uniroma3.siw.galleria.model.Users;


public interface IUserService {
	Users registerNewUserAccount(Users accountDto)     
		      throws EmailExistsException;
}

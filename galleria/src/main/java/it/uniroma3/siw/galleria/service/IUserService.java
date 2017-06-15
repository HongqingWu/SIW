package it.uniroma3.siw.galleria.service;

import it.uniroma3.siw.galleria.model.User;
import it.uniroma3.siw.galleria.model.UserDto;

public interface IUserService {
	User registerNewUserAccount(UserDto accountDto)     
		      throws EmailExistsException;
}

package it.uniroma3.siw.galleria.service;

import it.uniroma3.siw.galleria.model.Users;
import it.uniroma3.siw.galleria.model.UserDto;

public interface IUserService {
	Users registerNewUserAccount(UserDto accountDto)     
		      throws EmailExistsException;
}

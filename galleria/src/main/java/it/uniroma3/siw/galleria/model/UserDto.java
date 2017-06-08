package it.uniroma3.siw.galleria.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1)
    private String firstName;

    @NotNull
    @Size(min=1)
    private String lastName;
    
    @NotNull
    
    @Pattern(regexp=".+@.+\\.[a-z]+")
    private String email;
    
    @NotNull
    @Size(min=1)
    private String password;
    
}

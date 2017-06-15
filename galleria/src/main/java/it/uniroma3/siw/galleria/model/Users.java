package it.uniroma3.siw.galleria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp="/./", message="nome non valido")
    private String firstName;

    @NotNull
    @Pattern(regexp="/./", message="cognome non valido")
    private String lastName;
    
    @NotNull
    @Pattern(regexp=".+@.+\\.[a-z]+", message="email non valida ")
    private String email;
    
    @NotNull
    @Pattern(regexp="/./", message="password non valida")
    private String password;
    
    
    private String role;


	public Users() {
		this.role = "ROLE_USER" ;
		
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
    
    
}

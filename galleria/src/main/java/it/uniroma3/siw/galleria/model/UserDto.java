package it.uniroma3.siw.galleria.model;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {



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
	
	@NotNull
	@Size(min=1)
	private String matchingPassword;

	
	
	public UserDto() {
		
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

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	
	
}

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
}

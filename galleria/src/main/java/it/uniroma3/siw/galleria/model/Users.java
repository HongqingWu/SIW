package it.uniroma3.siw.galleria.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user_account")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull

	private String firstName;

	@NotNull

	private String lastName;

	@NotNull
	@Pattern(regexp=".+@.+\\.[a-z]+", message="email non valida ")
	private String email;

	@NotNull

	private String password;




	private boolean Enable;

	public Users() {

		this.Enable=false;

	}

	public boolean isEnabled() {
		return Enable;
	}

	public void setEnabled(final boolean Enable) {
		this.Enable = Enable;
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

	@Override

	public String toString() {
		return "Utente [id=" + id + "firstName " + firstName + "lastName " + lastName +", "
				+ "email=" + email + ", password=" + password + ", enabled=" + Enable+  "]";
	}


}

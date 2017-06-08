package it.uniroma3.siw.galleria.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Autore {
	
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
    @Size(min=1)
	private String nazionalita;
    
    @NotNull
    @Size(min=1)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date annoDiNascita;
	
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date annoDiMorte;
	
	@OneToMany
	@Size(min=1)
	@JoinColumn(name="autore_id")
	private List<Opere> opere;

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

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public Date getAnnoDiNascita() {
		return annoDiNascita;
	}

	public void setAnnoDiNascita(Date annoDiNascita) {
		this.annoDiNascita = annoDiNascita;
	}

	public Date getAnnoDiMorte() {
		return annoDiMorte;
	}

	public void setAnnoDiMorte(Date annoDiMorte) {
		this.annoDiMorte = annoDiMorte;
	}

	public List<Opere> getOpere() {
		return opere;
	}

	public void setOpere(List<Opere> opere) {
		this.opere = opere;
	}
	
	
}

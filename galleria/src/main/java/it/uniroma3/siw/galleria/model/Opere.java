package it.uniroma3.siw.galleria.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Opere {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1)
    private String Titolo;
  

    @NotNull
    @Size(min=1)
    private String tecnica;
    
    @NotNull
    @Size(min=3)
    private String dimensione;
    
    @NotNull
    @Size(min=1)
    @DateTimeFormat(pattern = "dd.MM.yy")
    @Temporal(TemporalType.DATE)
	private Date annoDiRealizzazione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return Titolo;
	}

	public void setTitolo(String titolo) {
		Titolo = titolo;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}

	public Date getAnnoDiRealizzazione() {
		return annoDiRealizzazione;
	}

	public void setAnnoDiRealizzazione(Date annoDiRealizzazione) {
		this.annoDiRealizzazione = annoDiRealizzazione;
	}
    
    
    
    
    
    
    
}

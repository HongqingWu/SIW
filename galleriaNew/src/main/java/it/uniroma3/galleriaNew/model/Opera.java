package it.uniroma3.galleriaNew.model;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.validation.constraints.Pattern;



@Entity
public class Opera {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column(nullable = false)
    private String titolo;
  

	@Column(nullable = false)
    private String tecnica;
    
	@Pattern(regexp="[0-9]+x[0-9]+", message="formato non valida ")
	@Column(nullable = false)
    private String dimensione;
    
    
	@Column(nullable = false)
	private Integer annoDiRealizzazione;
	
	@Column(nullable = false)
	private String linkImg;
	
	@ManyToOne
	private Autore autore;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
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

	public Integer getAnnoDiRealizzazione() {
		return annoDiRealizzazione;
	}

	public void setAnnoDiRealizzazione(Integer annoDiRealizzazione) {
		this.annoDiRealizzazione = annoDiRealizzazione;
	}
	

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public String getLinkImg() {
		return linkImg;
	}

	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
    
    
    
    
    
    
    
}

package it.uniroma3.siw.galleria.model;

import javax.persistence.*;

@Entity
@Table(name = "ruoli_utente", uniqueConstraints = {@UniqueConstraint(columnNames = {"utente_id", "ruolo"})})
public class RuoloUtente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ruolo_utente_id")
	private Integer ruoloUtenteId;
	
	@OneToOne
	private Users utente;
	
	private String ruolo;
	
	public RuoloUtente(Users utente, String ruolo){
		this.utente = utente;
		this.ruolo = ruolo;
	}

	public Integer getRuoloUtenteId() {
		return ruoloUtenteId;
	}

	public void setRuoloUtenteId(Integer ruoloUtenteId) {
		this.ruoloUtenteId = ruoloUtenteId;
	}

	public Users getUtente() {
		return utente;
	}

	public void setUtente(Users utente) {
		this.utente = utente;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}	
}
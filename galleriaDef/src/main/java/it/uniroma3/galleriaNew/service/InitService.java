package it.uniroma3.galleriaNew.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.galleriaNew.model.Autore;
import it.uniroma3.galleriaNew.model.Opera;
import it.uniroma3.galleriaNew.model.RuoloUtente;
import it.uniroma3.galleriaNew.model.Utente;
import it.uniroma3.galleriaNew.repository.AutoreRepository;
import it.uniroma3.galleriaNew.repository.OperaRepository;
import it.uniroma3.galleriaNew.repository.RuoloUtenteRepository;
import it.uniroma3.galleriaNew.repository.UtenteRepository;
@Transactional
@Service
public class InitService {
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private AutoreRepository autoreRepository;
	
	@Autowired
	private OperaRepository operaRepository;
	
	@Autowired
	private RuoloUtenteRepository ruoloUtenteRepository;
	

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@PostConstruct
	public void init(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Utente utente = new Utente();
		utente.setFirstName("admin");
		utente.setLastName("admin");
		utente.setEnabled(true);
		utente.setUsername("admin@admin.admin");
		utente.setPassword(encoder.encode("admin"));
		
		
		utenteRepository.save(utente);
		
		RuoloUtente ruolo = new RuoloUtente(utente, "ROLE_ADMIN");
		ruoloUtenteRepository.save(ruolo);
		
		Utente utente1 = new Utente();
		utente1.setFirstName("wu");
		utente1.setLastName("wu");
		utente1.setEnabled(true);
		utente1.setUsername("wu@qq.com");
		utente1.setPassword(encoder.encode("12345"));
		
		
		utenteRepository.save(utente1);
		
		RuoloUtente ruolo1 = new RuoloUtente(utente1, "ROLE_UTENTE");
		ruoloUtenteRepository.save(ruolo1);
		
		
		Autore autore = new Autore();
		autore.setFirstName("matteo");
		autore.setLastName("vicari");
		autore.setNazionalita("italia");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		String date = "16/08/2016";

		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date, formatter);
		
		
		
		autore.setDataNascita(localDate);
		
		autoreRepository.save(autore);
		
		
		Opera opera = new Opera();
		
		opera.setTitolo("primavera");
		opera.setTecnica("olio");
		opera.setDimensione("20x20");
		opera.setAnnoDiRealizzazione(2000);
		opera.setLinkImg("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Botticelli-primavera.jpg/1200px-Botticelli-primavera.jpg");
		opera.setAutore(autore);
		
		operaRepository.save(opera);
		
		Opera opera1 = new Opera();
		
		opera1.setTitolo("mare");
		opera1.setTecnica("olio");
		opera1.setDimensione("25x25");
		opera1.setAnnoDiRealizzazione(1955);
		opera1.setLinkImg("http://www.artlynow.com/admin/_static/file/opere/13167175271281078184/dipinto-quadro-mare-d-inverno-408_LARGE.jpg");
		opera1.setAutore(autore);
		
		operaRepository.save(opera1);
		
	}
	
	
	
}

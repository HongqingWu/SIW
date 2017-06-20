package it.uniroma3.siw.galleria.security;


 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static it.uniroma3.siw.galleria.costanti.CostantiRuoli.UTENTE;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final String usersQuery = "SELECT email, password, 1 FROM user_account WHERE email = ?";
	private final String rolesQuery = "SELECT u.email, ruoli.ruolo authority " +
			"FROM user_account u JOIN ruoli_utente ruoli ON u.id = ruoli.utente_id WHERE u.email = ?";
	
	@Qualifier("dataSource")
	@Autowired
	private DataSource dataSource;

	@Autowired
	private RedirectLoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	private RedirectLogoutSuccessHandler logoutSuccessHandler;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery(usersQuery)
		.authoritiesByUsernameQuery(rolesQuery);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] paginePubbliche = new String[]{"/", "/signIn", "/homePage", "/logout", "../css/**", "../js/**"};
		http.csrf().disable()
		.formLogin()
		.loginPage("/signIn")
		.permitAll()
		.successHandler(loginSuccessHandler)
		.and()
		.authorizeRequests()
		.antMatchers(paginePubbliche).permitAll()
		.antMatchers("/utente/**").hasRole(UTENTE)
		.anyRequest().permitAll()
		.and()
		.logout().permitAll()
		.logoutSuccessHandler(logoutSuccessHandler);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(bCryptPasswordEncoder())
		.usersByUsernameQuery(usersQuery)
		.authoritiesByUsernameQuery(rolesQuery);
	}
    
}
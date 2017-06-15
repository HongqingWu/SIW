//package it.uniroma3.siw.galleria.security;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.jdbcAuthentication().dataSource(dataSource)
//
//		.passwordEncoder(new BCryptPasswordEncoder())
//		.usersByUsernameQuery("SELECT username,password,1 FROM users where username=?")
//		.authoritiesByUsernameQuery("SELECT username,authority FROM authorities where username=?");
//	}
//
//}

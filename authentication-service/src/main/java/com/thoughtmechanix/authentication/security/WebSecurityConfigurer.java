package com.thoughtmechanix.authentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * This class extends the core Spring Security WebSecurityConfigurerAdapter.
 *
 */
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    
	//The Authentication- ManagerBean is used by Spring Security to handle authentication.
	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

   //The UserDetailsService is used by Spring Security to handle user information that 
   //will be returned the Spring Security.
   @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

   //This method defines users, their passwords, and their roles.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("tim.wolf").password("password3").roles("USER")
                .and()
                .withUser("tom.hawk").password("password4").roles("USER", "ADMIN");
    }
}

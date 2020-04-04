package com.thoughtmechanix.organization.security;


import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * To define access control rules, this class needs to extend a Spring 
 * ResourceServerConfigurerAdapter class and override the classes configure() method.
 *
 */
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
/*
    //Use Case 1: Restricting access to only authenticated users
	@Override
	public void configure(HttpSecurity http) throws Exception{
	    http.authorizeRequests().anyRequest().authenticated();
	}
*/
	//Use Case 2: Restricting deletes to the ADMIN role only
	@Override
    public void configure(HttpSecurity http) throws Exception{
        http
        .authorizeRequests()
          .antMatchers(HttpMethod.DELETE, "/v1/organizations/**")
          .hasRole("ADMIN")
          .anyRequest()
          .authenticated();
    }

}

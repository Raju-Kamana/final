package com.demo.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// find author from database

		if ("reader".equals(username)) {
			return new User("reader", "{noop}reader@123", new ArrayList<>());
//			return new User("reader", "{bcrypt}$2a$10$im6coXO/2WdVbMim3po9fOgf4ltykjFMUDGhQZAlJlVc.4FfOwt8y", new ArrayList<>());
//			return new User("reader", "$2a$10$im6coXO/2WdVbMim3po9fOgf4ltykjFMUDGhQZAlJlVc.4FfOwt8y", new ArrayList<>());
		} else if ("author".equals(username)) {
		return new User("author", "{noop}author@123", new ArrayList<>());
//			return new User("author", "{bcrypt}$2a$10$/ncNWlCpowyFXMA2pzygUuGiz.qAr.WxdkBK3fX0pxvthVgn6hjx2", new ArrayList<>());
			
			
//			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "DIRECTOR"));
//			return new User("director", "$2a$10$/ncNWlCpowyFXMA2pzygUuGiz.qAr.WxdkBK3fX0pxvthVgn6hjx2", authorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
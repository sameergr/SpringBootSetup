package org.test.boot.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userValidateService")
public class UserValidateService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails user = new User(username, "5f4dcc3b5aa765d61d8327deb882cf99", authorities());
		return user;
	}

	@SuppressWarnings("deprecation")
	public Collection<GrantedAuthority> authorities(){
		Collection<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new GrantedAuthorityImpl("USER"));
		return auth;
	}
	
}

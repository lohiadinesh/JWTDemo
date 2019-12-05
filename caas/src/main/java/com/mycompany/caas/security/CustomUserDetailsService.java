package com.mycompany.caas.security;

/**
 * @author dinesh.lohia
 */

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.caas.model.Role;
import com.mycompany.caas.model.RoleName;
import com.mycompany.caas.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	public UserDetails loadUserById(Long id) {
		return UserPrincipal.create(dummyUser());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return UserPrincipal.create(dummyUser());
	}
	
	private User dummyUser() {
		final Set<Role> roles = new HashSet<Role>();
		final Role role = new Role(1l,RoleName.ROLE_USER);
		roles.add(role);
		final User user = new User(13l, "dinesh.lohia", "dinesh", "dinesh.lohia@mycompany.com", "mycompany", roles);
		return user;
	}
}
package fr.dta.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fr.dta.entity.UserLight;
import fr.dta.repository.UserRepository;

@Component
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(final String username) {

		UserLight user = userRepository.findByUsername(username);
		if (user != null) {
			List<GrantedAuthority> rules = this.getUserCredentials(user);
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					rules);
		}
		throw new UsernameNotFoundException("username.not.found");
	}

	private List<GrantedAuthority> getUserCredentials(UserLight user) {

		return AuthorityUtils.createAuthorityList(user.getCredential().toString());
	}
}

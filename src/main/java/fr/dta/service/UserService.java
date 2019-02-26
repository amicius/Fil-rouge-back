package fr.dta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.dta.entity.Credential;
import fr.dta.entity.UserLight;
import fr.dta.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public ResponseEntity<Credential> login(UserLight user) {

		if (this.userRepository.findByUsername(user.getUsername()) != null) {

			UserLight foundUser = this.userRepository.findByUsername(user.getUsername());
			if (foundUser.getPassword().equals(user.getPassword())) {
				return new ResponseEntity<>(foundUser.getCredential(), HttpStatus.OK);
			}
		}
		return ResponseEntity.badRequest().build();
	}
}

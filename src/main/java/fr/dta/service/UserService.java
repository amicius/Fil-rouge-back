package fr.dta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.dta.entity.User;
import fr.dta.entity.UserLight;
import fr.dta.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public ResponseEntity<UserLight> login(UserLight user) {

		if (this.userRepository.findByUsername(user.getUsername()) != null) {

			UserLight foundUser = this.userRepository.findByUsername(user.getUsername());
			if (foundUser.getPassword().equals(user.getPassword())) {
				return new ResponseEntity<>(foundUser, HttpStatus.OK);
			}
		}
		return ResponseEntity.badRequest().build();
	}

	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	public void save(User user) {
		
		userRepository.save(user);
	}

	public ResponseEntity<User> findUserByUsername(String username) {
		
		if (this.userRepository.findByUsername(username) != null) {
			User foundUser = this.userRepository.findByUsername(username);
				return new ResponseEntity<>(foundUser, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}
}

package fr.dta.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.entity.User;
import fr.dta.entity.UserLight;
import fr.dta.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping("/user")
	public ResponseEntity<UserLight> getUser(Principal principal) {

		if (principal != null) {
			UserLight user = userService.findByUsername(principal.getName()).toUserLight();
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}

	@PostMapping("/create-account")
	public void createUser(@RequestBody User user) {
		System.out.println("Le mail est " + user.getEmail());
		System.out.println("Le username est " + user.getUsername());
		System.out.println("Le mot de passe est " + user.getPassword());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);
	}

	@PostMapping("/user")
	public ResponseEntity<User> findUserByUsername(@RequestBody String username) {
		return userService.findUserByUsername(username);
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {

		return userService.update(user);
	}
}
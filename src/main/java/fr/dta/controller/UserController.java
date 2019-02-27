package fr.dta.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.entity.UserLight;
import fr.dta.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/user")
	public ResponseEntity<UserLight> getUser(Principal principal) {

		if (principal != null) {
			UserLight user = userService.findByUsername(principal.getName());
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}
}
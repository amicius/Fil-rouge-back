package fr.dta.controller;

import java.security.Principal;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.entity.UserLight;
import fr.dta.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLight user) {

		return userService.login(user);
	}

	@RequestMapping("/user")
	public Principal user(HttpServletRequest request) {

		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
	}
}
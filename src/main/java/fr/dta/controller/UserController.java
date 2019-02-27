package fr.dta.controller;

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

	@RequestMapping("/user")
	public ResponseEntity<UserLight> login(@RequestBody UserLight user) {

		return userService.login(user);
	}

//	@RequestMapping("/user")
//	public Principal user(HttpServletRequest request) {
//
//		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
//		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
//	}

//	@RequestMapping(method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public void create(@RequestBody @Valid Game jeu) {
//
//		userService.save(jeu);
//	}
}
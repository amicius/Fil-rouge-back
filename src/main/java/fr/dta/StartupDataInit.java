package fr.dta;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import fr.dta.entity.Credential;
import fr.dta.entity.Game;
import fr.dta.entity.Genre;
import fr.dta.entity.Plateform;
import fr.dta.entity.User;
import fr.dta.repository.GameRepository;
import fr.dta.repository.UserRepository;

@Component
public class StartupDataInit {

	@Autowired
	UserRepository userRepository;

	@Autowired
	GameRepository gameRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {

		this.userRepository.save(new User("Corentin", passwordEncoder.encode("corentin"), Credential.ADMIN));
		this.userRepository.save(new User("Matthieu", passwordEncoder.encode("matthieu"), Credential.REGISTER));

		this.gameRepository.save(new Game("Teken", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
	}
}

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

		this.gameRepository.save(new Game("Teken", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image1",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("jhdfgqs", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image2",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("oglsjdfgf", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image3",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("fnghjg", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image4",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("fkdaq", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image5",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("lsdfdbg", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image6",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("dfghkj", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image7",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("mdlfksjhd", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image8",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("bchv5", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image9",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("sndfjh", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image10",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("asj", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image11",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("kghfsds", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image12",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("zertyui", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image13",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("mpoi", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image14",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("xcvbn,;", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image15",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("dtyuj", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image16",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
		this.gameRepository.save(new Game("dfdfg", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image17",
				"Ceci est une description", "ref", 5, "Unbisoft", new Date(), true));
	}
}

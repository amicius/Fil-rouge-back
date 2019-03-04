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

		userRepository.save(new User("Corentin", passwordEncoder.encode("corentin"), Credential.ADMIN));
		userRepository.save(new User("Matthieu", passwordEncoder.encode("matthieu"), Credential.REGISTER));

		gameRepository.save(new Game("Chevaliers du Zodiaque", Plateform.NES, Genre.AVENTURE, 10, "image1",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Titin", Plateform.MEGA_DRIVE, Genre.PLATEFORME, 10, "image2",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Last Battle", Plateform.MEGA_DRIVE, Genre.AVENTURE, 10, "image3",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Dark Castle", Plateform.MEGA_DRIVE, Genre.AVENTURE, 10, "image4",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Sword of Sodan", Plateform.MEGA_DRIVE, Genre.AVENTURE, 10, "image5",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("DragonBall", Plateform.NES, Genre.RPG, 10, "image6", "Ceci est une description",
				5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Ultraman", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image7",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("007 Junior", Plateform.SUPER_NINTENDO, Genre.PLATEFORME, 10, "image8",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Schtroumpfs", Plateform.MEGA_DRIVE, Genre.AVENTURE, 10, "image9",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Virus", Plateform.PLAYSTATION, Genre.AVENTURE, 10, "image10",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Bart VS Space Mutants", Plateform.NES, Genre.AVENTURE, 10, "image11",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Total Recall", Plateform.NES, Genre.AVENTURE, 10, "image12",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Jurassic Park", Plateform.PLAYSTATION, Genre.PLATEFORME, 10, "image13",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Tortue Ninja", Plateform.NES, Genre.AVENTURE, 10, "image14",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("E.T", Plateform.GAMEBOY, Genre.AVENTURE, 10, "image15",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Dragon's Lair", Plateform.NES, Genre.PLATEFORME, 10, "image16",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
		gameRepository.save(new Game("Captain Planet", Plateform.GAMEBOY, Genre.PLATEFORME, 10, "image17",
				"Ceci est une description", 5, "Unbisoft", new Date(), true));
	}
}

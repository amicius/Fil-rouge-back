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
import fr.dta.repository.UserRepository;
import fr.dta.service.GameService;

@Component
public class StartupDataInit {

	@Autowired
	UserRepository userRepository;

	@Autowired
	GameService gameService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {

		userRepository.save(new User("admin", passwordEncoder.encode("admin"), Credential.ADMIN));
		userRepository.save(new User("register", passwordEncoder.encode("register"), Credential.REGISTER));

		// jeux PSX
		
		gameService.save(new Game("Tekken 3", Plateform.PLAYSTATION, Genre.ARCADE, 11,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Tekken 3 est un jeu vidéo de combat, développé et édité par Namco sur borne d'arcade en 1997 puis adapté sur PlayStation en 1998. Il est le troisième épisode de la série Tekken.", 5, "Namco",
				new Date(), true));
		
		gameService.save(new Game("Metal Gear Solid", Plateform.PLAYSTATION, Genre.AVENTURE, 13,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Metal Gear Solid (メタルギアソリッド, Metaru Gia Soriddo), communément abrégé MGS, est un jeu vidéo d'infiltration créé, produit et réalisé par Hideo Kojima employé de Konami, sorti en 1998 sur PlayStation.", 5, "Konami",
				new Date(), true));
		
		gameService.save(new Game("Final Fantasy VII", Plateform.PLAYSTATION, Genre.RPG, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Final Fantasy VII (ファイナルファンタジーVII, Fainaru Fantajī Sebun) est un jeu vidéo de rôle développé par Square (devenu depuis Square Enix) sous la direction de Yoshinori Kitase et sorti en 1997, constituant le septième opus de la série Final Fantasy.", 5, "Square",
				new Date(), true));
		
		gameService.save(new Game("Tony Hawk's Pro Skater 2", Plateform.PLAYSTATION, Genre.SPORT, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Tony Hawk's Pro Skater 2 (également appelé THPS2) est un jeu vidéo de simulation de skateboard, développé par Neversoft et édité par Activision.", 5, "Neversoft",
				new Date(), true));
		
		gameService.save(new Game("Medal of Honor", Plateform.PLAYSTATION, Genre.FPS, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Medal of Honor est un jeu vidéo de tir à la première personne développé par DreamWorks Interactive et édité par Electronic Arts en décembre 1999 en Europe. Le scénariste est Steven Spielberg et le compositeur Michael Giacchino.", 5, "DreamWorks Interactive",
				new Date(), true));
		
		// jeux SNES
		
		gameService.save(new Game("The Legend of Zelda: A Link to the Past", Plateform.SUPER_NINTENDO, Genre.AVENTURE, 11,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "The Legend of Zelda: A Link to the Past (ou simplement A Link to the Past, et parfois Zelda III) est un jeu d'action-aventure développé et édité par Nintendo sorti en septembre 1992 en Europe.", 5, "Nintendo",
				new Date(), true));
		
		gameService.save(new Game("Super Mario World", Plateform.SUPER_NINTENDO, Genre.ARCADE, 13,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Super Mario World (スーパーマリオワールド, Sūpā Mario Wārudo), sous-titré Super Mario Bros. 4 au Japon3, est un jeu vidéo de plates-formes développé et édité par Nintendo sur Super Nintendo.", 5, "Nintendo",
				new Date(), true));
		
		gameService.save(new Game("Final Fantasy VI", Plateform.SUPER_NINTENDO, Genre.RPG, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Final Fantasy VI (ファイナルファンタジーVI, Fainaru Fantajī Shikkusu) est un jeu vidéo de rôle, développé et publié par Square Co., Ltd. (maintenant Square Enix) en 1994 pour la SNES.", 5, "Square Co.",
				new Date(), true));
		
		gameService.save(new Game("Mega Man Soccer", Plateform.SUPER_NINTENDO, Genre.SPORT, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Mega Man Soccer (Rockman's Soccer (ロックマンズサッカー, Rokkumanzu Sakkā) au Japon) est un jeu vidéo de football développé par Sun L et édité par Capcom en 1994 sur Super Nintendo.", 5, "Capcom",
				new Date(), true));
		
		gameService.save(new Game("DOOM", Plateform.SUPER_NINTENDO, Genre.FPS, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "DOOM est un jeu vidéo de tir en vue à la première personne (en anglais First person shooter ou FPS), développé et édité par la société id Software et publié le 10 décembre 1993.", 5, "iD Software",
				new Date(), true));
		
		// jeux GENESIS
		
		gameService.save(new Game("The Revenge of Shinobi", Plateform.MEGA_DRIVE, Genre.ARCADE, 11,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "The Revenge of Shinobi (ザ・スーパー・忍, Za Sūpā Shinobi, The Super Shinobi) est un jeu vidéo d'action développé par Team Shinobi et édité par Sega, sorti en 1989 sur Mega Drive et borne d'arcade.", 5, "Sega",
				new Date(), true));
		
		gameService.save(new Game("Sonic 3", Plateform.MEGA_DRIVE, Genre.AVENTURE, 13,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Sonic 3, dont le titre est Sonic the Hedgehog 3 en Amérique du Nord et au Japon, est un jeu vidéo de plates-formes, développé par Sonic Team, sorti sur Mega Drive en 1994.", 5, "Sega",
				new Date(), true));
		
		gameService.save(new Game("Phantasy Star II", Plateform.MEGA_DRIVE, Genre.RPG, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Phantasy Star II ( Fantashī Sutā II Kanrazaru Ji No Owari ni?) est un jeu de rôle développé par Team Shinobi et édité par Sega sorti en 1989 sur Mega Drive.", 5, "Team Shinobi",
				new Date(), true));
		
		gameService.save(new Game("World Cup Italia '90", Plateform.MEGA_DRIVE, Genre.SPORT, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "World Cup Italia '90 ou World Championship Soccer est un jeu vidéo de football édité par Sega sur Mega Drive et borne d'arcade (Sega Mega-Tech) en 1989.", 5, "Sega",
				new Date(), true));
		
		gameService.save(new Game("Duke Nukem 3D", Plateform.MEGA_DRIVE, Genre.FPS, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Duke Nukem 3D est un jeu de tir à la première personne développé par 3D Realms et initialement commercialisé en 1996 sur PC.", 5, "Apogee Software",
				new Date(), true));
		
		// jeux GAMEBOY
		
		
		gameService.save(new Game("Tetris", Plateform.GAMEBOY, Genre.ARCADE, 11,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Tetris est un jeu vidéo de puzzle conçu par Alekseï Pajitnov à partir de juin 1984 sur Elektronika 60.", 5, "Alekseï Pajitnov",
				new Date(), true));
		
		gameService.save(new Game("Pokémon version jaune", Plateform.GAMEBOY, Genre.AVENTURE, 13,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Pokémon version jaune : édition spéciale Pikachu (Poketto Monsutā Pikachū, lit. Pocket Monsters Pikachu), couramment appelé Pokémon Jaune est un jeu vidéo de rôle japonais de la licence Pokémon développé par Game Freak sous la direction de Satoshi Tajiri.", 5, "Nintendo",
				new Date(), true));
		
		gameService.save(new Game("Pokémon version jaune", Plateform.GAMEBOY, Genre.RPG, 13,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Pokémon version jaune : édition spéciale Pikachu (Poketto Monsutā Pikachū, lit. Pocket Monsters Pikachu), couramment appelé Pokémon Jaune est un jeu vidéo de rôle japonais de la licence Pokémon développé par Game Freak sous la direction de Satoshi Tajiri.", 5, "Nintendo",
				new Date(), true));
		
		gameService.save(new Game("Nintendo World Cup", Plateform.GAMEBOY, Genre.SPORT, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Nintendo World Cup, est un jeu vidéo de football développé par Technos Japan et édité par Nintendo en 1990 pour sa console Nintendo Entertainment System et par la suite pour la console portable Game Boy.", 5, "Nintendo",
				new Date(), true));
		
		gameService.save(new Game("Wolfenstein 3D", Plateform.GAMEBOY, Genre.FPS, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Wolfenstein 3D est un jeu vidéo de tir à la première personne développé par id Software et publié par Apogee Software le 5 mai 1992 sur MS-DOS.", 5, "Apogee Software",
				new Date(), true));
		
		// jeux NES
		
		
		gameService.save(new Game("Probotector", Plateform.NES, Genre.ARCADE, 11,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Probotector, ou Gryzor selon les versions, plus connu sous le nom Contra hors-europe, est un jeu vidéo d'action de type shoot'n jump, développé et édité par Konami, sorti initialement en 1987 sur borne d'arcade.", 5, "Konami",
				new Date(), true));
		
		gameService.save(new Game("Kirby's Adventure", Plateform.NES, Genre.AVENTURE, 13,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Kirby des étoiles : Le Conte de la Fontaine des rêves, est un jeu vidéo de plate-forme sorti sur Nintendo Entertainment System développé par HAL Laboratory en 1993. Il a pour héros Kirby.", 5, "Nintendo",
				new Date(), true));
		
		gameService.save(new Game("Final Fantasy", Plateform.NES, Genre.RPG, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Final Fantasy (Fainaru Fantajī) est un jeu vidéo de rôle développé et publié par Square Co., Ltd. pour la Nintendo Entertainment System (NES) en 1987. Il est le jeu inaugural de la série principale de Square : Final Fantasy.", 5, "Square Co.",
				new Date(), true));
		
		gameService.save(new Game("Mike Tyson's Punch-Out!!", Plateform.NES, Genre.SPORT, 12,
				"http://image.jeuxvideo.com/images-sm/ns/s/s/ssodns0f.jpg", "Mike Tyson's Punch-Out!! est un jeu vidéo sorti sur Nintendo Entertainment System (NES) en 1987, puis ressorti sous le nom de Punch-Out!! featuring Mr. Dream en 1990. Ce jeu est basé sur le jeu d'arcade Punch-Out!! sorti en 1983.", 5, "Nintendo",
				new Date(), true));
		
		
		
	}
}

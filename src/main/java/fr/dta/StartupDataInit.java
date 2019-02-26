package fr.dta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.dta.entity.Credential;
import fr.dta.entity.User;
import fr.dta.repository.UserRepository;

@Component
public class StartupDataInit {

	@Autowired
	UserRepository userRepository;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {

		this.userRepository.save(new User("Corentin", "corentin", Credential.ADMIN));
	}
}

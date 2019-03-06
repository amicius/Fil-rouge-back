package fr.dta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dta.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
}

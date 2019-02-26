package fr.dta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dta.entity.User;
import fr.dta.entity.UserLight;

public interface UserRepository extends JpaRepository<User, Integer> {

	UserLight findByUsername(String username);
}

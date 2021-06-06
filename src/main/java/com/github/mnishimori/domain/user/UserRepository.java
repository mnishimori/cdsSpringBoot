package com.github.mnishimori.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByCpf(String cpf);
	
	Optional<User> findByemail(String email);
	
}

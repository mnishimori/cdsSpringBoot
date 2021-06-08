package com.github.mnishimori.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserSystemRepository extends JpaRepository<UserSystem, Integer>{

	Optional<UserSystem> findByCpf(String cpf);
	
	Optional<UserSystem> findByemail(String email);
	
}

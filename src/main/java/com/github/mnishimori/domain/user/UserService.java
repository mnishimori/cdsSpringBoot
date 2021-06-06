package com.github.mnishimori.domain.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.mnishimori.domain.exception.UnregisteredException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	@Transactional
	public User save(User user) {
		
		return repository.save(user);
	}
	
	
	public List<User> list() {
		
		return repository.findAll();
	}
	
	
	public User findUserByEmail(String email) {
		
		return repository.findByemail(email)
				.orElseThrow(() -> new UnregisteredException("Usuário não cadastrado com o email " + email));
	}

}

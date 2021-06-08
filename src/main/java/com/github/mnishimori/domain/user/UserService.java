package com.github.mnishimori.domain.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.mnishimori.domain.exception.UnregisteredEntityException;

@Service
public class UserService {
	
	@Autowired
	private UserSystemRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Transactional
	public UserSystem save(UserSystem user) {
		
		this.validateRequiredFields(user);
		
		this.prepareToSave(user);
		
		return repository.save(user);
	}
	

		public List<UserSystem> list() {
		
		return repository.findAll();
	}
	
	
	public UserSystem findUserByEmail(String email) {
		
		return repository.findByemail(email)
				.orElseThrow(() -> new UnregisteredEntityException("Usuário não cadastrado com o email " + email));
	}

	
	private void prepareToSave(UserSystem user) {
		
		String cryptPassword = encoder.encode(user.getPassword());
		
		user.setPassword(cryptPassword);
	}


	private void validateRequiredFields(UserSystem user) {
		
		if (user == null) {
			throw new NullPointerException("Classe usuário inválida");
		}
	}

}

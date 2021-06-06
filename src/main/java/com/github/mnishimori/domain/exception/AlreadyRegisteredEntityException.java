package com.github.mnishimori.domain.exception;

public class AlreadyRegisteredEntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AlreadyRegisteredEntityException(String message) {
		super(message);
	}
	
	public AlreadyRegisteredEntityException(String entidade, Long id) {
		super(String.format("Existe %s com o código %d cadastrado", entidade, id));
	}

}

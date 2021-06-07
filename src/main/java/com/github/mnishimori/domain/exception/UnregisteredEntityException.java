package com.github.mnishimori.domain.exception;

public class UnregisteredEntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UnregisteredEntityException(String message) {
		super(message);
	}
	
	public UnregisteredEntityException(String entidade, Long id) {
		super(String.format("Não existe %s com o código %d", entidade, id));
	}

	public UnregisteredEntityException(String entidade, Integer id) {
		super(String.format("Não existe %s com o código %d", entidade, id));
	}

}

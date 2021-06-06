package com.github.mnishimori.domain.exception;

public class UnregisteredException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UnregisteredException(String message) {
		super(message);
	}
	
	public UnregisteredException(String entidade, Long id) {
		super(String.format("Não existe %s com o código %d", entidade, id));
	}

	public UnregisteredException(String entidade, Integer id) {
		super(String.format("Não existe %s com o código %d", entidade, id));
	}

}

package com.github.mnishimori.domain.exception;

public class EntidadeJaCadastradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntidadeJaCadastradaException(String message) {
		super(message);
	}
	
	public EntidadeJaCadastradaException(String entidade, Long id) {
		super(String.format("Existe %s com o código %d cadastrado", entidade, id));
	}

}

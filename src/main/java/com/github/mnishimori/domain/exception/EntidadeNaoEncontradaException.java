package com.github.mnishimori.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}
	
	public EntidadeNaoEncontradaException(String entidade, Long id) {
		super(String.format("Não existe %s com o código %d", entidade, id));
	}

	public EntidadeNaoEncontradaException(String entidade, Integer id) {
		super(String.format("Não existe %s com o código %d", entidade, id));
	}

}

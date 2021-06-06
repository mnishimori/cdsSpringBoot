package com.github.mnishimori.domain.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NegocioException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> erros;

	public NegocioException(List<String> erros) {
		super();
		this.erros = erros;
	}

	public NegocioException() {
		super();
	}

	public NegocioException(String msg) {
		super(msg);
	}

	public NegocioException(String msg, Throwable t) {
		super(msg, t);
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

}

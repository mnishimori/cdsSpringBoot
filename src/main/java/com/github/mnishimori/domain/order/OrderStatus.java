package com.github.mnishimori.domain.order;

public enum OrderStatus {
	
	REALIZADO("REALIZADO"),
	CANCELADO("CANCELADO");
	
	private String label;

	OrderStatus(String labelStatus) {
		this.label = labelStatus;
	}

	public String getLabel() {
		return label;
	}

}

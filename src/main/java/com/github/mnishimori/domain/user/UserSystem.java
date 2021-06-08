package com.github.mnishimori.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserSystem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private Boolean del;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UserSystem registrationUser;
	
	@CreationTimestamp
	@Column(name = "dt_cadastro")
	private LocalDateTime registrationDate;
	
	@NotEmpty(message = "Informe o nome do usuário")
	@Column
	private String name;
	
	@NotEmpty(message = "Informe o CPF")
	@CPF
	@Column
	private String cpf;
	
	@NotEmpty(message = "Informe o email")
	@Email
	@Column
	private String email;
	
	@Column
	private Boolean active;
	
	@NotEmpty(message = "Informe a senha")
	@Length(min = 6, message = "A senha deve possuir no mínimo 6 caracteres")
	@Column
	private String password;
	
	@Column
	private Boolean admin;

	
	public UserSystem() {
		setDel(false);
		setActive(true);
	}
	
	public UserSystem(Integer id) {
		this();
		setId(id);
	}

}

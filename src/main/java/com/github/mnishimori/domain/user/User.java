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

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private Boolean del;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private User user;
	
	@CreationTimestamp
	@Column(name = "dt_cadastro")
	private LocalDateTime registrationDate;
	
	@Column
	private String name;
	
	@Column(unique = true)
	private String cpf;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private Boolean active;

	
	public User() {
		setDel(false);
	}
	
	public User(Integer id) {
		this();
		setId(id);
	}

}

package com.github.mnishimori.domain.base;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

import com.github.mnishimori.domain.user.User;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
	
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
	
	
	public BaseEntity() {
		setDel(false);
	}
	
	public BaseEntity(Integer id) {
		this();
		setId(id);
	}
	
	public Boolean isNewEntity() {
		return this.getId() == null || this.getId() == 0 ? true : false;
	}

}

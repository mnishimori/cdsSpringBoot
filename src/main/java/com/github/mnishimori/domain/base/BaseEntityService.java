package com.github.mnishimori.domain.base;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.github.mnishimori.domain.exception.BusinessException;
import com.github.mnishimori.domain.exception.UnregisteredEntityException;
import com.github.mnishimori.domain.user.UserService;

public abstract class BaseEntityService<T> {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JpaRepository<T, Integer> repository;
	
	
	@Transactional
	public T save(T entity) {
		
		T entityToSave = this.prepareToSave(entity);
		
		return repository.save(entityToSave);
	}
	
	
	public List<T> list() {
		
		return repository.findAll();
	}
	
	
	public T findById(Integer id) {
		
		return repository.findById(id).orElseThrow(
				() -> new UnregisteredEntityException("Registro " + getClass().getName() + " não encontrado com ID " + id));
	}
	
	
	public List<T> search(T entity) {
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		
		Example<T> example = Example.of(entity, matcher);
		
		return repository.findAll(example);
	}
	
	
	@Transactional
	public T update(Integer id, T entity) {
		
		this.findById(id);
		
		T entityToSave = this.prepareToSave(entity);
		
		return repository.save(entityToSave);
	}
	
	
	@Transactional
	public void delete(Integer id) {
		
		T entity = this.findById(id);
		
		((BaseEntity) entity).setDel(true);
		repository.save(entity);
	}
	
	
	protected T prepareToSave(T entity) {
		
		this.validateFields(entity);
		
		BaseEntity entityToPrepare = (BaseEntity) entity;
		
		T entityToSave = null;
		
		if (entityToPrepare.isNewEntity()) {
			
			entityToSave = (T) entity;
			
			this.identifyRegistrationUser(entityToPrepare, entityToSave);
			
		} else {
			
			entityToSave = this.findById(entityToPrepare.getId());
		
			BeanUtils.copyProperties(entityToPrepare, entityToSave, "registrationUser", "registrationDate");
			
		}
		
		return entityToSave;
	}


	protected void identifyRegistrationUser(BaseEntity entityToPrepare, T entityToSave) {
		
		((BaseEntity) entityToSave).setRegistrationUser(
				userService.findUserByEmail(entityToPrepare.getRegistrationUser().getEmail()));
	}
	
	
	protected void validateFields(T entity) {
		
		if (entity == null) {
			throw new BusinessException("Entidade " + getClass().getName() + " inválida!");
		} else {
			if (((BaseEntity) entity).isNewEntity()) {
				if (((BaseEntity) entity).getRegistrationUser() == null) {
					throw new BusinessException("Informe o usuário de cadastro!");
				} else {
					if (((BaseEntity) entity).getRegistrationUser().getEmail() == null
							|| ((BaseEntity) entity).getRegistrationUser().getEmail().trim().isEmpty()) {
						throw new BusinessException("Informe o usuário de cadastro!");
					}
				}
			}
		}
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public JpaRepository<T, Integer> getRepository() {
		return repository;
	}


	public void setRepository(JpaRepository<T, Integer> repository) {
		this.repository = repository;
	}
}
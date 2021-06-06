package com.github.mnishimori.api.assembler;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

@Getter
public abstract class GenericDtoAssembler<E, REQ, RES> {
	
	private Class<E> entityClass;
	private Class<REQ> requestClass;
	private Class<RES> responseClass;
	
	@Autowired
	private ModelMapper mapper;
	
	@SuppressWarnings("unchecked")
	public GenericDtoAssembler() {
		this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.requestClass = (Class<REQ>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		this.responseClass = (Class<RES>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
	}
	
	public RES toDtoFromModel(E entityClass) {
		return mapper.map(entityClass, getResponseClass());
	}
	
	public List<RES> toCollectionDtoFromModel(Collection<E> requestEntities) {
        return requestEntities.stream()
			.map(entity -> toDtoFromModel(entity))
			.collect(Collectors.toList());
    }
	
	public List<E> toCollectionModelFromCollectionDto(Collection<REQ> requestEntities) {
        return requestEntities.stream()
			.map(entity -> toDomainObjectFromDto(entity))
			.collect(Collectors.toList());
	}
	
    
    public E toDomainObjectFromDto(REQ requestClass) {
        return mapper.map(requestClass, getEntityClass());
    }

    public void copyToDomainObjectFromDto(REQ requestClass, E entityClass) {
        mapper.map(requestClass, entityClass);
    }

}

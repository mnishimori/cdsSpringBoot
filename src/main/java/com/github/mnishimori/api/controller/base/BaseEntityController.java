package com.github.mnishimori.api.controller.base;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.mnishimori.api.assembler.GenericDtoAssembler;
import com.github.mnishimori.domain.base.BaseEntityService;

public abstract class BaseEntityController<T, REQ, RES> {
	
	@Autowired
	protected BaseEntityService<T> service;
	
	@Autowired
	protected GenericDtoAssembler<T, REQ, RES> assembler;
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RES save(@RequestBody @Valid REQ requestDto) {
		
		T entityToSave = this.assembler.toDomainObjectFromDto(requestDto);
		
		return this.assembler.toDtoFromModel(this.service.save(entityToSave));
	}
	
	
	@GetMapping
	public List<RES> list() {
		
		return this.assembler.toCollectionDtoFromModel(this.service.list());
	}
	
	
	@GetMapping("/{id}")
	public RES findById(@PathVariable Integer id) {
		
		return this.assembler.toDtoFromModel(this.service.findById(id));
	}
	
	
	@GetMapping("/pesquisa")
	public List<RES> search(REQ requestDto) {
		
		T entityToFind = this.assembler.toDomainObjectFromDto(requestDto);
		
		return this.assembler.toCollectionDtoFromModel(this.service.search(entityToFind));
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public RES update(@PathVariable Integer id, @RequestBody @Valid  REQ requestDto) {
		
		T entityToSave = this.assembler.toDomainObjectFromDto(requestDto);
		
		return this.assembler.toDtoFromModel(this.service.update(id, entityToSave));
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		
		this.service.delete(id);
	}
	
}

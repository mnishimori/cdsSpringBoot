package com.github.mnishimori.domain.product;

import org.springframework.stereotype.Service;

import com.github.mnishimori.domain.base.BaseEntityService;

@Service
public class ProductService extends BaseEntityService<Product>{

	/*
	@Autowired
	private ProductRepository repository;
	
	@Transactional
	public Product salvar(Product produto) {
		
		return repository.save(produto);
	}
	
	
	public List<Product> listar() {
		
		return repository.findAll();
	}
	
	
	public Product findById(Integer id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new UnregisteredException("Produto não encontrado!"));
	}
	
	
	public List<Product> pesquisar(Product produto) {
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		
		Example<Product> example = Example.of(produto, matcher);
		
		return repository.findAll(example);
	}
	
	
	@Transactional
	public Product atualizar(Integer id, Product produto) {
		
		this.findById(id);
		produto.setId(id);
		
		return repository.save(produto);
	}
	
	
	@Transactional
	public void deletar(Integer id) {
		
		Product produto = this.findById(id);
		
		repository.delete(produto);
	}
	*/
}

package com.github.mnishimori.api.controller.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.mnishimori.domain.cliente.Cliente;
import com.github.mnishimori.domain.cliente.ClienteService;

@RestController
@RequestMapping("/vendas/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody Cliente cliente) {
		
		return clienteService.salvar(cliente);
	}
	
	
	@GetMapping
	public List<Cliente> listar() {
		
		return clienteService.listar();
	}
	
	
	@GetMapping("/{id}")
	public Cliente buscarClientePorId(@PathVariable Integer id) {
		
		try {
			return clienteService.findById(id);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			
		}
	}
	
	
	@GetMapping("/pesquisa")
	public List<Cliente> pesquisarClientes(Cliente cliente) {
		
		return clienteService.pesquisar(cliente);
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente atualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
		
		try {
			return clienteService.atualizar(id, cliente);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			
		}
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		
		try {
			clienteService.deletar(id);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			
		}
	}

}

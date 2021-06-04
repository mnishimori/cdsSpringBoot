package com.github.mnishimori.api.controller.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.mnishimori.domain.cliente.Cliente;
import com.github.mnishimori.domain.cliente.ClienteService;

@RestController
@RequestMapping("/clientes")
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
	public ResponseEntity buscarClientePorId(@PathVariable Integer id) {
		
		try {
			
			return ResponseEntity.ok(clienteService.findById(id));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return ResponseEntity.notFound().build();
	}

}

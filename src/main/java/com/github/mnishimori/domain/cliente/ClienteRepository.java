package com.github.mnishimori.domain.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	List<Cliente> findByNomeLikeIgnoreCase(String nome);
	
	@Query("select c from Cliente c left join fetch c.pedidos p where c.id = :id ")
	Cliente findClienteFetchPedidos(@Param("id") Integer id);

}

package com.github.mnishimori.domain.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByNameLikeIgnoreCase(String name);
	
	@Query("select c from Customer c left join fetch c.orders p where c.id = :id ")
	Customer findClienteFetchPedidos(@Param("id") Integer id);

}

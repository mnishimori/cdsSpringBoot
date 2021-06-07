package com.github.mnishimori.domain.order;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface OrderRepository extends JpaRepository<Order, Integer>{
	
	List<Order> findByDelAndCustomerId(Boolean del, Integer customerId);
	
	@Query("select o from Order o left join fetch o.items where o.id = :id")
	Optional<Order> findByIdFetchItems(@Param("id") Integer id);

}

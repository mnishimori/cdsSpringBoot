package com.github.mnishimori.domain.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseEntityRepository<T, ID> extends JpaRepository<T, ID> {

}

package com.ipartek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.model.Disco;

@Repository
public interface DiscoRepository extends JpaRepository<Disco, Integer>{

}

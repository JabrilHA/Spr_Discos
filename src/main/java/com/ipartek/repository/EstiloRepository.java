package com.ipartek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.model.Estilo;

@Repository
public interface EstiloRepository extends JpaRepository<Estilo, Integer> {

}

package com.ipartek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.model.Estilo;
import com.ipartek.repository.EstiloRepository;

@Service
public class EstiloServiceImpl implements IEstiloService{
	@Autowired
	private EstiloRepository estiloRepo;

	@Override
	public void insertarEstilo(Estilo estilo) {
		estiloRepo.save(estilo);
		
	}

	@Override
	public List<Estilo> ObtenerTodosEstilos() {
		List<Estilo> listaEstilo = estiloRepo.findAll();
		return listaEstilo;
	}
	
	

}

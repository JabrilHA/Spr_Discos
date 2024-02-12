package com.ipartek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.model.Disco;
import com.ipartek.repository.DiscoRepository;

@Service
public class DiscoServiceImpl implements IDiscoService{

	@Autowired
	private DiscoRepository discoRepo;
	
	@Override
	public List<Disco> obtenerTodosDiscos() {
		List<Disco> listaDiscos = discoRepo.findAll();
		return listaDiscos;
	}

	@Override
	public void guardarDisco(Disco disco) {
		discoRepo.save(disco);
		
	}

	@Override
	public Optional<Disco> buscarDiscoPorId(int id) {
		Optional<Disco> disco = discoRepo.findById(id);
		
		return disco;
	}

	@Override
	public void eliminarDisco(int id) {
		discoRepo.deleteById(id);
		
	}

}

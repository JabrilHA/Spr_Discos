package com.ipartek.service;

import java.util.List;
import java.util.Optional;

import com.ipartek.model.Disco;


public interface IDiscoService {
	
	public List<Disco> obtenerTodosDiscos();
	public void guardarDisco(Disco disco);
	public Optional<Disco> buscarDiscoPorId(int id);
	public void eliminarDisco(int id);

}

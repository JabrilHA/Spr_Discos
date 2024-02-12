package com.ipartek.service;

import java.util.List;

import com.ipartek.model.Estilo;

public interface IEstiloService {

	public void insertarEstilo(Estilo estilo);
	
	public List<Estilo> ObtenerTodosEstilos();
}

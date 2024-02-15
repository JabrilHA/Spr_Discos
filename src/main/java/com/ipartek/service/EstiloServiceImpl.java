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

	/**
	 * Funcion que nos permite guardar un estilo en la BD.
	 * 
	 * @param estilo estilo que queremos insertar en la BD.
	 */
	@Override
	public void insertarEstilo(Estilo estilo) {
		estiloRepo.save(estilo);
		
	}

	/**
	 * Funcion que nos permite obtener todos los estilos de la BD
	 * 
	 * @return una lista de todos los estilos.
	 */
	@Override
	public List<Estilo> ObtenerTodosEstilos() {
		List<Estilo> listaEstilo = estiloRepo.findAll();
		return listaEstilo;
	}
	
	

}

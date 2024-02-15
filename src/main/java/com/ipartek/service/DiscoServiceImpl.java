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
	
	/**
	 * Funcion que nos permite obtener todos los discos de la BD
	 * 
	 * @return una lista de todos los discos.
	 */
	@Override
	public List<Disco> obtenerTodosDiscos() {
		List<Disco> listaDiscos = discoRepo.findAll();
		return listaDiscos;
	}

	/**
	 * Funcion que nos permite guardar un disco en la BD.
	 * 
	 * @param disco disco que queremos insertar en la BD.
	 */
	@Override
	public void guardarDisco(Disco disco) {
		discoRepo.save(disco);
		
	}

	/**
	 * Funcion que nos permite buscar un disco en la BD por su id.
	 * 
	 * @param id identificador del objeto que queremos buscar
	 * 
	 * @return nos devuelve el disco buscado.
	 */
	@Override
	public Optional<Disco> buscarDiscoPorId(int id) {
		Optional<Disco> disco = discoRepo.findById(id);
		
		return disco;
	}

	/**
	 * Funcion que nos permite el eliminar un disco de la BD
	 * 
	 * @param id identificado del disco a eliminar.
	 */
	@Override
	public void eliminarDisco(int id) {
		discoRepo.deleteById(id);
		
	}

}

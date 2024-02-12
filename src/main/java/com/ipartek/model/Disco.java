package com.ipartek.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "discos")
public class Disco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "num_canciones")
	private int num_canciones;
	
	@Column(name="Enlace_spotify")
	private String enlace_spotify;
	
	@Column(name = "foto")
	private String foto;
	
	
	@ManyToOne
	private Estilo estilo;

	public Disco(int id, String nombre, int num_canciones, String enlace_spotify, String foto, Estilo estilo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.num_canciones = num_canciones;
		this.enlace_spotify = enlace_spotify;
		this.foto = foto;
		this.estilo = estilo;
	}

	public Disco() {
		super();
		this.id = 0;
		this.nombre = "";
		this.num_canciones = 0;
		this.foto = "";
		this.enlace_spotify = "";
		this.estilo = new Estilo();
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNum_canciones() {
		return num_canciones;
	}

	public void setNum_canciones(int num_canciones) {
		this.num_canciones = num_canciones;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public String getEnlace_spotify() {
		return enlace_spotify;
	}

	public void setEnlace_spotify(String enlace_spotify) {
		this.enlace_spotify = enlace_spotify;
	}

	@Override
	public String toString() {
		return "Disco [id=" + id + ", nombre=" + nombre + ", num_canciones=" + num_canciones + ", enlace_spotify="
				+ enlace_spotify + ", foto=" + foto + ", estilo=" + estilo + "]";
	}

	


	
	
}

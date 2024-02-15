package com.ipartek.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * <p>
 * Clase Estilo
 * </p>
 * 
 * <p>
 * Esta clase generara una tabla estilos dentro de la BD. lo hara de manera
 * automatica, haciendi uso de JPA (Hibernate)
 * </p>
 */
@Entity
@Table(name="estilos")
public class Estilo {
	/**
     * <p>
     * Atributo id
     * </p>
     * 
     * <p>
     * Este atributo es el campo primary key de la tabla. se generara con un modo
     * auto incremental para llevar el orden a la hora de generar registros
     * </p>
     * 
     * <p>
     * Cuando creemos un objeto de esta clase, este campo recibira un valor numerico
     * solo si el objeto es leido de la BD. Si vamos a insertar en la BD le
     * asignaremos al id el valor 0.
     * </p>
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	/**
     * <p>
     * Atributo estilo
     * </p>
     * 
     * <p>
     * Este atributo nos indica el nombre del estilo que queremos representar.
     * </p>
     */
	@Column(name = "estilo")
	private String estilo;

	 /**
     * <p>
     * Constructor completo
     * </p>
     * 
     * <p>
     * Este constructor requerira todos los parametros para inicializar un objeto estilo.
     * </p>
     * 
     * @param id                 el id de la linea de la BD con ese registro
     * @param estilo 			el nombre del estilo que queremos representar. 
     *
     */
	public Estilo(int id, String estilo) {
		super();
		this.id = id;
		this.estilo = estilo;
	}

	/**
     * <p>
     * Constructor Vacio
     * </p>
     * 
     * <p>
     * Este constructor no requerira ninguno de los parametros para inicializar un
     * objeto disco. tendra los valores definidos a 0 en casos
     * numericos y a cadena vacia "" en caso de los strings
     * </p>
     */
	public Estilo() {
		super();
		this.id = 0;
		this.estilo = "";
	}

	/**
	 * Obtiene el identificador de este objeto.
	 * 
	 * @return el identificador del estilo
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece un nuevo identificador a este objeto
	 * 
	 * @param id el nuevo identificador que queramos asignarle
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del estilo.
	 * 
	 * @return el numbre asignado al estilo.
	 */
	public String getEstilo() {
		return estilo;
	}

	/**
	 * Establece un nuevo nombre de estilo a este objeto
	 * 
	 * @param estilo nombre del estilo.
	 */
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	/**
     * Devuelve una representación en forma de cadena de este objeto Estilo.
     * 
     * @return Una cadena que representa este objeto Estilo, incluyendo su ID y nombre de estilo.
     */
	@Override
	public String toString() {
		return "Estilo [id=" + id + "]";
	}
	

}

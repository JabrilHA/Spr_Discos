package com.ipartek.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * <p>
 * Clase Disco
 * </p>
 * 
 * <p>
 * Esta clase generara una tabla discos dentro de la BD. lo hara de manera
 * automatica, haciendi uso de JPA (Hibernate)
 * </p>
 */
@Entity
@Table(name = "discos")
public class Disco {

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
     * Atributo nombre
     * </p>
     * 
     * <p>
     * Este atributo hace referencia al nombre del disco.
     * </p>
     */
	@Column(name = "nombre")
	private String nombre;
	
	/**
     * <p>
     * Atributo num_canciones
     * </p>
     * 
     * <p>
     * Este atributo nos muestra el numero de canciones que tiene el disco.
     * </p>
     */
	@Column(name = "num_canciones")
	private int num_canciones;
	
	/**
	 * <p>
	 * Atributo enlace_spotify
	 * </p>
	 * <p>
	 * Este atributo nos da un enlace a Spotifyque nos lleva al album de ese artista.
	 * </p>
	 */
	@Column(name="Enlace_spotify")
	private String enlace_spotify;
	
	/**
	 * <p>
	 * Atributo foto
	 * </p>
	 * <p>
	 * Este atributo no muestra el nombre de la imagen que se relaciona con ese disco.
	 * </p>
	 */
	@Column(name = "foto")
	private String foto;
	
	 /**
     * <p>
     * Atributo estilo
     * </p>
     * 
     * <p>
     * Este atributo es un objeto de tipo Estilo. Aqui almacenaremos el genero del disco.
     * </p>
     */
	@ManyToOne
	private Estilo estilo;

	 /**
     * <p>
     * Constructor completo
     * </p>
     * 
     * <p>
     * Este constructor requerira todos los parametros para inicializar un objeto disco.
     * </p>
     * 
     * @param id                 el id de la linea de la BD con ese registro
     * @param nombre 			el nombre del disco que se encuentra en la BD. 
     * @param num_canciones      el numero entero de canciones de ese disco que
     *                           tenemos.
     * @param enlace_spotify	la url a ese disco dentro de spotify.
     * @param foto				nombre de la foto con la cual se relaciona al disco.
     * @param estilo				un objeto de la clase Estilo. para mas info, ver la clase
     * 							Estilo.
     * 
     * @see Estilo
     */
	public Disco(int id, String nombre, int num_canciones, String enlace_spotify, String foto, Estilo estilo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.num_canciones = num_canciones;
		this.enlace_spotify = enlace_spotify;
		this.foto = foto;
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
     * 
     * @see Estilo
     */
	public Disco() {
		super();
		this.id = 0;
		this.nombre = "";
		this.num_canciones = 0;
		this.foto = "";
		this.enlace_spotify = "";
		this.estilo = new Estilo();
	}
	
	/**
	 * Obtiene el nombre de la foto de este disco.
	 * 
	 * @return el nombre de la foto de este objeto
	 */
	public String getFoto() {
		return foto;
	}
	
	/**
	 * Establece el nombre de la foto.
	 * 
	 * @param foto El nombre del nuevo nombre de la foto del disco.
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * Obtiene el identificador de ste disco.
	 * 
	 * @return el identificador del objeto.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Establece el nuevo id.
	 * 
	 * @param id El nuevo identificador que queremos asignarle al objeto
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Obtiene el nombre del disco.
	 * 
	 * @return el nombre del disco.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Establece un nuembo nombre para el disco. 
	 * 
	 * @param nombre El nuevo nombre que tendra el disco.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el numero de canciones que tien este disco.
	 * 
	 * @return numero de canciones del disco
	 */
	public int getNum_canciones() {
		return num_canciones;
	}

	/**
	 * Establece un nuevo numero de canciones al disco.
	 * 
	 * @param num_canciones el numero de canciones que queremos asignarle al disco.
	 */
	public void setNum_canciones(int num_canciones) {
		this.num_canciones = num_canciones;
	}

	/**
	 * Obtiene el objeto estilo asociado a este disco.
	 * 
	 * @return objeto estilo del disco
	 */
	public Estilo getEstilo() {
		return estilo;
	}
	
	/**
	 * Establece un nuevo objeto estilo al disco.
	 * 
	 * @param estilo el nuevo estilo que se le asignara a este disco
	 */
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	/**
	 * Obtiene una url que te lleva al disco en Spotify
	 * 
	 * @return url a Spotify
	 */
	public String getEnlace_spotify() {
		return enlace_spotify;
	}

	/**
	 * Establece una nueva url que te llevara a ese disco
	 * 
	 * @param enlace_spotify enlace a spotify nuevo para este disco
	 */
	public void setEnlace_spotify(String enlace_spotify) {
		this.enlace_spotify = enlace_spotify;
	}

	/**
     * Devuelve una representación en forma de cadena de este objeto Disco.
     * 
     * @return Una cadena que representa este objeto Disco, incluyendo su ID, nombre, numero de canciones,
     * enlace a spotify, foto y estilo.
     */
	@Override
	public String toString() {
		return "Disco [id=" + id + ", nombre=" + nombre + ", num_canciones=" + num_canciones + ", enlace_spotify="
				+ enlace_spotify + ", foto=" + foto + ", estilo=" + estilo + "]";
	}

	


	
	
}

package com.ipartek.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.ipartek.messages.GestorMensajes;
import com.ipartek.model.Disco;
import com.ipartek.model.Estilo;
import com.ipartek.service.IDiscoService;
import com.ipartek.service.IEstiloService;

import jakarta.servlet.http.HttpSession;

@Controller
public class GestionController {

	@Autowired
	private IDiscoService discoService;
	
	@Autowired
	private IEstiloService estiloService;
	
	/**
	 * Funcion que nos permite guardar un disco nuevo en la base de datos.
	 * 
	 * Tras redirigir a localhost:8080/guardarDisco llevara a esta pagina 
	 * 
	 * @param objeto_entidad el objeto para rellenar el formulario
	 * @param file objeto de tipo archivo que nos permite gestionarlo para guardarlo en una ruta local.
	 * @param model atributos del modelo de datos para tener acceso a los atributos 
	 * @param session crea una sesion donde se guardan objetos que podemos mostrar o eliminar.
	 * @return tras hacerlo va a "admin.html"
	 */
	@RequestMapping("/guardarDisco")
	public String guardarDisco(@ModelAttribute @Validated Disco objeto_entidad, BindingResult result ,
			@RequestParam("foto") MultipartFile file, Model model,HttpSession session) {
		
		String rutaDeGuardado ="C:\\Users\\Jabril\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\Spr_Discos\\src\\main\\resources\\static\\images\\discos";
		
		File directorio = new File(rutaDeGuardado);
		if (!directorio.exists()) {
			directorio.mkdirs();
		}

		try {
			String nombreArchivo = file.getOriginalFilename();
			File archivo = new File(rutaDeGuardado + "//" + nombreArchivo);
			file.transferTo(archivo);
			objeto_entidad.setFoto(nombreArchivo);
			discoService.guardarDisco(objeto_entidad);
			
		} catch (IOException e) {
			System.out.println("ERROR: fallo al manejar el file");
		}
		GestorMensajes.ponerMensaje(3, session);
		List<Estilo> listaEstilos = estiloService.ObtenerTodosEstilos();
		model.addAttribute("art_listaEstilos", listaEstilos);
		model.addAttribute("objeto_entidad", new Disco());

		return "/admin";
	}
	
	/**
	 * Funcion que nos permite guardar una copia de seguridad de la base de datos.
	 * 
	 * Tras redirigir a localhost:8080/crear_copia llevara a esta pagina 
	 * 
	 * @param model atributos del modelo de datos para tener acceso a los atributos 
	 * @param session crea una sesion donde se guardan objetos que podemos mostrar o eliminar.
	 * @return tras hacerlo va a "admin.html"
	 */
	@RequestMapping("/crear_copia")
	public String crear_copia(Model model,HttpSession session) {
		
		List<Disco> listaDiscos= discoService.obtenerTodosDiscos();
		
		Gson gson = new Gson();
		
		String copiaJson = gson.toJson(listaDiscos);
		
		 try {
			FileWriter file = new FileWriter("C:\\CopiaSeguridad\\copiaJSON.json");
			file.write(copiaJson);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		 GestorMensajes.ponerMensaje(1, session);
		 model.addAttribute("objeto_entidad", new Disco());
		List<Estilo> listaEstilos = estiloService.ObtenerTodosEstilos();
		
		model.addAttribute("art_listaEstilos", listaEstilos);
		
		return "/admin";
	}
	
	/**
	 * Funcion que nos lleva a una pagina para modificar un disco que se encuentra en la BD.
	 * 
	 * Tras redirigir a localhost:8080/modificarDisco/"id del disco" llevara a esta pagina 
	 * 
	 * @param model atributos del modelo de datos para tener acceso a los atributos 
	 * @param id atributo que recogemos de la url el cual nos indica el id del objeto a modificar.
	 * @return tras hacerlo va a "modificar.html"
	 */
	@RequestMapping("/modificarDisco/{id}")
	public String modificarDisco(Model model,@PathVariable int id) {
		Optional<Disco> disco = discoService.buscarDiscoPorId(id);
		List<Estilo> listaEstilos = estiloService.ObtenerTodosEstilos();
		
		model.addAttribute("atr_listaEstilos", listaEstilos);
		model.addAttribute("disco", disco);
			
		return "/modificar";
	}
	
	/**
	 * Funcion que nos permite modificar un disco que se encuentra en la BD.
	 * 
	 * Tras redirigir a localhost:8080/modificacionDiscoCreado llevara a esta pagina 
	 * 
	 * @param objeto_entidad el objeto para rellenar el formulario
	 * @param session crea una sesion donde se guardan objetos que podemos mostrar o eliminar.
	 * @return tras hacerlo va a "modificar.html"
	 */
	@RequestMapping("/modificacionDiscoCreado")
	public String modificacionProductoCreada(@ModelAttribute Disco objeto_entidad,HttpSession session) {
		discoService.guardarDisco(objeto_entidad);
		int id = objeto_entidad.getId();
		GestorMensajes.ponerMensaje(4, session);
		
		return "redirect:/modificarDisco/" + id;
	}
	
	/**
	 * Funcion que nos permite eliminar un disco de la base de datos.
	 * 
	 * Tras redirigir a localhost:8080/crear_copieliminarDisco/"id disco" llevara a esta pagina 
	 * 
	 * @param id atributo que recogemos de la url el cual nos indica el id del objeto a eliminar.
	 * @param model atributos del modelo de datos para tener acceso a los atributos 
	 * @param session crea una sesion donde se guardan objetos que podemos mostrar o eliminar.
	 * @return tras hacerlo va a "home.html"
	 */
	@RequestMapping("/eliminarDisco/{id}")
	public String eliminarDisco(@PathVariable int id, Model model,HttpSession session) {
		discoService.eliminarDisco(id);
		
		GestorMensajes.ponerMensaje(2, session);
		List<Disco> listaDiscos = discoService.obtenerTodosDiscos();
		model.addAttribute("art_listaDiscos", listaDiscos);
		return "/home";
	}
}

package com.ipartek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.messages.GestorMensajes;
import com.ipartek.model.Disco;
import com.ipartek.model.Estilo;
import com.ipartek.service.IDiscoService;
import com.ipartek.service.IEstiloService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MenuController {
	@Autowired
	private IDiscoService discoService;
	
	@Autowired
	private IEstiloService estiloService;
	
	/**
	 * Pagina de home de  la pagina web.
	 * 
	 * Tras redirigir a localhost:8080/menu_home llevara a esta pagina 
	 * 
	 * @param model atributos del modelo de datos para tener acceso a los atributos 
	 * @param session crea una sesion donde se guardan objetos que podemos mostrar o eliminar.
	 * @return tras hacerlo va a "home.html"
	 */
	@RequestMapping("/menu_home")
	public String menuHome(Model model,HttpSession session) {
		GestorMensajes.borrarMensaje(session);
		List<Disco> listaDiscos = discoService.obtenerTodosDiscos();
		model.addAttribute("art_listaDiscos", listaDiscos);
		
		return "/home";
	}
	/**
	 * Pagina de Administracion de  la pagina web.
	 * 
	 * Taras redirigir a localhost:8080/menu_admin llevara a esta pagina 
	 * 
	 * @param model atributos del modelo de datos para tener acceso a los atributos 
	 * @param session crea una sesion donde se guardan objetos que podemos mostrar o eliminar.
	 * @return tras hacerlo va a "admin.html"
	 */
	@RequestMapping("/menu_admin")
	public String menuAdmin(Model model,HttpSession session) {
		GestorMensajes.borrarMensaje(session);
		List<Estilo> listaEstilos = estiloService.ObtenerTodosEstilos();
	
		model.addAttribute("art_listaEstilos", listaEstilos);
		model.addAttribute("objeto_entidad", new Disco());
		return "/admin";
	}

	
}

package com.ipartek.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.messages.GestorMensajes;
import com.ipartek.model.Disco;
import com.ipartek.service.IDiscoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@Autowired
	private IDiscoService discoService;
	
	/**
	 * Pagina de inicio de  la pagina web.
	 * 
	 * Tras redirigir a localhost:8080 llevara a esta pagina 
	 * 
	 * @param model atributos del modelo de datos para tener acceso a los atributos 
	 * @param session crea una sesion donde se guardan objetos que podemos mostrar o eliminar.
	 * @return tras hacerlo va a "home.html"
	 */
	@RequestMapping("/")
	public String cargarInicio(Model model,HttpSession session) {
		GestorMensajes.borrarMensaje(session);
		List<Disco> listaDiscos = discoService.obtenerTodosDiscos();
		model.addAttribute("art_listaDiscos", listaDiscos);
		return "/home";
	}

}

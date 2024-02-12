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
	
	@RequestMapping("/menu_home")
	public String menuHome(Model model,HttpSession session) {
		GestorMensajes.borrarMensaje(session);
		List<Disco> listaDiscos = discoService.obtenerTodosDiscos();
		model.addAttribute("art_listaDiscos", listaDiscos);
		
		return "/home";
	}
	
	@RequestMapping("/menu_admin")
	public String menuAdmin(Model model,HttpSession session) {
		GestorMensajes.borrarMensaje(session);
		List<Estilo> listaEstilos = estiloService.ObtenerTodosEstilos();
	
		model.addAttribute("art_listaEstilos", listaEstilos);
		model.addAttribute("objeto_entidad", new Disco());
		return "/admin";
	}

	
}

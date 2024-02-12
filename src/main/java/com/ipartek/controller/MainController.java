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
	
	@RequestMapping("/")
	public String cargarInicio(Model model,HttpSession session) {
		GestorMensajes.borrarMensaje(session);
		List<Disco> listaDiscos = discoService.obtenerTodosDiscos();
		model.addAttribute("art_listaDiscos", listaDiscos);
		return "/home";
	}

}

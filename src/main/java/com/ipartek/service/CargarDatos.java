package com.ipartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.model.Disco;
import com.ipartek.model.Estilo;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class CargarDatos {

	@Autowired
	IEstiloService estiloService;
	
	@Autowired
	IDiscoService discoService;
	
	@PostConstruct
	@Transactional
	public void cargarDatos() {
		Estilo pop = new Estilo(1, "Pop");
		Estilo rock = new Estilo(2, "Rock");
		Estilo reagge = new Estilo(3, "Reagge");
		Estilo punk = new Estilo(4, "Punk");
		Estilo metal = new Estilo(5, "Metal");
		
		estiloService.insertarEstilo(pop);
		estiloService.insertarEstilo(rock);
		estiloService.insertarEstilo(reagge);
		estiloService.insertarEstilo(punk);
		estiloService.insertarEstilo(metal);
		
		discoService.guardarDisco(new Disco(1,"Rhythm of the Night", 12, "https://open.spotify.com/intl-es/album/6rrPmmb2lQd5pNRL6HKBZx?si=sAbIhGOIQnSJVTDdjThHZQ", "Rhythm_of_the Night.jpg", pop));
		discoService.guardarDisco(new Disco(2,"Midnight Grooves", 10, "https://open.spotify.com/intl-es/album/3nPYyRchy03yFEMP5uN35g?si=-zWOGxeCTDOIgG9cqZPT7A", "Midnight_Grooves.jpg", rock));
		discoService.guardarDisco(new Disco(3,"Soulful Serenade", 15, "https://open.spotify.com/intl-es/album/3L9yVSvfZjMNBhnKp0L35S?si=bY4FBFcqTu-M20k9i6NFKg", "Soulful_Serenade.jpg", reagge));
		discoService.guardarDisco(new Disco(4,"Electric Dreams", 8, "https://open.spotify.com/intl-es/album/4xPtjzhIRegrGYBh8C41Ak?si=8BaICtY8TCikZ_kHJVHoig", "Electric_Dreams.jpg", pop));
		discoService.guardarDisco(new Disco(5,"Funky Junction", 11, "https://open.spotify.com/intl-es/album/6XJlqdGd76ykGuBJEBHch6?si=RNmLJVJQS-Otp4L0lNM_fw", "Funky_Junction.jpg", rock));
		discoService.guardarDisco(new Disco(6,"Smooth Sailing", 14, "https://open.spotify.com/intl-es/album/1k28WBci9JPB2zCTplu2GJ?si=p74IF86_TmuvP6-tcDYJ4w", "Smooth_Sailing.jpg", reagge));
		discoService.guardarDisco(new Disco(7,"Urban Grooves", 9, "https://open.spotify.com/intl-es/album/49doUc1VlatJeAX2jeAtxg?si=tJXCrb13Q1G6qKlc1HnkHQ", "Urban_Grooves.jpg", pop));

		
		
	}
	
}

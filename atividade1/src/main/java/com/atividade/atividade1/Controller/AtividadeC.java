package com.atividade.atividade1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Atividade")


public class AtividadeC {
	
	@GetMapping("/habilidades")
	public String ativadade1() {
		return " Atenção aos detalhes, Pesistencia";
	}

	@GetMapping("/objetivos")
	public String ativadade2() {
		return " Desenvolver todas as atividades de Spring Boot";
}
}

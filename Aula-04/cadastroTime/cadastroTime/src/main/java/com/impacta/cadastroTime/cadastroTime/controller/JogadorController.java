package com.impacta.cadastroTime.cadastroTime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.impacta.cadastroTime.cadastroTime.model.Jogador;

@Controller
public class JogadorController {

	@GetMapping("/cadastroJogadorRota")//Rota
	public String cadastroJogadorGet() {
		return "cadastroJogador";//Arquivo HTML
	}
	
	@PostMapping("/cadastroJogadorRota")
	public String cadastroJogadorPost(Jogador jogador) {
		
		System.out.println(jogador.getNome());
		System.out.println(jogador.getTime());
		return "index";
	}
	
	
}

package com.impacta.cadastroTime.cadastroTime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.impacta.cadastroTime.cadastroTime.model.Jogador;
import com.impacta.cadastroTime.cadastroTime.repository.JogadorRepository;

@Controller
public class JogadorController {
	
	@Autowired
	JogadorRepository jogadorRepository;

	@GetMapping("/cadastroJogadorRota")//Rota
	public String cadastroJogadorGet() {
		return "cadastroJogador";//Arquivo HTML
	}
	
	@PostMapping("/cadastroJogadorRota")
	public String cadastroJogadorPost(Jogador jogador) {
		jogadorRepository.save(jogador);
		return "index";
	}
	
	@GetMapping("/listarJogaresRota")//Rota
	public ModelAndView listarJogadores() {
		//Iniciando o objeto já com o nome do ARQUIVO HTML
		ModelAndView modelAndViewJogador = new ModelAndView("listarJogadores");
		List<Jogador>jogadoresLista = (List)jogadorRepository.findAll();
		
		return modelAndViewJogador;
	}
	
	
	
	
}

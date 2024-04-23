package apiaut.apiaut.controller;

import apiaut.apiaut.model.Autenticacao;
import apiaut.apiaut.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacaoController {

    @Autowired
    AutenticacaoService autenticacaoService;


    @PostMapping("/gerarToken")
    public Autenticacao gerarToken(@RequestBody Autenticacao autenticacao){
        return autenticacaoService.gerarToken(autenticacao);
    }


    @PostMapping("/validarToken")
    public String validarToken(@RequestBody Autenticacao autenticacao){
        if(autenticacaoService.validaAut(autenticacao)){
            return "Token Valido";

        }
        return "Token Invalido";
    }
}

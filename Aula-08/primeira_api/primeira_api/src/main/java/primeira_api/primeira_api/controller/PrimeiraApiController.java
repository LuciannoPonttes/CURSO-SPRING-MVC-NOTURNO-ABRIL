package primeira_api.primeira_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import primeira_api.primeira_api.model.MeuPrimeroPost;
import primeira_api.primeira_api.repository.MeuPrimeiroTextoRepository;

@RestController
public class PrimeiraApiController {


    @Autowired
    MeuPrimeiroTextoRepository meuPrimeiroTextoRepository;

    @GetMapping("/meuPrimeiroGet") // Isso é um endpoint
    public String meuPrimeiroGet(){

        return "Esse é o seu primeiro get na API";


    }

    @CrossOrigin(origins = "*")
    @PostMapping("/meuPrimeiroPostRota") // Isso é um endpoint
    public String meuPrimeiroPost(@RequestBody MeuPrimeroPost meuPrimeroPost){

        meuPrimeiroTextoRepository.save(meuPrimeroPost);

        return "O texto enviado foi:" + meuPrimeroPost.getMeuTexto();

    }



}




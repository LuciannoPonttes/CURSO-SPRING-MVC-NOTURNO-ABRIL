package revisao_api.revisao_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revisao_api.revisao_api.exception.ResourceNotFoundException;
import revisao_api.revisao_api.model.PessoaModel;
import revisao_api.revisao_api.repository.PessoaRepository;

import java.util.List;

@RestController
public class PessoaController {


    @Autowired
    PessoaRepository pessoaRepository;


    @PostMapping("/cadastroPessoaRota")
    public String cadastroPessoa(@RequestBody PessoaModel pessoaModel){

        pessoaRepository.save(pessoaModel);

        return "A pessoa "+pessoaModel.getNome()+ " foi cadastrada";
    }

    @GetMapping("/listarPessoasRota")
    public List<PessoaModel> listarPessoas(){

        return (List) pessoaRepository.findAll();
    }

    @GetMapping("/PessoaRota/{id}")
    public ResponseEntity<PessoaModel> buscarUsuarioPeloID(@PathVariable(value = "id") long pessoaId)
            throws ResourceNotFoundException {
        PessoaModel pessoaModel =
                pessoaRepository
                        .findById(pessoaId) // busca a pessoa
                        //Caso não encontre, ele entra na exeption
                        .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + pessoaId));

        return ResponseEntity.ok().body(pessoaModel);
    }

    @DeleteMapping( "/PessoaRota/{id}")
    public String deletarPessoa(@PathVariable(value = "id") long pessoaId)
          throws ResourceNotFoundException {
            PessoaModel pessoaModel =
                    pessoaRepository
                            .findById(pessoaId) // busca a pessoa
                            //Caso não encontre, ele entra na exeption
                            .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + pessoaId));
                            pessoaRepository.delete(pessoaModel);
            return pessoaModel.getNome() + "Deletado";
    }

    @PutMapping( "/PessoaRota/")
    public String alterarPessoa(@RequestBody PessoaModel pessoaModelRequest)
            throws ResourceNotFoundException {
        PessoaModel pessoaModel =
                pessoaRepository
                        .findById(pessoaModelRequest.getId()) // busca a pessoa
                        //Caso não encontre, ele entra na exeption
                        .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + pessoaModelRequest.getId()));


        pessoaRepository.save(pessoaModelRequest);
        return pessoaModelRequest.getNome() + " Foi Alterado";
    }


}

package apiacessobancodados.apiacessobancodados.controller;

import apiacessobancodados.apiacessobancodados.exception.ResourceNotFoundException;
import apiacessobancodados.apiacessobancodados.model.Usuario;
import apiacessobancodados.apiacessobancodados.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/crudUsuario")
    public String cadastrarUsuario(@RequestBody Usuario usuario){

        usuarioRepository.save(usuario);
        return "Usuario cadastrado com sucesso";

    }

    @GetMapping("/crudUsuario/{cpf}")
    public ResponseEntity<Usuario> cadastrarUsuario(@PathVariable String cpf) throws ResourceNotFoundException {
            Usuario usuario =
                    usuarioRepository
                            .findByCpf(cpf)
                            .orElseThrow(() -> new ResourceNotFoundException("Usuario: " + cpf));
            return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuario()  {
        return (List )usuarioRepository.findAll();
    }




}

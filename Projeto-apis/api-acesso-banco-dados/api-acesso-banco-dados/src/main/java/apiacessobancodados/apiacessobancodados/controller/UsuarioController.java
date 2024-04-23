package apiacessobancodados.apiacessobancodados.controller;

import apiacessobancodados.apiacessobancodados.exception.ResourceNotFoundException;
import apiacessobancodados.apiacessobancodados.model.Usuario;
import apiacessobancodados.apiacessobancodados.repository.UsuarioRepository;
import apiacessobancodados.apiacessobancodados.security.AutenticacaoClient;
import apiacessobancodados.apiacessobancodados.security.AutenticacaoService;
import apiacessobancodados.apiacessobancodados.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AutenticacaoService autenticacaoService;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/crudUsuario")
    public String cadastrarUsuario(@RequestBody Usuario usuario,
                                   @RequestHeader String authorization, @RequestHeader String xcsrfToken){
        if (autenticacaoService.validaHeaders(authorization,xcsrfToken)){
            usuario.setSenha(usuarioService.retornaSenhaCript(usuario.getSenha()));
            usuarioRepository.save(usuario);
            return "Usuario cadastrado com sucesso";

        }else
            return "Erro ao autenticar na api de autenticação, verifique os headers";

    }

    @GetMapping("/crudUsuario/{cpf}")
    public ResponseEntity<Usuario> cadastrarUsuario(@PathVariable String cpf,
                                                    @RequestHeader String authorization, @RequestHeader String xcsrfToken) throws ResourceNotFoundException {
        if (autenticacaoService.validaHeaders(authorization,xcsrfToken)){
            Usuario usuario =
                    usuarioRepository
                            .findByCpf(cpf)
                            .orElseThrow(() -> new ResourceNotFoundException("Usuario de " + cpf + "Não Existe"));
            return ResponseEntity.ok().body(usuario);
        }else
            return ResponseEntity.ok().body(null);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuario(@RequestHeader String authorization, @RequestHeader String xcsrfToken)  {

        if (autenticacaoService.validaHeaders(authorization,xcsrfToken)){
            return (List )usuarioRepository.findAll();
        }
            return null;

    }




}

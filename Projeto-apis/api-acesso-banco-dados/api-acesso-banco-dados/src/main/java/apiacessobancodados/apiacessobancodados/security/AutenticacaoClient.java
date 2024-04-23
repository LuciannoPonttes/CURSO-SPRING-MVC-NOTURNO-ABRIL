package apiacessobancodados.apiacessobancodados.security;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "aut", url="localhost:7777")
public interface AutenticacaoClient {

    @PostMapping("/validarToken")
    String validarToken(@RequestBody Autenticacao autenticacao);
}

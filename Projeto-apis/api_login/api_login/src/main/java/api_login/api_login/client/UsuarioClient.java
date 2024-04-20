package api_login.api_login.client;

import api_login.api_login.response.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "usuario", url = "localhost:8080")
public interface UsuarioClient {

    @GetMapping("/crudUsuario/{cpf}")
    ResponseEntity<UsuarioResponse> getUsuario(@PathVariable String cpf);
}

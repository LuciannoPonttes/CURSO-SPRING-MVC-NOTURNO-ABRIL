package api_login.api_login.controller;

import api_login.api_login.request.UsuarioRequest;
import api_login.api_login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;
    @PostMapping("/logar")
    public String logar(@RequestBody UsuarioRequest usuarioRequest){
        return loginService.validarLogin(usuarioRequest);
    }
}

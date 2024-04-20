package api_login.api_login.service;

import api_login.api_login.client.CripClient;
import api_login.api_login.client.UsuarioClient;
import api_login.api_login.request.SenhaRequestDecrypt;
import api_login.api_login.request.UsuarioRequest;
import api_login.api_login.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UsuarioClient usuarioClient;
    @Autowired
    CripClient cripClient;

    SenhaRequestDecrypt senhaRequestDecrypt = new SenhaRequestDecrypt();


    public String validarLogin(UsuarioRequest usuarioRequest){

        UsuarioResponse usuarioResponse = usuarioClient.getUsuario(usuarioRequest.getCpf()).getBody();
        senhaRequestDecrypt.setSenhaRequestDecrypt(usuarioResponse.getSenha());
        String senhaDecript = cripClient.getSenhaDecrypt(senhaRequestDecrypt);

        if(!validaSenha(usuarioRequest.getSenha(), senhaDecript))
            return "Senha do Usuario Invalida";

        return "Usuario Autenticado";
    }

    public boolean validaSenha(String senhaEnviada,String senhaRegistrada){

        if(senhaEnviada.equals(senhaRegistrada))
            return true;
        else
            return false;
    }
}

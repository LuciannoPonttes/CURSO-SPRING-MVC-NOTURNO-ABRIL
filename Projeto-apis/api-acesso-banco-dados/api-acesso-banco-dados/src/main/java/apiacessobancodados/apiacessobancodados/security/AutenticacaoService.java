package apiacessobancodados.apiacessobancodados.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    AutenticacaoClient autenticacaoClient;
    private Autenticacao autenticacao = new Autenticacao();

    public boolean validaHeaders(String authorization,String xcsrfToken ){

        autenticacao.setAuthorization(authorization);
        autenticacao.setXcsrfToken(xcsrfToken);

        if(autenticacaoClient.validarToken(autenticacao).equals("Token Valido")){
            return true;
        }

        return false;
    }



}

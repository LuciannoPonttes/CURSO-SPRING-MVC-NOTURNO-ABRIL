package apiaut.apiaut.service;

import apiaut.apiaut.model.Autenticacao;
import apiaut.apiaut.repository.AutenticacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class AutenticacaoService {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TOKEN_LENGTH = 50;

    private static final int TOKEN_LENGTH2 = 25;

    private Autenticacao autenticacaoValida = new Autenticacao();

    @Autowired
    AutenticacaoRepository autenticacaoRepository;

    public Autenticacao gerarToken(Autenticacao autenticacao){

        if(validaAut(autenticacao)){
            autenticacaoValida.setXcsrfToken(gerarXcsrfToken());
            autenticacaoValida.setAuthorization(gerarAuthorization());
            autenticacaoRepository.save(autenticacaoValida);
        }

        return autenticacaoValida;
    }

    public boolean validaAut(Autenticacao autenticacao){

        Autenticacao autenticacaoEncontrada = autenticacaoRepository.findByAuthorization(autenticacao.getAuthorization());

        if ( autenticacaoEncontrada != null){
            if(autenticacaoEncontrada.getXcsrfToken().equals(autenticacao.getXcsrfToken())){
                return true;
            }
            return false;
        }else
            return false;
    }

    public static String gerarXcsrfToken() {
        SecureRandom random = new SecureRandom();
        StringBuilder token = new StringBuilder(TOKEN_LENGTH);
        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            token.append(CHARACTERS.charAt(randomIndex));
        }
        return token.toString();
    }

    public static String gerarAuthorization() {
        SecureRandom random = new SecureRandom();
        StringBuilder token = new StringBuilder(TOKEN_LENGTH);
        for (int i = 0; i < TOKEN_LENGTH2; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            token.append(CHARACTERS.charAt(randomIndex));
        }
        return token.toString();
    }


}

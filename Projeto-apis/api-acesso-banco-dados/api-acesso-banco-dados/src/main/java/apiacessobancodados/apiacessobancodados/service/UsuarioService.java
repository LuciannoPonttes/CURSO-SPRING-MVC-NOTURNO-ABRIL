package apiacessobancodados.apiacessobancodados.service;


import apiacessobancodados.apiacessobancodados.client.CriptografiaClient;
import apiacessobancodados.apiacessobancodados.request.SenhaRequestEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private CriptografiaClient criptografiaClient;

    private SenhaRequestEncrypt senhaRequestEncrypt = new SenhaRequestEncrypt();

    public String retornaSenhaCript(String senha){

        senhaRequestEncrypt.setSenhaRequestEncrypt(senha);

        return criptografiaClient.criptografar(senhaRequestEncrypt);
    }



}

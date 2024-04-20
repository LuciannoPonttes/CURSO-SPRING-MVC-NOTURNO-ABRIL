package apicriptografia.apicriptografia.controller;


import apicriptografia.apicriptografia.request.SenhaRequestDecrypt;
import apicriptografia.apicriptografia.request.SenhaRequestEncrypt;
import apicriptografia.apicriptografia.service.SenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SenhaController {

        @Autowired
        SenhaService senhaService;
        @PostMapping("/criptografar")
        public String criptografar (@RequestBody SenhaRequestEncrypt senhaRequestEncrypt){
            return senhaService.encrypt(senhaRequestEncrypt.getSenhaRequestEncrypt());

        }
        @PostMapping("/descriptografar")
        public String descriptografar (@RequestBody SenhaRequestDecrypt senhaRequestDecrypt){
                return senhaService.decrypt(senhaRequestDecrypt.getSenhaRequestDecrypt());

        }
}

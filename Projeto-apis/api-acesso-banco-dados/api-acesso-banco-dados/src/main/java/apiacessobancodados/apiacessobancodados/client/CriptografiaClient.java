package apiacessobancodados.apiacessobancodados.client;

import apiacessobancodados.apiacessobancodados.request.SenhaRequestEncrypt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "cript", url = "localhost:9000")
public interface CriptografiaClient {
    @PostMapping("/criptografar")
    String criptografar (@RequestBody SenhaRequestEncrypt senhaRequestEncrypt);
}

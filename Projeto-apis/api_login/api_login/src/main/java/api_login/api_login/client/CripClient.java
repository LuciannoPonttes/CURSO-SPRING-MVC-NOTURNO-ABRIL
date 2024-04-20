package api_login.api_login.client;

import api_login.api_login.request.SenhaRequestDecrypt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value= "cript", url = "localhost:9000")
public interface CripClient {

    @PostMapping("/descriptografar")
    String getSenhaDecrypt(@RequestBody SenhaRequestDecrypt senhaRequestEncrypt);

}

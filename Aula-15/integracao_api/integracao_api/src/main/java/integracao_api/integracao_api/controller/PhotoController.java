package integracao_api.integracao_api.controller;

import integracao_api.integracao_api.client.PhotoClient;
import integracao_api.integracao_api.response.PhotoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotoController {

    @Autowired
    PhotoClient photoClient;

    @GetMapping("/foto/{id}")
    public PhotoResponse buscarFotoPeloID(@PathVariable("id") Long id){
        return this.photoClient.getPhoto(id);
    }

    @GetMapping("/fotos")
    public List<PhotoResponse> buscarTodasFotos(){
        return  this.photoClient.getPhotos();
    }
}

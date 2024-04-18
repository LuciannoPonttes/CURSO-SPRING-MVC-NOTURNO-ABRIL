package integracao_api.integracao_api.client;

import integracao_api.integracao_api.response.PhotoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "photo-client", url="https://jsonplaceholder.typicode.com")
//Consumidor
public interface PhotoClient {

    @GetMapping("/photos/{id}")
    PhotoResponse getPhoto(@PathVariable("id") Long id);

    @GetMapping("/photos")
    List<PhotoResponse> getPhotos();

}

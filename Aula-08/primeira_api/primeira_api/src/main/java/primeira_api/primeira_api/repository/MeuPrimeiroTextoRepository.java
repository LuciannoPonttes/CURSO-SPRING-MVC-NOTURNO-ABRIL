package primeira_api.primeira_api.repository;

import org.springframework.data.repository.CrudRepository;
import primeira_api.primeira_api.model.MeuPrimeroPost;

public interface MeuPrimeiroTextoRepository  extends CrudRepository<MeuPrimeroPost, String> {


}

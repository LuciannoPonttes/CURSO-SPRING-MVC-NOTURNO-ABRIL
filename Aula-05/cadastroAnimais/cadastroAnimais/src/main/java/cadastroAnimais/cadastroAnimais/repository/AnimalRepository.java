package cadastroAnimais.cadastroAnimais.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cadastroAnimais.cadastroAnimais.model.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, String> {

}

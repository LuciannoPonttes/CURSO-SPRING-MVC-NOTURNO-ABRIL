package cadastroAnimais.cadastroAnimais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import cadastroAnimais.cadastroAnimais.model.Animal;
import cadastroAnimais.cadastroAnimais.repository.AnimalRepository;


@Controller
public class AnimalController {
	
	@Autowired // Instancia o objeto sempre que ele é chamado
	AnimalRepository animalRepository;
	
	
	@GetMapping("/animalForm")
	public String animalFormularioGet() {
		return "cadastroAnimal";
	}
	
	@PostMapping("/animalForm")
	public String animalFormularioPost(Animal animal) {
		
		animalRepository.save(animal);// Chama o metodo salvar do repositorio
		
		return "cadastroAnimal";
	}
	
}

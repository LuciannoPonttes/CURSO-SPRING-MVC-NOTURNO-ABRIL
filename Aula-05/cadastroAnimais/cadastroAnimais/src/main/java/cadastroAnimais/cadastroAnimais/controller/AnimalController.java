package cadastroAnimais.cadastroAnimais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/listaAnimaisRota")
	public ModelAndView listarAnimais(){
		ModelAndView animalMV = new ModelAndView("listaAnimais");
		List<Animal> listaAnimais = (List<Animal>) animalRepository.findAll();
		
		animalMV.addObject("animais", listaAnimais);
		
		
		return animalMV;
	}
	
	@RequestMapping("/deletar")
	public String deletarAnimal(long id) {
		
		//Encontra o animal para deletar
		Animal animal = animalRepository.findById(id);
		
		//Deleta o animal da base de dados
		animalRepository.delete(animal);
		
		//Direciono para a lista
		return"redirect:/listaAnimaisRota";
		
	}
	
	
	
}

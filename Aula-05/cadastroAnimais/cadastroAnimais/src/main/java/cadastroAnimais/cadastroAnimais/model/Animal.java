package cadastroAnimais.cadastroAnimais.model;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id // Chave Primaria 
	@GeneratedValue(strategy = GenerationType.AUTO) // Informa que vai gerar automatico
	private long id;
	
	private String nome;
	private String raca;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	
	

}

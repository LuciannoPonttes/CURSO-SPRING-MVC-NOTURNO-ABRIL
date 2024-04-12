package primeira_api.primeira_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MeuPrimeroPost {
    private String meuTexto;//Atributo chamado meu texto
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Informa que vai gerar automatico
    private long id;

    public String getMeuTexto() {
        return meuTexto;
    }

    public void setMeuTexto(String meuTexto) {
        this.meuTexto = meuTexto;
    }
}

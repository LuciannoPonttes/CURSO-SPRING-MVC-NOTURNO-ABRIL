package apiaut.apiaut.repository;

import apiaut.apiaut.model.Autenticacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutenticacaoRepository extends JpaRepository<Autenticacao, Long> {

    Autenticacao findByAuthorization(String authorization);

}

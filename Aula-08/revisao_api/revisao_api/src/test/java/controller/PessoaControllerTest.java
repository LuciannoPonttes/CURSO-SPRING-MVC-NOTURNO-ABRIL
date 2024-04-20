package controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import revisao_api.revisao_api.controller.PessoaController;
import revisao_api.revisao_api.exception.ResourceNotFoundException;
import revisao_api.revisao_api.model.PessoaModel;
import revisao_api.revisao_api.repository.PessoaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaControllerTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaController pessoaController;


    //Teste do endpoint e buscar usuario pelo id, quando ele existe.
    @Test
    public void buscarUsuarioPeloIdTest_SeExiste() throws ResourceNotFoundException{

        long idTeste = 103; //ID de teste

        //Pessoa que o teste esperar encontrar

        PessoaModel pessoaModelEsperadoTeste = new PessoaModel();
        pessoaModelEsperadoTeste.setId(103);
        pessoaModelEsperadoTeste.setNome("UsuarioTeste");
        pessoaModelEsperadoTeste.setEmail("UsuarioTeste@gmail.com");
        pessoaModelEsperadoTeste.setCpf("999.999.999-99");


        //Simular a chamada do metodo findById
        when(pessoaRepository.findById(idTeste)).thenReturn(Optional.of(pessoaModelEsperadoTeste));

        //Chama o Controller passando o ID
        ResponseEntity<PessoaModel> response = pessoaController.buscarUsuarioPeloID(idTeste);

        // Verifica o status code do response
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(pessoaModelEsperadoTeste, response.getBody());

    }


    @Test
    public void buscarUsuarioPeloIdTest_SeNaoExiste() throws ResourceNotFoundException{
        //ID simulado
        long idTeste = 999999;

        when(pessoaRepository.findById(idTeste)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            pessoaController.buscarUsuarioPeloID(idTeste);
        });

        assertEquals("Não existe pessoa com o ID: " + idTeste, exception.getLocalizedMessage());


    }
    @Test
    public void alterarPessoaTest_Correto() throws ResourceNotFoundException{
        long idTeste = 103; //ID de teste
        //É a pessoa esperada
        PessoaModel pessoaModelEsperadoTeste = new PessoaModel();
        pessoaModelEsperadoTeste.setId(103);
        pessoaModelEsperadoTeste.setNome("UsuarioTeste");
        pessoaModelEsperadoTeste.setEmail("UsuarioTeste@gmail.com");
        pessoaModelEsperadoTeste.setCpf("999.999.999-99");


        //Alteração
        PessoaModel pessoaModelEsperadoTesteAlterada = new PessoaModel();
        pessoaModelEsperadoTesteAlterada.setId(103);
        pessoaModelEsperadoTesteAlterada.setNome("UsuarioTesteAlterado");
        pessoaModelEsperadoTesteAlterada.setEmail("UsuarioTeste@gmail.com");
        pessoaModelEsperadoTesteAlterada.setCpf("999.999.999-99");

        when(pessoaRepository.findById(idTeste)).thenReturn(Optional.of(pessoaModelEsperadoTeste));

        String response  = pessoaController.alterarPessoa(pessoaModelEsperadoTesteAlterada);


        assertEquals("UsuarioTesteAlterado Foi Alterado", response );


    }
}

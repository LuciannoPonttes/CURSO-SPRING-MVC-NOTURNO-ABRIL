package integracao_api.integracao_api;

import integracao_api.integracao_api.client.PhotoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Para habilitar o comsumo de api
public class IntegracaoApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IntegracaoApiApplication.class, args);
	}

	@Autowired
	private PhotoClient photoClient;

	//apenas para teste e para vocês usarem para testar alguma coisa
	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.photoClient.getPhoto(3L));
	}
}

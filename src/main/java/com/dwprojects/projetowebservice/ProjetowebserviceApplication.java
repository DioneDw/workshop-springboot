package com.dwprojects.projetowebservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Webservice Store",
				version = "1.0",
				description = "Webservice REST criado para o modelo de uma loja (Store).",
				contact = @Contact(
						name = "Dione Evangelista",
						url = "https://github.com/DioneDw/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0.html"
				)
		),
		servers = {
				@Server(url = "http://localhost:8090", description = "Servidor Local"),
				@Server(url = "https://workshop-springboot-tqip.onrender.com", description = "Servidor Produção")
		}

)
public class ProjetowebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetowebserviceApplication.class, args);
	}

}

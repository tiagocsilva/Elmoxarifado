package br.com.elmoxarifado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElmoxarifadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElmoxarifadoApplication.class, args);
	}
}
/*
@Bean
public WebMcvConfigurer corsConfigurer() {
    return new ElmoxarifadoAdapter() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/funcionarios").allowedOrigins("*");
        }
    }
}*/

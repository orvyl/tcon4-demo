package com.orvyl.api;

import com.orvyl.api.model.Candidate;
import com.orvyl.api.model.Position;
import com.orvyl.api.repository.CandidateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Don't mind me! I will just put some initial data in the db para cool
	@Bean
	public CommandLineRunner initializeDatabase(CandidateRepository candidateRepository) {
		return args -> {
			Candidate presidentJohn = new Candidate("John", Position.PRESIDENT);
			Candidate presidentDoe = new Candidate("Doe", Position.PRESIDENT);

			Candidate vicePresidentErica = new Candidate("Erica", Position.VICE_PRESIDENT);
			Candidate vicePresidentKath = new Candidate("Kath", Position.VICE_PRESIDENT);

			Candidate museNadine = new Candidate("Nadine", Position.MUSE);

			candidateRepository.save(presidentJohn);
			candidateRepository.save(presidentDoe);
			candidateRepository.save(vicePresidentErica);
			candidateRepository.save(vicePresidentKath);
			candidateRepository.save(museNadine);
		};
	}

	@Configuration
	@EnableSwagger2
	public static class SwaggerConfiguration {

		@Bean
		public Docket apiDocument() {
			return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
		}

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/candidate/**").allowedOrigins("http://localhost:5000");
				registry.addMapping("/vote/**").allowedOrigins("http://localhost:5000");
			}
		};
	}
}

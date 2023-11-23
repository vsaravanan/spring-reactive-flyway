package com.saravan.reactive;

import com.saravan.reactive.student.Student;
import com.saravan.reactive.student.StudentRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url = "https://saravanjs.com:10101/", description = "URL"),
		@Server(url = "http://saravanjs.com:10100/", description = "URL")})
public class SpringReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			for (int i = 1; i < 1001; i++) {
				repository.save(
						Student.builder()
								.firstname("Test" + i)
								.lastname("test" + i)
								.age(i)
								.build()
				).subscribe();
			}
		};
	}

}

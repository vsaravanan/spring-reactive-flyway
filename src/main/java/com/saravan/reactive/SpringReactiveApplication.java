package com.saravan.reactive;

import com.saravan.reactive.student.Student;
import com.saravan.reactive.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableSwagger2
//@OpenAPIDefinition
//@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class SpringReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			for (int i = 0; i < 3000; i++) {
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

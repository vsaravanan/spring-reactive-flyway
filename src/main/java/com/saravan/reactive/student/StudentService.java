package com.saravan.reactive.student;

import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final com.saravan.reactive.student.StudentRepository studentRepository;

  public Flux<com.saravan.reactive.student.Student> findAll() {
    return studentRepository.findAll()
        .delayElements(Duration.ofSeconds(1));
  }

  public Mono<com.saravan.reactive.student.Student> findById(Long id) {
    return studentRepository.findById(id);
  }

  public Mono<com.saravan.reactive.student.Student> save(com.saravan.reactive.student.StudentRequest request) {
    return studentRepository.save(
        com.saravan.reactive.student.Student.builder()
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .age(request.getAge())
            .build()
    );
  }

  public Flux<com.saravan.reactive.student.Student> findByFirstname(String firstname) {
    return studentRepository.findAllByFirstnameContainingIgnoreCase(firstname);
  }

  public void deleteById(Long id) {
    studentRepository.deleteById(id).subscribe();
  }
}

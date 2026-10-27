package backend_project.finalproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend_project.finalproject.domain.Student;
import backend_project.finalproject.domain.StudentRepository;

@SpringBootApplication
public class FinalprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalprojectApplication.class, args);
	}

	@Bean 
	public CommandLineRunner student(StudentRepository studentRepository){
		return (args) -> {
			
			Student student1 = new Student("Milla Maijanen", 12, 
					"Mikonkatu", "Anna@gmail.com", "Student");

			studentRepository.save(student1);
		};
	}
}

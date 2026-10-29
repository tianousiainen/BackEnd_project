package backend_project.finalproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend_project.finalproject.domain.Group;
import backend_project.finalproject.domain.GroupRepository;
import backend_project.finalproject.domain.Student;
import backend_project.finalproject.domain.StudentRepository;

@SpringBootApplication
public class FinalprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalprojectApplication.class, args);
	}

	@Bean 
	public CommandLineRunner student(StudentRepository studentRepository,
		GroupRepository gRepository){
		return (args) -> {

			Group group1 = new Group("Adults");
			Group group2 = new Group("Circus 1");

			gRepository.save(group1);
			gRepository.save(group2);


			Student student1 = new Student("Milla Maijanen", 12, 
					"Mikonkatu", "Anna@gmail.com", "Student");

			student1.getGroups().add(group2);
			studentRepository.save(student1);
		};
	}
}

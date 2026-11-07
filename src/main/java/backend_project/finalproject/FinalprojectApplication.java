package backend_project.finalproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import backend_project.finalproject.domain.AppUser;
import backend_project.finalproject.domain.AppUserRepository;
import backend_project.finalproject.domain.Dicipline;
import backend_project.finalproject.domain.DiciplineRepository;
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
		GroupRepository gRepository, DiciplineRepository dRepository,
		AppUserRepository aRepository){
		return (args) -> {

			Group group1 = new Group("Adults");
			Group group2 = new Group("Circus 1");

			gRepository.save(group1);
			gRepository.save(group2);

			Dicipline dicipline1 = new Dicipline("Acrobatics");
			Dicipline dicipline2 = new Dicipline("Aerial arts");
			Dicipline dicipline3 = new Dicipline("Partner acrobatics");
			Dicipline dicipline4 = new Dicipline("Juggling");

			dRepository.save(dicipline1);
			dRepository.save(dicipline2);
			dRepository.save(dicipline3);
			dRepository.save(dicipline4);

			Student student1 = new Student("Milla Maijanen", 12, 
					"Mikonkatu", "Anna@gmail.com", "Student", dicipline1);

			student1.getGroups().add(group2);
			studentRepository.save(student1);


			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			AppUser user1 = new AppUser("Teacher", "$2a$10$6YGbfI.vo8iYqlJQXkQRZeW8HmStHIxTiWHv0.wnIUjPtvnlPGhx6",
							"teacher@teachers.com", "ADMIN");
				
			AppUser user2 = new AppUser("Student", "$2a$10$kkNQcZHxe/s2E2ekX0Qc2.qfEHj1GpdOgGet7vulEIBmjY4/xUizi",
							"student@students.com", "USER");

			aRepository.save(user1);
			aRepository.save(user2);
		};
	}
}

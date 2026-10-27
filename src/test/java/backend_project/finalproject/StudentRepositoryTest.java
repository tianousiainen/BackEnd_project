package backend_project.finalproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import backend_project.finalproject.domain.Student;
import backend_project.finalproject.domain.StudentRepository;

@DataJpaTest
public class StudentRepositoryTest {
    @Autowired 
    private StudentRepository sRepository;

    private Student testStudent;

    @BeforeEach 
    public void setUp(){
        testStudent = sRepository.save(
            new Student("Anna Marttila", 20 , "Mikkelä 12b", 
                        "AnnaM@gmail.com", "Student"));
    }

    
    @Test 
    public void createNewStudent(){
        Student student = new Student("Maija Mikkeli", 12 , "Mikonkatu 1", 
                                    "MaijaMM@gmail.com", "guardian");
        sRepository.save(student);
        assertThat(student.getId()).isNotNull();
    }
    
}

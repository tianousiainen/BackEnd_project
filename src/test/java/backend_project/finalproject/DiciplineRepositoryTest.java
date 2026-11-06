package backend_project.finalproject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.checkerframework.checker.units.qual.t;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import backend_project.finalproject.domain.Dicipline;
import backend_project.finalproject.domain.DiciplineRepository;

@DataJpaTest 
public class DiciplineRepositoryTest {
    @Autowired 
    private DiciplineRepository dRepository;

    private Dicipline testDicipline;

    @BeforeEach 
    public void setUp(){
        testDicipline = dRepository.save(
            new Dicipline("Acrobatics"));
    }

    @Test 
    public void createNewDicipline(){
        Dicipline dicipline = dRepository.save
        (new Dicipline("Aerial arts"));
    }

    @Test 
    public void findDiciplineById(){
        Optional<Dicipline> found = dRepository.findById(testDicipline.getDiciplineid());

        assertThat(found).isPresent();
        assertThat(found.get().getDicipline()).isEqualTo("Acrobatics");
    }

    @Test 
    public void deleteDiciplineById(){
        dRepository.deleteById(testDicipline.getDiciplineid());

        assertThat(dRepository.findById(testDicipline.getDiciplineid())).isEmpty();
    }
}

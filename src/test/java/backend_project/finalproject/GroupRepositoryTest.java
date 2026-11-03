package backend_project.finalproject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import backend_project.finalproject.domain.Group;
import backend_project.finalproject.domain.GroupRepository;

@DataJpaTest 
public class GroupRepositoryTest {
    @Autowired 
    private GroupRepository gRepository;

    private Group testGroup;

    @BeforeEach 
    public void setUp(){
        testGroup = gRepository.save(
        new Group("Circus 4"));
    }

    @Test 
    public void createNewGroup(){
        Group group = gRepository.save(
            new Group("Test group")
        );
    }

    @Test 
    public void FindGroupById(){
        Optional<Group> found = gRepository.findById(testGroup.getGroupid());

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Circus 4");
    }

    @Test 
    public void DeleteGroupById(){
        gRepository.deleteById(testGroup.getGroupid());

        assertThat(gRepository.findById(testGroup.getGroupid())).isEmpty();
    }
}

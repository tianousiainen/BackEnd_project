package backend_project.finalproject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository <Group, Long>{
    List<Group> findByName(String name);
}

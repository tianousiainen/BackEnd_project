package backend_project.finalproject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DiciplineRepository extends CrudRepository <Dicipline, Long>{
    List<Dicipline> findByDicipline(String dicipline);
}

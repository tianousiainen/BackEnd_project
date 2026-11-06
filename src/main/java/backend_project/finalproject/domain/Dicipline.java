package backend_project.finalproject.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity 
public class Dicipline {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _diciplineid;
    private String _dicipline;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "_dicipline")
    private List<Student> students;

    public Dicipline(String dicipline) {
        _dicipline = dicipline;
    }

    public Dicipline(){

    }

    public void setDiciplineid(Long diciplineid) {
        _diciplineid = diciplineid;
    }

    public void setDicipline(String dicipline) {
        _dicipline = dicipline;
    }

    public Long getDiciplineid() {
        return _diciplineid;
    }

    public String getDicipline() {
        return _dicipline;
    }

    @Override
    public String toString() {
        return "Dicipline [_diciplineid=" + _diciplineid + ", _dicipline=" + _dicipline + "]";
    }   
}

package backend_project.finalproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;

@Entity 
@Table (name = "hobby_group")
public class Group {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _groupid;
    private String _name;

   @ManyToMany (mappedBy = "_groups")
   private Set<Student> _students = new HashSet<>();

   public Set<Student> getStudents(){
        return _students;
   }

   public void setStudents(Set<Student> students){
    _students = students;
   }

    public Group(String name) {
        _name = name;
    }

    public Group(){

    }

    public void setGroupid(Long groupid) {
        _groupid = groupid;
    }

    public void setName(String name) {
        _name = name;
    }

    public Long getGroupid() {
        return _groupid;
    }

    public String getName() {
        return _name;
    }

    @Override
    public String toString() {
        return "Group [_groupid=" + _groupid + ", _name=" + _name + "]";
    }
}

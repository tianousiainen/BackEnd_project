package backend_project.finalproject.domain;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
public class Student {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long _id;
    private String _name;
    private int _age;
    private String _address;
    private String _email;
    private String _status;

    @ManyToMany 
    @JoinTable (
        name = "student_group_link",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn (name="group_id")
    )
    private Set<Group> _groups = new HashSet<>();

    public Set<Group> getGroups(){
        return _groups;
    }

    public void setGroups(Set<Group> groups){
        _groups = groups;
    }

    public Student(String name, int age ,String address, String email, String status) {
        _name = name;
        _age = age;
        _address = address;
        _email = email;
        _status = status;
    }

    public Student(){

    }

    public void setId(Long id) {
        _id = id;
    }

    public void setName(String name) {
        _name = name;
    }

    public void setAge(int age){
        _age = age;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public Long getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public int getAge(){
        return _age;
    }

    public String getAddress() {
        return _address;
    }

    public String getEmail() {
        return _email;
    }

    public String getStatus() {
        return _status;
    }

    @Override
    public String toString() {
        return "Student [_id=" + _id + ", _name=" +
                 _name + ", _address=" + _address + ", _email=" + _email
                + ", _status=" + _status + "]";
    }
    
    
}

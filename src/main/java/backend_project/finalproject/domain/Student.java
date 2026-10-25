package backend_project.finalproject.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long _id;
    private String _name;
    private String _address;
    private String _email;
    private String _status;

    public Student(String name, String address, String email, String status) {
        _name = name;
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

    public String getAddress() {
        return _address;
    }

    public String getEmail() {
        return _email;
    }

    public String getStatus() {
        return _status;
    }
    
}

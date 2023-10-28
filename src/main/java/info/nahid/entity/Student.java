package info.nahid.entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Student[%s]",name);
    }
}

package info.nahid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passport {
    @Id
    private Long id;
    private String number;

    public Passport() {

    }

    public Passport(String name) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }
}

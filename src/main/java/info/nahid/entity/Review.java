package info.nahid.entity;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    private Long id;
    private String rating;
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    public Review() {

    }

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("Review[%s %s]",rating, description);
    }
}

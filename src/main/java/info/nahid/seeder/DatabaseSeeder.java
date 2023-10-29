package info.nahid.seeder;

import info.nahid.entity.Passport;
import info.nahid.entity.Review;
import info.nahid.entity.Student;
import info.nahid.repository.PassportRepositroy;
import info.nahid.repository.ReviewRepository;
import info.nahid.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PassportRepositroy passportRepositroy;

    @Autowired
    ReviewRepository reviewRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedPassportData();
        seedStudentData();
        seedReviewData();

    }

    public void seedPassportData(){
        List<Passport> passports = new ArrayList<>();

        Passport passport1 = new Passport();
        passport1.setId(40001);
        passport1.setNumber("E1234567");
        passports.add(passport1);

        Passport passport2 = new Passport();
        passport2.setId(40002);
        passport2.setNumber("N1234567");
        passports.add(passport2);

        Passport passport3 = new Passport();
        passport3.setId(40003);
        passport3.setNumber("L1234567");
        passports.add(passport3);
        passportRepositroy.saveAll(passports);
    }

    public void seedStudentData() {
        List<Student> students = new ArrayList<>();

        Passport passport1 = passportRepositroy.findById(40001L).orElse(null);
        Student student1 = new Student();
        student1.setId(20001);
        student1.setName("Sakib");
        student1.setPassport(passport1);
        students.add(student1);

        Passport passport2 = passportRepositroy.findById(40002L).orElse(null);
        Student student2 = new Student();
        student2.setId(20002);
        student2.setName("Akib");
        student2.setPassport(passport2);
        students.add(student2);

        Passport passport3 = passportRepositroy.findById(40003L).orElse(null);
        Student student3 = new Student();
        student3.setId(20003);
        student3.setName("Hasib");
        student3.setPassport(passport3);
        students.add(student3);

        studentRepository.saveAll(students);
    }

    public void seedReviewData() {
        List<Review> reviews  = new ArrayList<>();

        Review review1 = new Review();
        review1.setId(50001);
        review1.setRating("5");
        review1.setDescription("Great Course");
        reviews.add(review1);

        Review review2 = new Review();
        review2.setId(50002);
        review2.setRating("4");
        review2.setDescription("Wonderful Course");
        reviews.add(review2);

        Review review3 = new Review();
        review3.setId(50003);
        review3.setRating("5");
        review3.setDescription("Awesome Course");
        reviews.add(review3);
        reviewRepository.saveAll(reviews);
    }

}

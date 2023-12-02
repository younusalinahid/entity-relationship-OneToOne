package info.nahid.seeder;

import info.nahid.entity.*;
import info.nahid.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PassportRepository passportRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedPassportData();
        seedStudentData();
        seedCourseData();
        seedReviewData();
        seedEmployeeData();

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
        passportRepository.saveAll(passports);
    }

    public void seedCourseData() {
        List<Course> courses = new ArrayList<>();

        Course course1 = new Course();
        course1.setId(10001);
        course1.setName("JPA in 50 Steps");
        courses.add(course1);

        Course course2 = new Course();
        course2.setId(10002);
        course2.setName("Spring boot basics");
        courses.add(course2);

        Course course3 = new Course();
        course3.setId(10003);
        course3.setName("Hibernate Fundamentals");
        courses.add(course3);
        courseRepository.saveAll(courses);
    }

    public void seedStudentData() {
        List<Student> students = new ArrayList<>();

        Passport passport1 = passportRepository.findById(40001L).orElse(null);
        Course course1 = courseRepository.findById(10001L).orElse(null);
        Student student1 = new Student();
        student1.setId(20001);
        student1.setName("Sakib");
        student1.setPassport(passport1);
        student1.getCourses().add(course1);
        students.add(student1);

        Passport passport2 = passportRepository.findById(40002L).orElse(null);
        Course course2 = courseRepository.findById(10002L).orElse(null);
        Student student2 = new Student();
        student2.setId(20002);
        student2.setName("Akib");
        student2.setPassport(passport2);
        student2.getCourses().add(course2);
        students.add(student2);

        Passport passport3 = passportRepository.findById(40003L).orElse(null);
        Course course3 = courseRepository.findById(10003L).orElse(null);
        Student student3 = new Student();
        student3.setId(20003);
        student3.setName("Hasib");
        student3.setPassport(passport3);
        student3.getCourses().add(course3);
        students.add(student3);

        studentRepository.saveAll(students);
    }

    public void seedReviewData() {
        List<Review> reviews  = new ArrayList<>();

        Course course1 = courseRepository.findById(10001L).orElse(null);
        Review review1 = new Review();
        review1.setId(50001);
        review1.setRating("5");
        review1.setDescription("Great Course");
        review1.setCourse(course1);
        reviews.add(review1);

        Course course2 = courseRepository.findById(10002L).orElse(null);
        Review review2 = new Review();
        review2.setId(50002);
        review2.setRating("4");
        review2.setDescription("Wonderful Course");
        review2.setCourse(course2);
        reviews.add(review2);

        Course course3 = courseRepository.findById(10003L).orElse(null);
        Review review3 = new Review();
        review3.setId(50003);
        review3.setRating("5");
        review3.setDescription("Awesome Course");
        review3.setCourse(course3);
        reviews.add(review3);
        reviewRepository.saveAll(reviews);
    }

    public void seedEmployeeData() {
        List<Employee> employees = new ArrayList<>();

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        partTimeEmployee.setId(60001);
        partTimeEmployee.setName("Jill");
        partTimeEmployee.setHourlyWage(new BigDecimal("50"));
        employees.add(partTimeEmployee);

        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        fullTimeEmployee.setId(60002);
        fullTimeEmployee.setName("Jack");
        fullTimeEmployee.setSalary(new BigDecimal("10000"));
        employees.add(fullTimeEmployee);
        employeeRepository.saveAll(employees);
    }


}

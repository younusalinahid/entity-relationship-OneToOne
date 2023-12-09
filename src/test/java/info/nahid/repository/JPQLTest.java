package info.nahid.repository;

import info.nahid.entity.Course;
import info.nahid.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void jpql_courses_without_students() {
        List<Course> resultList = courseRepository.findCoursesWithoutStudent();
        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_courses_with_atLeast_Two_students() {
        List<Course> resultList = courseRepository.findCoursesWithAtLeastTwoStudents();
        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_courses_ordered_by_students() {
        List<Course> resultList = courseRepository.findCoursesOrderedByStudents();
        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_students_with_passports_in_a_certain_pattern() {
        List<Student> resultList = studentRepository.findStudentsWithHavingPassportPattern("1234");
        logger.info("Results -> {}", resultList);
    }

    @Test
    public void join() {
        List<Course> courses = courseRepository.findCourseWithStudentJoinQuery();
        logger.info("Results Size -> {}", courses.size());
        for (Course course : courses) {
            logger.info("Courses : {}", course);
            logger.info("Students : {}", course.getStudents());
        }
    }

    @Test
    public void Left_join() {
        List<Course> courses = courseRepository.findCourseWithStudentLeftJoinQuery();
        logger.info("Results Size -> {}", courses.size());
        for (Course course : courses) {
            logger.info("Courses : {}", course);
            logger.info("Students : {}", course.getStudents());
        }
    }

    @Test
    public void Cross_join() {
        List<Course> result = courseRepository.findCoursesAndStudentsCrossJoin();
        logger.info("Results Size -> {}", result.size());
        for (Course course : result) {
            logger.info("Courses : {}", course);
            logger.info("Students : {}", course.getStudents());
        }
    }
}
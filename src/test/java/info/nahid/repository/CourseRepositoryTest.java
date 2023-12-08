package info.nahid.repository;

import info.nahid.entity.Course;
import info.nahid.entity.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import javax.transaction.Transactional;
import java.util.List;

@DataJpaTest
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = courseRepository.findById(10001L).orElse(null);
        logger.info("course -> {}", course);
        if (course != null) {
            logger.info("review -> {}", course.getReviews());
        }
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Review review = reviewRepository.findById(50001L).orElse(null);
        logger.info("review -> {}", review);
        if (review != null) {
            logger.info("course -> {}", review.getCourse());
        }
    }

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

}
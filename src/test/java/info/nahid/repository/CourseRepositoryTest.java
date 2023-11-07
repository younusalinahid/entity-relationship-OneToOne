package info.nahid.repository;

import info.nahid.entity.Course;
import info.nahid.entity.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

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
        logger.info("passport -> {}", course);
        if (course != null) {
            logger.info("student -> {}", course.getReviews());
        }
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Review review = reviewRepository.findById(50001L).orElse(null);
        logger.info("review -> {}", review);
        if (review != null) {
            logger.info("review -> {}",review.getCourse());
        }
    }
}
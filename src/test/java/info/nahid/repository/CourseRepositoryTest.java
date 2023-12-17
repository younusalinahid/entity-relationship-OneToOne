package info.nahid.repository;

import info.nahid.entity.Course;
import info.nahid.entity.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
    public void findById_CoursePresent() {
        courseRepository.findById(10001L).ifPresent(course -> assertEquals("JPA in 50 Steps", course.getName()));

    }

    @Test
    public void findById_CourseNotPresent() {
        Optional<Course> courseOptional = courseRepository.findById(20001L);
        assertFalse(courseOptional.isPresent());
    }

    @Test
    public void playingAroundWithSpringDataRepository() {
        logger.info("Courses -> {} ", courseRepository.findAll());
        logger.info("Count -> {} ", courseRepository.count());
    }

    @Test
    public void sort() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        logger.info("Courses -> {} ", courseRepository.findAll(sort));
        logger.info("Count -> {} ", courseRepository.count());
    }

    @Test
    public void pagination() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Course> firtPage = courseRepository.findAll(pageRequest);
        logger.info("First Page -> {} ", firtPage.getContent());

        Pageable secondPageable = firtPage.nextPageable();
        Page<Course> secondPage = courseRepository.findAll(secondPageable);
        logger.info("Second Page -> {} ", secondPage.getContent());
    }
}
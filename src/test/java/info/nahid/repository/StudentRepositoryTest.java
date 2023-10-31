package info.nahid.repository;

import info.nahid.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

@DataJpaTest
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void retrieveStudentAndPassportDetails() {
        Student student = studentRepository.findById(20001L).orElse(null);
        logger.info("student -> {}", student);
        if (student != null) {
            logger.info("passport -> {}", student.getPassport());
        }
    }
}
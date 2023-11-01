package info.nahid.repository;

import info.nahid.entity.Passport;
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

    @Autowired
    PassportRepository passportRepository;


    @Test
    @Transactional
    public void someTest() {
        Student student = studentRepository.findById(20002L).orElse(null);
        if (student != null) {
            Passport passport = student.getPassport();
            passport.setNumber("E1234568");
            student.setName("Sakib - updated");
        }
    }

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = studentRepository.findById(20001L).orElse(null);
        logger.info("student -> {}", student);
        if (student != null) {
            logger.info("passport -> {}", student.getPassport());
        }
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
         Passport passport = passportRepository.findById(40001L).orElse(null);
        logger.info("passport -> {}", passport);
        if (passport != null) {
            logger.info("student -> {}", passport.getStudent());
        }
    }
}
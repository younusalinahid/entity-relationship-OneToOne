package info.nahid.repository;

import info.nahid.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.passport.number LIKE CONCAT('%', :pattern)")
    List<Student> findStudentsWithHavingPassportPattern(@Param("pattern") String pattern);

}

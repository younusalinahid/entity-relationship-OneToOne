package info.nahid.repository;

import info.nahid.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.students IS EMPTY")
    List<Course> findCoursesWithoutStudent();

    @Query("SELECT c FROM Course c WHERE SIZE(c.students) >= 2")
    List<Course> findCoursesWithAtLeastTwoStudents();

    @Query("SELECT c FROM Course c order by SIZE(c.students) desc ")
    List<Course> findCoursesOrderedByStudents();

    @Query("SELECT c FROM Course c JOIN FETCH c.students")
    List<Course> findCourseWithStudentJoinQuery();

    @Query("SELECT c FROM Course c LEFT JOIN FETCH c.students")
    List<Course> findCourseWithStudentLeftJoinQuery();

    @Query("SELECT c, s FROM Course c, Student s")
    List<Course> findCoursesAndStudentsCrossJoin();
}

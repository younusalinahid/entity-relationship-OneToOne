package info.nahid.repository;

import info.nahid.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepositroy extends JpaRepository<Passport, Long> {

}

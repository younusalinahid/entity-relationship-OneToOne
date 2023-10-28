package info.nahid.repository;

import info.nahid.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepositroy extends JpaRepository<Passport, Long> {

}

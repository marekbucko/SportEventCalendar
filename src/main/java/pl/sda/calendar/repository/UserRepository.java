package pl.sda.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.calendar.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

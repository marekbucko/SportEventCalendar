package pl.sda.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.calendar.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}

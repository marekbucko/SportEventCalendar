package pl.sda.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.sda.calendar.exception.ToBigGroupSizeException;
import pl.sda.calendar.model.Event;
import pl.sda.calendar.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event newEvent) {
        if (newEvent.getMaxGroupSize() > 50) {
            throw new ToBigGroupSizeException
                    (String.format("Group size should not be bigger than 50. Given group size: %s", newEvent.getMaxGroupSize()));
        }
        return eventRepository.save(newEvent);

    }
}

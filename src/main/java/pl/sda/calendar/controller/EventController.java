package pl.sda.calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.calendar.model.Event;
import pl.sda.calendar.repository.EventRepository;
import pl.sda.calendar.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired EventRepository eventRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event newEvent) {
        return eventService.createEvent(newEvent);
    }

    @GetMapping("/findall")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> showEvents() {
        return eventRepository.findAll();
    }
}

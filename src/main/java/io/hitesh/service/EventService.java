package io.hitesh.service;

import io.hitesh.model.Event;
import io.hitesh.repository.EventRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired private EventRepository repository;

    public Optional<Event> getEventById(Long eventId) {
        return repository.findById(eventId);
    }

    public List<Event> getEvent() {
        return repository.findAll();
    }

    public Event saveEvent(Event event) {
        return repository.save(event);
    }

    public void deleteEvent(Event event) {
        repository.delete(event);
    }
}

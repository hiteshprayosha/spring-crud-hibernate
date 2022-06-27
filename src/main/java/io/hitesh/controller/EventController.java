package io.hitesh.controller;

import io.hitesh.exception.EventNotFoundException;
import io.hitesh.model.Event;
import io.hitesh.service.EventService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class EventController {

    @Autowired private EventService service;

    @GetMapping("events")
    public List<Event> getAllEvent() {
        return service.getEvent();
    }

    @GetMapping("events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Long eventId)
            throws EventNotFoundException {
        Event event =
                service.getEventById(eventId)
                        .orElseThrow(() -> new EventNotFoundException(eventId));
        return ResponseEntity.ok().body(event);
    }

    @PostMapping("events")
    public Event createEvent(@RequestBody Event event) {
        return service.saveEvent(event);
    }

    @PutMapping("events/{id}")
    public ResponseEntity<Event> updateEvent(
            @PathVariable(value = "id") Long eventId, @Valid @RequestBody Event eventDetails)
            throws EventNotFoundException {
        Event event =
                service.getEventById(eventId)
                        .orElseThrow(() -> new EventNotFoundException(eventId));

        event.setTitle(eventDetails.getTitle());
        event.setShortDescription(eventDetails.getShortDescription());
        event.setLongDescription(eventDetails.getLongDescription());
        return ResponseEntity.ok(service.saveEvent(event));
    }

    @DeleteMapping("events/{id}")
    public Map<String, Boolean> deleteEvent(@PathVariable(value = "id") Long eventId)
            throws EventNotFoundException {
        Event event =
                service.getEventById(eventId)
                        .orElseThrow(() -> new EventNotFoundException(eventId));
        service.deleteEvent(event);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

package com.event.managements.services;

import com.event.managements.model.Event;
import com.event.managements.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));

        event.setTitle(eventDetails.getTitle());
        event.setTheme(eventDetails.getTheme());
        event.setStatus(eventDetails.getStatus());
        event.setMinGuest(eventDetails.getMinGuest());
        event.setMaxGuest(eventDetails.getMaxGuest());
        event.setDate(eventDetails.getDate());
        event.setDescription(eventDetails.getDescription());

        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
        eventRepository.delete(event);
    }
}

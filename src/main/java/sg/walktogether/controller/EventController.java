package sg.walktogether.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sg.walktogether.entity.Event;
import sg.walktogether.service.EventService;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public String showEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events";
    }

    @GetMapping("/create-event")
    public String showCreateEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "create-event";
    }

    @PostMapping("/create-event")
    public String saveEvent(@ModelAttribute("event") Event event, Model model) {
        eventService.saveEvent(event);
        model.addAttribute("message", "Event created successfully");
        return "create-event";
    }
}
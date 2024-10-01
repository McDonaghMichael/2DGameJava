package events;

import java.util.ArrayList;

public class EventManager {

    ArrayList<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    public void executeEvents() {
        for(Event event : events) {
            event.execute();
        }
    }

    public void clearEvents() {
        events.clear();
    }

}

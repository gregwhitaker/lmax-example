package lmax.example.event;

import com.lmax.disruptor.EventFactory;

public class HelloEvent {
    public final static EventFactory EVENT_FACTORY = HelloEvent::new;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

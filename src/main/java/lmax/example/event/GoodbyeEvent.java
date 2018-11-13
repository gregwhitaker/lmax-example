package lmax.example.event;

public class GoodbyeEvent implements Event {

    private String name;

    public GoodbyeEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getType() {
        return EventType.GOODBYE.getCode();
    }
}

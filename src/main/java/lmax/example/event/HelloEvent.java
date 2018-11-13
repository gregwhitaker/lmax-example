package lmax.example.event;

public class HelloEvent implements Event {

    private String name;

    public HelloEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getType() {
        return EventType.HELLO.getCode();
    }
}

package lmax.example.event;

public enum EventType {

    HELLO(1),
    GOODBYE(2);

    private final int code;

    EventType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

package ru.sstu;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Node;

/**
 * Created by user on 21.11.2016.
 */
public class MyEvent extends Event {

    public static EventType<MyEvent> ANY = new EventType<>(Event.ANY, "ANY");
    public static EventType<MyEvent> GOOD = new EventType<>(ANY, "GOOD");
    public static EventType<MyEvent> BAD = new EventType<>(ANY, "BAD");

    private Node origin = null;

    public MyEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public MyEvent(Node origin, EventType<? extends Event> eventType) {
        super(eventType);
        setOrigin(origin);
    }

    public Node getOrigin() {
        return origin;
    }

    public void setOrigin(Node origin) {
        this.origin = origin;
    }
}

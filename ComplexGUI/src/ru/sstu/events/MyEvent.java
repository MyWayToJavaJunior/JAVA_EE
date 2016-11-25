package ru.sstu.events;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventType;

/**
 * Created by Shvarts on 18.11.2016.
 */
public class MyEvent extends Event {

    public static final EventType<MyEvent> BAD_EVENT = new EventType<>(ANY, "BAD_EVENT");
    public static final EventType<MyEvent> GOOD_EVENT = new EventType<>(ANY, "GOOD_EVENT");
    public static final EventType<MyEvent> SUPER_GOOD_EVENT = new EventType<>(GOOD_EVENT, "SUPER_GOOD_EVENT");

    public MyEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
}

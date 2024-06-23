package hu.therealuhlarzoltan.api.event;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static java.time.ZonedDateTime.now;
import java.time.ZonedDateTime;

@NoArgsConstructor(force = true)
public class Event<K, T> {

    public enum Type {
        CREATE,
        DELETE
    }

    @Getter
    private final Type eventType;
    @Getter
    private final K key;
    @Getter
    private final T data;
    private final ZonedDateTime eventCreatedAt;

    public Event(Type eventType, K key, T data) {
        this.eventType = eventType;
        this.key = key;
        this.data = data;
        this.eventCreatedAt = now();
    }

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    public ZonedDateTime getEventCreatedAt() {
        return eventCreatedAt;
    }
}

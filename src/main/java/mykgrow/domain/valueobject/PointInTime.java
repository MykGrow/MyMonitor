package mykgrow.domain.valueobject;

import java.time.LocalDateTime;

public class PointInTime {

    private final LocalDateTime timestamp;

    public PointInTime(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

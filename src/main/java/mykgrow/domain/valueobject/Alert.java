package mykgrow.domain.valueobject;

import java.time.LocalDateTime;

public class Alert {

    private final LocalDateTime timestamp;
    private final String message;
    private final Severity severity;

    public Alert(LocalDateTime timestamp, String message, Severity severity) {
        this.timestamp = timestamp;
        this.message = message;
        this.severity = severity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Severity getSeverity() {
        return severity;
    }

    public enum Severity {
        INFO, WARNING, CRITICAL;
    }
}
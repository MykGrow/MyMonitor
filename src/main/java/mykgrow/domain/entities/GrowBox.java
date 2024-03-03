package mykgrow.domain.entities;

import java.util.UUID;
public class GrowBox {
    private final UUID id;
    private final String name;
    private final Status status;

    public GrowBox(UUID id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public enum Status {
        ACTIVE, IDLE, ERROR;
    }
}

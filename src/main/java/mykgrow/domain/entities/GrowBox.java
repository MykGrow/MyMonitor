package mykgrow.domain.entities;

import java.util.UUID;
public class GrowBox {
    private final UUID id;
    private final String name;
    private final Status status;

    public GrowBox(String name, Status status) {
        this.id = UUID.randomUUID();
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

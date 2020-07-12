package revolt.backend.entity;

public enum Role {
    ADMIN,
    USER;

    public String getStatus() {
        return this.name();
    }
}
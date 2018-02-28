package taskmanager.model;

import java.time.LocalDateTime;

public  class AbstractBaseEntity {

    private Integer id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public AbstractBaseEntity(){}

    public AbstractBaseEntity(Integer id,LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public boolean isNew() {
        return id == null;
    }
}

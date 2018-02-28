package taskmanager.model;

import java.time.LocalDateTime;

public class Task extends AbstractBaseEntity {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String descriptions;
    private boolean repeatable;

    public Task(){}

    public Task(LocalDateTime startDateTime, LocalDateTime endDateTime, String descriptions, boolean repeatable){
        super(null,startDateTime,endDateTime);
        this.descriptions = descriptions;
        this.repeatable = repeatable;

    }

    public Task(Integer id,LocalDateTime startDateTime, LocalDateTime endDateTime, String descriptions, boolean repeatable) {
        super(id,startDateTime,endDateTime);
        this.descriptions = descriptions;
        this.repeatable = repeatable;
    }



    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }

    @Override
    public String toString() {
        return "Task{" +
                "startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", descriptions='" + descriptions + '\'' +
                ", repeatable=" + repeatable +
                '}';
    }
}

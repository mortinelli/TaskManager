package taskmanager.model;

import java.time.LocalDateTime;
import java.util.List;

public class Goal extends AbstractBaseEntity {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private List<Task> tasks;

    public Goal(int id, LocalDateTime startDateTime, LocalDateTime endDateTime, List<Task> tasks) {
        super(id,startDateTime,endDateTime);
        this.tasks = tasks;
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}



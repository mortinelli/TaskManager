package taskmanager.repository;

import org.slf4j.Logger;
import taskmanager.model.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.slf4j.LoggerFactory.getLogger;

public class InMemoryRep {
     private static final Logger LOG = getLogger(InMemoryRep.class);
    private Map<Integer,Task> taskList = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);


    public InMemoryRep() {
        LOG.debug("Init InMemoryRep");
        this.taskList.put(counter.get(), new Task(counter.get(), LocalDateTime.now(),LocalDateTime.now(),"Сходить в магазин и купить еду",true));
        counter.incrementAndGet();
        this.taskList.put(counter.get(), new Task(counter.get(),LocalDateTime.now(),LocalDateTime.now(),"Task2",true));
        counter.incrementAndGet();
        this.taskList.put(counter.get(), new Task(counter.get(),LocalDateTime.now(),LocalDateTime.now(),"Task3",false));

    }

    public Task save(Task task){

        if (task.isNew()) {
            task.setId(counter.incrementAndGet());
        }
        taskList.put(task.getId(), task);
        return task;

    }

    public Task get(Integer id){
        return taskList.get(id);
    }

    public void delete(Integer id){
        taskList.remove(id);
    }

    public List<Task> getTaskList() {
        List<Task> list = new ArrayList<>();
        for(Map.Entry<Integer,Task> entry : taskList.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}

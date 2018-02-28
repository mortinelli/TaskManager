package taskmanager;

import org.slf4j.Logger;
import taskmanager.model.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class Main {

    public static void main(String[] args) {

        Logger log = getLogger(Main.class);
        log.debug("main is start");

        List<Task> list = new ArrayList<Task>();
        list.add(new Task(0,LocalDateTime.now(),LocalDateTime.now(),"Task1",false));
        list.add(new Task(1,LocalDateTime.now(),LocalDateTime.now(),"Task2",false));
        list.add(new Task(2,LocalDateTime.now(),LocalDateTime.now(),"Task3",false));
        System.out.println("Hello Task Manager webb app");

        for(Task t : list){
            System.out.println(t);
        }
    }
}

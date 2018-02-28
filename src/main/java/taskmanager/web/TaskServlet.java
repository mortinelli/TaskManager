package taskmanager.web;

import org.slf4j.Logger;

import taskmanager.model.Task;
import taskmanager.repository.InMemoryRep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


import static org.slf4j.LoggerFactory.getLogger;

public class TaskServlet extends HttpServlet {

    private static final InMemoryRep inMemoryRep = new InMemoryRep();
    private static final Logger LOG = getLogger(TaskServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");


        Task task = new Task(id.isEmpty() ? null : Integer.valueOf(id),
                LocalDateTime.parse(req.getParameter("startDateTime")),
                LocalDateTime.parse(req.getParameter("endDateTime")),
                req.getParameter("description"),
                req.getParameter("repeatable") != null );

        LOG.info(task.isNew() ? "Create {}" : "Update {}", task);
        inMemoryRep.save(task);
        resp.sendRedirect("tasks");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action == null ? "all" : action) {
            case "remove":
                int id = getId(req);
                LOG.info("Delete {}", id);
                inMemoryRep.delete(id);
                resp.sendRedirect("tasks");
                break;
            case "create":
            case "update":
                final Task task = "create".equals(action) ? new Task() : inMemoryRep.get(getId(req));
                req.setAttribute("task", task);
                req.getRequestDispatcher("/taskForm.jsp").forward(req, resp);
                break;
            case "all":
            default:
                LOG.info("getAll");
                req.setAttribute("tasks", inMemoryRep.getTaskList());
                req.getRequestDispatcher("/tasks.jsp").forward(req, resp);
                break;
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }


}

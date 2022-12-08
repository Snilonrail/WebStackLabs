package model;

import logger.Lab1Logger;

public class Task {

    private final Lab1Logger logger;

    private String taskName;
    private Status status;
    private User assignee;

    public Task(Lab1Logger logger, String taskName) {
        this.logger = logger;
        this.taskName = taskName;
        this.status = Status.ToDo;
    }

    public Task(Lab1Logger logger, String taskName, Status status) {
        this.logger = logger;
        this.taskName = taskName;
        this.status = status;
    }

    public void assignTask(Project project){
        assignee = project.chooseDevForTask();
        assignee.incrementTasks();
        assignee.getProjectsAssigned().add(project.getProjectName());
        logger.info("task " + taskName + " was assigned to " + assignee.getUserName() + "\nGood luck to him!\n");
    }

    public Status getStatus() {
        return status;
    }

    public User getAssignee() {
        return assignee;
    }

    public void updateStatus(Status newStatus) {
        logger.debug(taskName + " changed: " + newStatus);
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return String.format("Task %s assigned to %s",
                taskName,
                assignee);
    }
}

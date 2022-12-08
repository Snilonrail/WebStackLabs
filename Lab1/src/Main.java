import model.*;
import logger.FileLab1Logger;

import java.util.Arrays;
import java.util.List;

public class Main {
    static String PROJECT_NAME = "Lab1 kick off";

    public static void main(String[] args) {
        List<User> Users = Arrays.asList(
                new User("Eric Clapton", Role.ARTISTIC_DEVOPS),
                new User("Erich Gamma", Role.DEVELOPER),
                new User("Richard Helm", Role.DEVELOPER),
                new User("Satya Nadella", Role.PROJECT_MANGER),
                new User("James Faraday", Role.CTO),
                new User("Steve Jobs", Role.PRODUCT_OWNER),
                new User("Pier Collina", Role.QA)
        );

        FileLab1Logger logger = new FileLab1Logger();
        User mightyAdmin  = new User("Joe Biden", Role.ADMIN);
        User externalDev  = new User("Julian Assange", Role.DEVELOPER);
        mightyAdmin.addProjectToAdmin(PROJECT_NAME);

        var lab1Project = new Project("Lab1 kick off", mightyAdmin, Users);
        lab1Project.addUser(new User("Linus Torvalds", Role.DEVELOPER));
        lab1Project.addTask(new Task(logger, "refactor lab 1", Status.ToDo));
        lab1Project.addUser(externalDev);
        lab1Project.addTask(new Task(logger, "refactor lab 1", Status.ToDo));

        var task1 = new Task(logger, "Setup EC2 instances");
        var task2 = new Task(logger, "add VM support for AM64 Arch");
        var task3 = new Task(logger, "create landing page");

        task1.assignTask(lab1Project);
        task2.assignTask(lab1Project);
        task3.assignTask(lab1Project);

        lab1Project.addTask(task1);
        lab1Project.addTask(task2);
        lab1Project.addTask(task3);

        task1.updateStatus(Status.InProgress);
        task2.updateStatus(Status.InProgress);

        lab1Project.getTasksInProgress().forEach(System.out::println);

        var lab1Project2 = new Project("Lab1_2 kick off", mightyAdmin);
        lab1Project2.addUser(externalDev);
        lab1Project.removeUser(externalDev);
    }

}
package model;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Project {

    private String name;
    private List<User> Users = new ArrayList<>();
    private List<User> projectAdmins = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();

    public Project(String name, User projectAdmin) {
        this.name = name;
        projectAdmins.add(projectAdmin);
    }

    public String getProjectName(){
        return this.name;
    }

    public Project(String name, User projectAdmin, @NotNull List<User> projectMembers) {
        this.name = name;
        projectAdmins.add(projectAdmin);
        projectMembers.forEach(this::addUser);
    }

    public void addUser(@NotNull User User){
        User.addProject(name, projectAdmins);
        Users.add(User);
    }

    public User chooseDevForTask() {
        return Users.stream().filter(u -> u.getUserRole().equals(Role.DEVELOPER) && u.getTaskNumber() < 2).findFirst().orElseThrow();
    }

    public void removeUser(@NotNull User User){
        User.removeFromProject(name, projectAdmins);
        tasks.stream().filter(task -> Objects.nonNull(task.getAssignee())).collect(Collectors.toList()).removeIf(task -> task.getAssignee().equals(User));
        Users.remove(User);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasksInProgress(){
        return tasks.stream().filter(t -> Objects.equals(t.getStatus(), Status.InProgress)).collect(Collectors.toList());
    }
}

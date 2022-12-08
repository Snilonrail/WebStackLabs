package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;

import notifications.EmailNotifications;
import notifications.Notifications;

public class User {
    private static final Notifications emailNorifier = new EmailNotifications();

    private String userName;
    private Role userRole;
    private Integer tasksNumber;
    private Set<String> projectsAssigned;

    public User(String userName, Role role) {
        this.userName = userName;
        this.userRole = role;
        this.tasksNumber = 0;
        projectsAssigned = new HashSet<>();
    }

    public String getUserName(){
        return userName;
    }

    public Set<String> getProjectsAssigned(){
        return projectsAssigned;
    }

    public Role getUserRole(){
        return userRole;
    }

    public void addProject(String projectName, List<User> recievers){
        this.projectsAssigned.add(projectName);
        emailNorifier.notifyUsers(userName + " added to project: " + projectName, recievers);
    }

    public void addProjectToAdmin(String projectName){
        this.projectsAssigned.add(projectName);
        var thisList = List.of(this);
        emailNorifier.notifyUsers(userName + " added to project: " + projectName, thisList);
    }

    public void removeFromProject(String projectName, List<User> recievers){
        this.projectsAssigned.remove(projectName);
        emailNorifier.notifyUsers(userName + " removed from project: " + projectName, recievers);
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public void incrementTasks(){
        tasksNumber++;
    }

    public void decrementTasks(){
        tasksNumber--;
    }

    public Integer getTaskNumber(){
        return this.tasksNumber;
    }

    @Override
    public String toString() {
        return String.format("User %s, role: %s, projects: %s",
                userName,
                userRole,
                projectsAssigned.stream().collect(joining(",")));
    }
}

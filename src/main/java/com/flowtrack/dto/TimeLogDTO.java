package com.flowtrack.dto;

public class TimeLogDTO {

    private String employee;
    private String date;
    private String project;
    private String task;
    private Double hours;
    private String status;

    public TimeLogDTO() {
    }

    public TimeLogDTO(String employee, String date, String project,
                      String task, Double hours, String status) {
        this.employee = employee;
        this.date = date;
        this.project = project;
        this.task = task;
        this.hours = hours;
        this.status = status;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
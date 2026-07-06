package com.flowtrack.dto;

public class TimeLogDTO {

    private String employee;
    private String date;
    private String project;
    private String task;
    private Double hours;
    private String status;
    private String projectId;
    private String taskId;
    private String syncStatus;
    private String zohoLogId;
    private String remarks;

    public TimeLogDTO() {
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getZohoLogId() {
        return zohoLogId;
    }

    public void setZohoLogId(String zohoLogId) {
        this.zohoLogId = zohoLogId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public TimeLogDTO(
            String employee,
            String date,
            String project,
            String task,
            Double hours,
            String status,
            String projectId,
            String taskId,
            String syncStatus,
            String zohoLogId,
            String remarks) {

        this.employee = employee;
        this.date = date;
        this.project = project;
        this.task = task;
        this.hours = hours;
        this.status = status;
        this.projectId = projectId;
        this.taskId = taskId;
        this.syncStatus = syncStatus;
        this.zohoLogId = zohoLogId;
        this.remarks = remarks;
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
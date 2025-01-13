package com.example.todo.demo.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nameTask;
    private LocalDate dateTask;
    private String status;

    public Tasks() {
    }

    public Tasks(String nameTask, LocalDate dateTask, String status) {
        this.nameTask = nameTask;
        this.dateTask = dateTask;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public LocalDate getDateTask() {
        return dateTask;
    }

    public void setDateTask(LocalDate dateTask) {
        this.dateTask = dateTask;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

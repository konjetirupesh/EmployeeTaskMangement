package com.SpringBootMapping.OneToOne.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskid;
    private String task;


    @OneToOne(mappedBy = "task", cascade = CascadeType.ALL)
    //    @JsonIgnore  // ✅ This prevents infinite recursion
//    @JsonBackReference // ✅ Back reference to prevent recursion
    @JsonIgnoreProperties("task")  // ✅ Allow serialization of employee in task
    private Employee employee;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getTaskid() {
        return taskid;
    }

    public Task(){

    }

    public Task(String task, Employee employee){
        this.task=task;
        this.employee=employee;
    }
    public void setTaskid(long taskid) {
        this.taskid = taskid;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}

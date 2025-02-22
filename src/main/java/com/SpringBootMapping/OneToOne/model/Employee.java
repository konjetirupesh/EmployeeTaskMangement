package com.SpringBootMapping.OneToOne.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String empName;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="task_id")
//    @JsonIgnoreProperties("employee")  // ✅ Prevent infinite recursion
    @JsonBackReference  // ✅ This prevents infinite recursion
    private Task task;

    Employee(){

    }
    public Employee(String empName,Task task){
        this.empName = empName;
        this.task=task;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

}

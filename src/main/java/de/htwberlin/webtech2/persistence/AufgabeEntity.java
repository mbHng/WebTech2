package de.htwberlin.webtech2.persistence;

import javax.persistence.*;

@Entity(name = "aufgaben")
public class AufgabeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "task", nullable = false)
    private String task;

    @Column(name = "DueTo")
    private String DueTo;

    @Column(name = "is completed")
    private boolean completed;

    public AufgabeEntity(String task, String dueTo, boolean completed) {
        this.task = task;
        this.DueTo = dueTo;
        this.completed = completed;

    }

    protected AufgabeEntity() {

    }

    public long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDueTo() {
        return DueTo;
    }

    public void setDueTo(String dueTo) {
        DueTo = dueTo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;

    }
}
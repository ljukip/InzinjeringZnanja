package model;

import enums.Symptoms;

public class Symptom {

    private Long id;
    private Symptoms name;

    public Symptom() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Symptoms getName() {
        return name;
    }

    public void setName(Symptoms name) {
        this.name = name;
    }
}

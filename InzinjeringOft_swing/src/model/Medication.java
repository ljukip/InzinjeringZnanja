package model;

import java.io.Serializable;

import enums.Medications;

public class Medication implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long id;

    private Medications name;

    public Medication() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medications getName() {
        return name;
    }

    public void setName(Medications name) {
        this.name = name;
    }

}

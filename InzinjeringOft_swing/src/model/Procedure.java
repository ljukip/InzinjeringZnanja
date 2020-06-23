package model;

import java.io.Serializable;

import enums.Procedures;
public class Procedure implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long id;

    private Procedures name;

    public Procedure() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Procedures getName() {
        return name;
    }

    public void setName(Procedures name) {
        this.name = name;
    }

}

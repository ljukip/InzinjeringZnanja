package model;

import java.io.Serializable;

import enums.Diseases;

public class Disease implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long id;
    
    private Diseases name;

    public Disease() {
    }

    public Disease(Long id, Diseases name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Diseases getName() {
        return name;
    }

    public void setName(Diseases name) {
        this.name = name;
    }
}


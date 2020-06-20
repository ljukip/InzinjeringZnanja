package InzinjeringOft.model;

import java.io.Serializable;
import javax.persistence.*;
import InzinjeringOft.enums.Procedures;

@Entity
@Table(name="Procedures")
public class Procedure implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column (name = "Name")
    @Enumerated(EnumType.STRING)
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

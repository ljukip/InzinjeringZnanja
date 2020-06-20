package InzinjeringOft.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import InzinjeringOft.enums.Medications;

@Entity
@Table (name="Medications")
@EntityListeners(AuditingEntityListener.class)
public class Medication implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column (name = "Name")
    @Enumerated(EnumType.STRING)
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

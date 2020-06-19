package InzinjeringOft.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import InzinjeringOft.enums.Diseases;

@Entity
@Table(name = "Diseases")
@EntityListeners(AuditingEntityListener.class)
public class Disease implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "Name")
    @Enumerated(EnumType.STRING)
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


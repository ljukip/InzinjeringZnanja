package InzinjeringOft.model;

import javax.persistence.*;

import InzinjeringOft.enums.Symptoms;

@Entity
@Table (name="Symptoms")
public class Symptom {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column (name="Name")
    @Enumerated(EnumType.STRING)
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

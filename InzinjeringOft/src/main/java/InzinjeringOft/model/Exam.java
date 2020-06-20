package InzinjeringOft.model;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;


@Entity
@Table (name="Exams")
public class Exam {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToMany
	    private Collection<Procedure> procedure;

	    @ManyToOne
	    private Disease disease;

	    @ManyToMany
	    private Collection<Medication> medication;

	    @ManyToMany
	    private Collection<Symptom> symptoms;

	    @ManyToOne
	    @JoinColumn(name = "patient_id")
	    private Patient patient;

	    private LocalDateTime date;

	    public Exam(){};

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Collection<Procedure> getProcedure() {
	        return procedure;
	    }

	    public void setProcedure(Collection<Procedure> procedure) {
	        this.procedure = procedure;
	    }

	    public Disease getDisease() {
	        return disease;
	    }

	    public void setDisease(Disease disease) {
	        this.disease = disease;
	    }

	    public Collection<Symptom> getSymptoms() {
	        return symptoms;
	    }

	    public void setSymptoms(Collection<Symptom> symptoms) {
	        this.symptoms = symptoms;
	    }

	    public Patient getPatient() {
	        return patient;
	    }

	    public void setPatient(Patient patient) {
	        this.patient = patient;
	    }

	    public Collection<Medication> getMedication() {
	        return medication;
	    }

	    public void setMedication(Collection<Medication> medication) {
	        this.medication = medication;
	    }

	    public LocalDateTime getDate() {
	        return date;
	    }

	    public void setDate(LocalDateTime date) {
	        this.date = date;
	    }
}

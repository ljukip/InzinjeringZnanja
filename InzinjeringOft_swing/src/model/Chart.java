package model;

import java.util.List;
public class Chart {

    private Long id;
    private Patient patient;
    private List<Disease> diseases;
    private List<Appointment> procedures;

    public Chart(Long id, Patient patient, List<Disease> diseases, List<Appointment> procedures) {
        this.id = id;
        this.patient = patient;
        this.diseases = diseases;
        this.procedures = procedures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public List<Appointment> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<Appointment> procedures) {
        this.procedures = procedures;
    }
}

package InzinjeringOft.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;

import InzinjeringOft.enums.Genders;
import InzinjeringOft.enums.Race;

@Entity
@Table (name="Patients")
public class Patient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Genders gender;

    @Enumerated(EnumType.STRING)
    private Race race;

    private String address;

    private String city;
    
    private String phoneNumber;
    
    private String email;

    @Basic
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "id")
    private List<Exam> exams;

    public Patient(String firstName, String lastName, Genders gender, String address, LocalDate dateOfBirth, String phoneNumber,String email, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email=email;
        this.city = city;

        this.exams = new ArrayList<>();
    }

    public Patient() {
        this.exams = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Exam> getExaminations() {
        return exams;
    }

    public void setExaminations(List<Exam> examinations) {
        this.exams = examinations;
    }


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.Genders;
import enums.Race;


public class Patient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long id;

    private String firstName;

    private String lastName;
    
    private String jmbg;

    public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

    private Genders gender;

    private Race race;

    private String address;

    private String city;
    
    private String phoneNumber;
    
    private String email;

    private Date dateOfBirth;

    private List<Appointment> Appointments;

    public Patient(String firstName, String lastName, Genders gender,Race race,String jmbg, String address, Date dateOfBirth, String phoneNumber,String email, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email=email;
        this.city = city;
        this.jmbg=jmbg;
        this.race=race;

        this.Appointments = new ArrayList<>();
    }

    public Patient() {
        this.Appointments = new ArrayList<>();
    }
    public void setPatient (String firstName, String lastName, Genders gender,Race race,String jmbg, String address, Date dateOfBirth, String phoneNumber,String email, String city)
    {
    	this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email=email;
        this.city = city;
        this.jmbg=jmbg;
        this.race=race;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    public List<Appointment> getAppointments() {
        return Appointments;
    }

    public void setAppoints(List<Appointment> Appointment) {
        this.Appointments = Appointment;
    }


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

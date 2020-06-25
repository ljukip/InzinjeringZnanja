package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class Appointment implements Serializable{
	    public Appointment(ArrayList<String> procedures, String disease, ArrayList<String> medications,
			ArrayList<String> symptoms) {
		super();
		this.procedures = procedures;
		this.disease = disease;
		this.medications = medications;
		this.symptoms = symptoms;
		this.date=new Date();
	}

		private Long id;

	    private ArrayList<String> procedures;

	    private String disease;

	    public ArrayList<String> getProcedures() {
			return procedures;
		}

		public void setProcedures(ArrayList<String> procedures) {
			this.procedures = procedures;
		}

		public String getDisease() {
			return disease;
		}

		public void setDisease(String disease) {
			this.disease = disease;
		}

		public ArrayList<String> getMedications() {
			return medications;
		}

		public void setMedications(ArrayList<String> medications) {
			this.medications = medications;
		}

		public ArrayList<String> getSymptoms() {
			return symptoms;
		}

		public void setSymptoms(ArrayList<String> symptoms) {
			this.symptoms = symptoms;
		}

		public String getChart() {
			return chart;
		}

		public void setChart(String chart) {
			this.chart = chart;
		}

		private ArrayList<String> medications;

	    private ArrayList<String> symptoms;

	    private Patient patient;

	    private Date date;
	    
	    private String chart;

	    public Appointment(){};

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


	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }
	    @Override
		public String toString()
		{
	    	String date=new SimpleDateFormat("dd-MM-yyyy HH:mm").format(this.date);
			return date;
		}
}

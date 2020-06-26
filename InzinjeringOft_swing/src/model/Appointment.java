package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;


public class Appointment implements Serializable, CaseComponent{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


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
	    private String disease,procedure;
	    private ArrayList<String> medications;
	    private ArrayList<String> symptoms;
	    private Patient patient;
	    private Date date;  
	    private String chart;
	    private int blindness,
		eye_redness,
		itchiness_of_eye,
		diminished_vision,
		double_vision,
		eyelid_swelling,
		swollen_eye,
		abnormal_eyelid_movement,
		abnormal_eye_movement,
		eye_deviation,
		cross_eyed,
		eye_pain,
		eye_burns_or_stings,
		foreign_body_sensation,
		lacrimation,
		spots_or_clouds_in_vision,
		eyelid_lesion,
		eyelid_rash,
		eye_symptoms,
		white_discharge_from_eye,
		yellow_discharge_from_eye,
		mass_on_eyelid,
		bleeding_from_eye,
		cough,
		nasal_congestion,
		fever,
		sore_throat,
		coryza,
		allergic_reaction,
		sneezing,
		ear_pain,
		abnormal_appearing_skin,
		cloudy_eye;
	    
	    public int getWhite_discharge_from_eye() {
			return white_discharge_from_eye;
		}

		public void setWhite_discharge_from_eye(int white_discharge_from_eye) {
			this.white_discharge_from_eye = white_discharge_from_eye;
		}

		public int getYellow_discharge_from_eye() {
			return yellow_discharge_from_eye;
		}

		public void setYellow_discharge_from_eye(int yellow_discharge_from_eye) {
			this.yellow_discharge_from_eye = yellow_discharge_from_eye;
		}

		public int getMass_on_eyelid() {
			return mass_on_eyelid;
		}

		public void setMass_on_eyelid(int mass_on_eyelid) {
			this.mass_on_eyelid = mass_on_eyelid;
		}

		public int getBleeding_from_eye() {
			return bleeding_from_eye;
		}

		public void setBleeding_from_eye(int bleeding_from_eye) {
			this.bleeding_from_eye = bleeding_from_eye;
		}

		public int getCough() {
			return cough;
		}

		public void setCough(int cough) {
			this.cough = cough;
		}

		public int getNasal_congestion() {
			return nasal_congestion;
		}

		public void setNasal_congestion(int nasal_congestion) {
			this.nasal_congestion = nasal_congestion;
		}

		public int getFever() {
			return fever;
		}

		public void setFever(int fever) {
			this.fever = fever;
		}

		public int getSore_throat() {
			return sore_throat;
		}

		public void setSore_throat(int sore_throat) {
			this.sore_throat = sore_throat;
		}

		public int getCoryza() {
			return coryza;
		}

		public void setCoryza(int coryza) {
			this.coryza = coryza;
		}

		public int getAllergic_reaction() {
			return allergic_reaction;
		}

		public void setAllergic_reaction(int allergic_reaction) {
			this.allergic_reaction = allergic_reaction;
		}

		public int getSneezing() {
			return sneezing;
		}

		public void setSneezing(int sneezing) {
			this.sneezing = sneezing;
		}

		public int getEar_pain() {
			return ear_pain;
		}

		public void setEar_pain(int ear_pain) {
			this.ear_pain = ear_pain;
		}

		public int getAbnormal_appearing_skin() {
			return abnormal_appearing_skin;
		}

		public void setAbnormal_appearing_skin(int abnormal_appearing_skin) {
			this.abnormal_appearing_skin = abnormal_appearing_skin;
		}

		public int getCloudy_eye() {
			return cloudy_eye;
		}

		public void setCloudy_eye(int cloudy_eye) {
			this.cloudy_eye = cloudy_eye;
		}

		public Appointment() {
	    	this.blindness=0;
	    	this.eye_redness=0;
	    	this.itchiness_of_eye=0;
	    	this.diminished_vision=0;
	    	this.double_vision=0;
	    	this.eyelid_swelling=0;
	    	this.swollen_eye=0;
	    	this.abnormal_eyelid_movement=0;
	    	this.abnormal_eye_movement=0;
	    	this.eye_deviation=0;
	    	this.cross_eyed=0;
	    	this.eye_pain=0;
	    	this.eye_burns_or_stings=0;
	    	this.foreign_body_sensation=0;
	    	this.lacrimation=0;
	    	this.spots_or_clouds_in_vision=0;
	    	this.eyelid_lesion=0;
	    	this.eyelid_rash=0;
	    	this.eye_symptoms=0;
	    	this.white_discharge_from_eye=0;
	    	this.yellow_discharge_from_eye=0;
	    	this.mass_on_eyelid=0;
	    	this.bleeding_from_eye=0;
	    	this.cough=0;
	    	this.nasal_congestion=0;
	    	this.fever=0;
	    	this.sore_throat=0;
	    	this.coryza=0;
	    	this.allergic_reaction=0;
	    	this.sneezing=0;
	    	this.ear_pain=0;
	    	this.abnormal_appearing_skin=0;
	    	this.cloudy_eye=0;
	    }
	    
	    public Appointment(HashMap<String, Integer> mapa, String disease)
		{
	    	this.blindness=mapa.get("blindness");
	    	this.eye_redness=mapa.get("eye_redness");
	    	this.itchiness_of_eye=mapa.get("itchiness_of_eye");
	    	this.diminished_vision=mapa.get("diminished_vision");
	    	this.double_vision=mapa.get("double_vision");
	    	this.eyelid_swelling=mapa.get("eyelid_swelling");
	    	this.swollen_eye=mapa.get("swollen_eye");
	    	this.abnormal_eyelid_movement=mapa.get("abnormal_eyelid_movement");
	    	this.abnormal_eye_movement=mapa.get("abnormal_eye_movement");
	    	this.eye_deviation=mapa.get("eye_deviation");
	    	this.cross_eyed=mapa.get("cross_eyed");
	    	this.eye_pain=mapa.get("eye_pain");
	    	this.eye_burns_or_stings=mapa.get("eye_burns_or_stings");
	    	this.foreign_body_sensation=mapa.get("foreign_body_sensation");
	    	this.lacrimation=mapa.get("lacrimation");
	    	this.spots_or_clouds_in_vision=mapa.get("spots_or_clouds_in_vision");
	    	this.eyelid_lesion=mapa.get("eyelid_lesion");
	    	this.eyelid_rash=mapa.get("eyelid_rash");
	    	this.eye_symptoms=mapa.get("eye_symptoms");
	    	this.white_discharge_from_eye=mapa.get("white_discharge_from_eye");
	    	this.yellow_discharge_from_eye=mapa.get("yellow_discharge_from_eye");
	    	this.mass_on_eyelid=mapa.get("mass_on_eyelid");
	    	this.bleeding_from_eye=mapa.get("bleeding_from_eye");
	    	this.cough=mapa.get("cough");
	    	this.nasal_congestion=mapa.get("nasal_congestion");
	    	this.fever=mapa.get("fever");
	    	this.sore_throat=mapa.get("sore_throat");
	    	this.coryza=mapa.get("coryza");
	    	this.allergic_reaction=mapa.get("coryza");
	    	this.sneezing=mapa.get("sneezing");
	    	this.ear_pain=mapa.get("ear_pain");
	    	this.abnormal_appearing_skin=mapa.get("abnormal_appearing_skin");
	    	this.cloudy_eye=mapa.get("cloudy_eye");
	    	
		}
	    public Appointment(String disease)
		{

			String[] values = disease.split(",");
			
			this.disease=values[0];
			this.blindness=Integer.parseInt(values[1]);
	    	this.eye_redness=Integer.parseInt(values[2]);
	    	this.itchiness_of_eye=Integer.parseInt(values[3]);
	    	this.diminished_vision=Integer.parseInt(values[4]);
	    	this.double_vision=Integer.parseInt(values[5]);;
	    	this.eyelid_swelling=Integer.parseInt(values[6]);
	    	this.swollen_eye=Integer.parseInt(values[7]);
	    	this.abnormal_eyelid_movement=Integer.parseInt(values[8]);
	    	this.abnormal_eye_movement=Integer.parseInt(values[9]);
	    	this.eye_deviation=Integer.parseInt(values[10]);
	    	this.cross_eyed=Integer.parseInt(values[11]);
	    	this.eye_pain=Integer.parseInt(values[12]);
	    	this.eye_burns_or_stings=Integer.parseInt(values[13]);
	    	this.foreign_body_sensation=Integer.parseInt(values[14]);
	    	this.lacrimation=Integer.parseInt(values[15]);
	    	this.spots_or_clouds_in_vision=Integer.parseInt(values[16]);
	    	this.eyelid_lesion=Integer.parseInt(values[17]);
	    	this.eyelid_rash=Integer.parseInt(values[18]);
	    	this.eye_symptoms=Integer.parseInt(values[19]);
	    	this.white_discharge_from_eye=Integer.parseInt(values[20]);
	    	this.yellow_discharge_from_eye=Integer.parseInt(values[21]);
	    	this.mass_on_eyelid=Integer.parseInt(values[22]);
	    	this.bleeding_from_eye=Integer.parseInt(values[23]);
	    	this.cough=Integer.parseInt(values[24]);
	    	this.nasal_congestion=Integer.parseInt(values[25]);
	    	this.fever=Integer.parseInt(values[26]);
	    	this.sore_throat=Integer.parseInt(values[27]);
	    	this.coryza=Integer.parseInt(values[28]);
	    	this.allergic_reaction=Integer.parseInt(values[29]);
	    	this.sneezing=Integer.parseInt(values[30]);
	    	this.ear_pain=Integer.parseInt(values[31]);
	    	this.abnormal_appearing_skin=Integer.parseInt(values[32]);
	    	this.cloudy_eye=Integer.parseInt(values[33]);
	    	this.procedure=values[34];
	    	
			
		}
	    
	    

	    

		public int getBlindness() {
			return blindness;
		}

		public void setBlindness(int blindness) {
			this.blindness = blindness;
		}

		public int getEye_redness() {
			return eye_redness;
		}

		public void setEye_redness(int eye_redness) {
			this.eye_redness = eye_redness;
		}

		public int getItchiness_of_eye() {
			return itchiness_of_eye;
		}

		public void setItchiness_of_eye(int itchiness_of_eye) {
			this.itchiness_of_eye = itchiness_of_eye;
		}

		public int getDiminished_vision() {
			return diminished_vision;
		}

		public void setDiminished_vision(int diminished_vision) {
			this.diminished_vision = diminished_vision;
		}

		public int getDouble_vision() {
			return double_vision;
		}

		public void setDouble_vision(int double_vision) {
			this.double_vision = double_vision;
		}

		public int getEyelid_swelling() {
			return eyelid_swelling;
		}

		public void setEyelid_swelling(int eyelid_swelling) {
			this.eyelid_swelling = eyelid_swelling;
		}

		public int getSwollen_eye() {
			return swollen_eye;
		}

		public void setSwollen_eye(int swollen_eye) {
			this.swollen_eye = swollen_eye;
		}

		public int getAbnormal_eyelid_movement() {
			return abnormal_eyelid_movement;
		}

		public void setAbnormal_eyelid_movement(int abnormal_eyelid_movement) {
			this.abnormal_eyelid_movement = abnormal_eyelid_movement;
		}

		public int getAbnormal_eye_movement() {
			return abnormal_eye_movement;
		}

		public void setAbnormal_eye_movement(int abnormal_eye_movement) {
			this.abnormal_eye_movement = abnormal_eye_movement;
		}

		public int getEye_deviation() {
			return eye_deviation;
		}

		public void setEye_deviation(int eye_deviation) {
			this.eye_deviation = eye_deviation;
		}

		public int getCross_eyed() {
			return cross_eyed;
		}

		public void setCross_eyed(int cross_eyed) {
			this.cross_eyed = cross_eyed;
		}

		public int getEye_pain() {
			return eye_pain;
		}

		public void setEye_pain(int eye_pain) {
			this.eye_pain = eye_pain;
		}

		public int getEye_burns_or_stings() {
			return eye_burns_or_stings;
		}

		public void setEye_burns_or_stings(int eye_burns_or_stings) {
			this.eye_burns_or_stings = eye_burns_or_stings;
		}

		public int getForeign_body_sensation() {
			return foreign_body_sensation;
		}

		public void setForeign_body_sensation(int foreign_body_sensation) {
			this.foreign_body_sensation = foreign_body_sensation;
		}

		public int getLacrimation() {
			return lacrimation;
		}

		public void setLacrimation(int lacrimation) {
			this.lacrimation = lacrimation;
		}

		public int getSpots_or_clouds_in_vision() {
			return spots_or_clouds_in_vision;
		}

		public void setSpots_or_clouds_in_vision(int spots_or_clouds_in_vision) {
			this.spots_or_clouds_in_vision = spots_or_clouds_in_vision;
		}

		public int getEyelid_lesion() {
			return eyelid_lesion;
		}

		public void setEyelid_lesion(int eyelid_lesion) {
			this.eyelid_lesion = eyelid_lesion;
		}

		public int getEyelid_rash() {
			return eyelid_rash;
		}

		public void setEyelid_rash(int eyelid_rash) {
			this.eyelid_rash = eyelid_rash;
		}

		public int getEye_symptoms() {
			return eye_symptoms;
		}

		public void setEye_symptoms(int eye_symptoms) {
			this.eye_symptoms = eye_symptoms;
		}

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
	    	return procedure;
		}

	    public String stringDate() {
	    	String date=new SimpleDateFormat("dd-MM-yyyy HH:mm").format(this.date);
			return date;
	    }
		@Override
		public Attribute getIdAttribute() {
			// TODO Auto-generated method stub
			return null;
		}
}

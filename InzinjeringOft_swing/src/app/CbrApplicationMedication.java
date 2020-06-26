package app;

import java.util.Collection;
import java.util.HashMap;

import javax.swing.ListModel;

import controller.CsvConnectorMedication;
import model.Disease;
import model.Medication;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;
import view.MainFrame;

public class CbrApplicationMedication implements StandardCBRApplication{
	
	Connector _connector;
	/** Connector object */
	CBRCaseBase _caseBase;
	/** CaseBase object */

	NNConfig simConfig;

	/** KNN configuration */
	
	

	@Override
	public void configure() throws ExecutionException {
		// TODO Auto-generated method stub
		
		_connector = new CsvConnectorMedication();

		_caseBase = new LinealCaseBase(); // Create a Lineal case base for in-memory organization

		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average()); // global similarity function = average
		
		simConfig.addMapping(new Attribute("blindness", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("eye_redness", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("itchiness_of_eye", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("diminished_vision", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("double_vision", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("eyelid_swelling", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("swollen_eye", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("abnormal_eyelid_movement", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("abnormal_eye_movement", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("eye_deviation", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("cross_eyed", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("eye_pain", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("eye_burns_or_stings", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("foreign_body_sensation", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("lacrimation", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("spots_or_clouds_in_vision", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("eyelid_lesion", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("eyelid_rash", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("eye_symptoms", Medication.class), new Equal());
		
		simConfig.addMapping(new Attribute("disease", Medication.class), new Equal());
		simConfig.addMapping(new Attribute("posibility", Medication.class), new Interval(100));
		
	}

	@Override
	public void cycle(CBRQuery query) throws ExecutionException {
		// TODO Auto-generated method stub
		MainFrame.getInstance().getPmp().getHashMeds().clear();

		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 3);
		System.out.println("Retrieved meds:");
		for (RetrievalResult nse : eval)
		{
			MainFrame.getInstance().getPmp().getHashMeds().put(nse.get_case().getDescription().toString(),
					(int) (nse.getEval() * 100));
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
		}
		
	}

	@Override
	public void postCycle() throws ExecutionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CBRCaseBase preCycle() throws ExecutionException {
		// TODO Auto-generated method stub
		_caseBase.init(_connector);
		@SuppressWarnings("unused")
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		/*
		 * for (CBRCase c : cases) System.out.println(c.getDescription());
		 */
		return _caseBase;
	}
	
	public static void main(String[] args)
	{

		StandardCBRApplication recommender = new CbrApplicationMedication();
		try
		{
			recommender.configure();

			recommender.preCycle();

			CBRQuery query = new CBRQuery();

			ListModel<String> mf = MainFrame.getInstance().getPsp().getSelectedSymptoms();
			String selectedSymptoms = "";
			for (int i = 0; i < mf.getSize();)
			{
				selectedSymptoms = selectedSymptoms.concat(mf.getElementAt(i));
				i++;
			}

			HashMap<String, Integer> mapa = new HashMap<>();
			//<symptom(from symptoms),0/1>
			String symptoms = "disease,blindness,eye_redness,itchiness_of_eye,diminished_vision,double_vision,eyelid_swelling,swollen_eye,abnormal_eyelid_movement,abnormal_eye_movement,eye_deviation,cross_eyed,eye_pain,eye_burns_or_stings,foreign_body_sensation,lacrimation,spots_or_clouds_in_vision,eyelid_lesion,eyelid_rash,eye_symptoms,white_discharge_from_eye,yellow_discharge_from_eye,mass_on_eyelid,bleeding_from_eye,cough,nasal_congestion,fever,sore_throat,coryza,allergic_reaction,sneezing,ear_pain,abnormal_appearing_skin,cloudy_eye";
			symptoms = symptoms.replace(" ", "");

			String[] vars = symptoms.split(",");
			for (String s : vars)
			{
				if (!selectedSymptoms.contains(s))
				{
					mapa.put(s, 0);
				}
				else
				{
					mapa.put(s, 1);
				}
			}
			Medication medication = new Medication(mapa, MainFrame.getInstance().getPdp().getDiseases().getSelectedValue(), 100);

			query.setDescription(medication);
			recommender.cycle(query);

			recommender.postCycle();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

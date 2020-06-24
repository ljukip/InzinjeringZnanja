package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.ListModel;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;

import view.MainFrame;

public class LoadData {
	private ArrayList<String> symptoms;
	public static String symptomsS;
	
	public LoadData() {
		
		this.symptoms=new ArrayList<>();

	}
	

	public ArrayList<String> getSymptoms() {
		
		JIPEngine engine = new JIPEngine();
		engine.consultFile("data/diseasesAndSymptoms.pl");
		JIPQuery query = engine.openSynchronousQuery("symptom_disease_possibility(S,D,P)");

		JIPTerm solution;

		while ((solution = query.nextSolution()) != null)
		{
			JIPVariable[] vars = solution.getVariables();

			String symptom;

			symptom = vars[0].toString();

			this.symptoms.add(symptom);

		}
		Set<String> set = new LinkedHashSet<String>();

		set.addAll(symptoms);
		symptoms.clear();
		symptoms.addAll(set);
		
		return symptoms;
	}

	public void setSymptoms(ArrayList<String> sym) {
		symptoms = sym;
	}
	
	public void getDiseases (){
		String symptoms = "[";

		ListModel<String> lM = MainFrame.getInstance().getPsp().getListSelectedSymptoms().getModel();

		for (int i = 0; i < lM.getSize();)
		{
			symptoms = symptoms.concat(lM.getElementAt(i++) + ", ");
		}

		symptoms = symptoms.substring(0, symptoms.length() - 2);

		symptoms = symptoms.concat(" ]");
		symptomsS=symptoms;

		JIPEngine engine = new JIPEngine();
		engine.consultFile("data/diseasesAndSymptoms.pl");

		//System.out.println(symptoms);
		//System.out.println(MainFrame.getInstance().getPsp().getSelectedSymptoms().toString());
		JIPQuery query = engine.openSynchronousQuery("function(" + symptoms + ",D,P)");

		JIPTerm solution;
		HashMap<String, Double> mapDiseases = new HashMap<>();

		while ((solution = query.nextSolution()) != null)
		{
			JIPVariable[] vars = solution.getVariables();
			//System.out.println("usao  "+vars[0].toString()+"  "+ Double.parseDouble(vars[1].toString()));
			//vraca bolest i broj simptoma u njoj

			mapDiseases.put(vars[0].toString(), Double.parseDouble(vars[1].toString()));

		}

		query = engine.openSynchronousQuery("avg_symptom_disease(D, " + symptoms + ", No)");
		while ((solution = query.nextSolution()) != null)
		{
			JIPVariable[] vars = solution.getVariables();
			mapDiseases.put(vars[0].toString(),
					Double.parseDouble(vars[1].toString()) + mapDiseases.get(vars[0].toString()));
		}

		ArrayList<Double> listPosibleDiseases = new ArrayList<>();
		for (Map.Entry<String, Double> iterator : mapDiseases.entrySet())
		{
			listPosibleDiseases.add(iterator.getValue());
		}

		java.util.Collections.sort(listPosibleDiseases, java.util.Collections.reverseOrder());
		MainFrame.getInstance().getPdp().getHashDiseases().clear();
		int j = 0;

		for (int i = 0; i < 3; i++)
		{
			for (Map.Entry<String, Double> iter : mapDiseases.entrySet())
			{
				if (iter.getValue() == listPosibleDiseases.get(j))
				{
					MainFrame.getInstance().getPdp().getHashDiseases().put(iter.getKey(), iter.getValue());
					j++;
					break;
				}
			}
		}
	}
	

}

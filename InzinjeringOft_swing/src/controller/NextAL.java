package controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import app.CbrApplication;
import app.CbrApplicationMedication;
import app.CbrApplicationProcedure;
import app.Collections;
import model.Appointment;
import model.Patient;
import view.Graph;
import view.MainFrame;
import view.PatientsSymptomsPanel;
import view.PosibleDiseasesPanel;
import view.ProcedureMedicationPanel;
import view.SubmitChartPanel;


public class NextAL implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("NextAL");
		// TODO Auto-generated method stub
		MainFrame mf = MainFrame.getInstance();
		Component[] components = mf.getPanel().getComponents();
		//String selectedSymptoms=LoadData.symptomsS;
		
		//rule based
		if (components[0] instanceof PatientsSymptomsPanel)
		{
			ArrayList<String> selectedSymptoms = new ArrayList<>();

			DefaultListModel<String> dLm = MainFrame.getInstance().getPsp().getSelectedSymptoms();

			for (int i = 0; i < dLm.getSize(); i++)
			{
				selectedSymptoms.add(dLm.getElementAt(i));
			}
			for (int i = 0; i < mf.getPsp().getSelectedSymptoms().getSize(); i++)
			{
				String s = mf.getPsp().getSelectedSymptoms().get(i);

				mf.getDisease().setSymptomCase(s);

			}
			
			String text="Patient is experiencing the following symptoms:" 
					+ selectedSymptoms;
			
			MainFrame.getInstance().getPdp().setReport(new JLabel(text));

				mf.getPanel().removeAll();


				//uzimamo podatke za ruleBased
				if(MainFrame.isCase==false) {
				mf.getData().getDiseases();
				
				mf.getPdp().fillHasDiseases();

				
				@SuppressWarnings("unused")
				Graph g = new Graph(mf.getPdp().getHashDiseases());
				mf.getPdp().graphInsert();
				}
				//Uzimamo podatke za case based
				else if(MainFrame.isCase==true) {
					System.out.println("case poceo");
					
				@SuppressWarnings("unused")
				CbrApplication cA = new CbrApplication();
				CbrApplication.main(null);
				
				@SuppressWarnings("unused")
				Graph g = new Graph(mf.getMapCbrDiseases());
				mf.getPdp().graphInsert();

				}
				

				//System.out.println(mf.getPdp().getHashDiseases());
				
				mf.getPdp().getReport().revalidate();
				mf.getPdp().getReport().repaint();
				mf.getPdp().getScrollReport().revalidate();
				mf.getPdp().getScrollReport().repaint();

				MainFrame.getInstance().getPanel().removeAll();
				PosibleDiseasesPanel view = MainFrame.getInstance().getPdp();
				MainFrame.getInstance().getPanel().add(view);
				MainFrame.getInstance().getPanel().revalidate();
				MainFrame.getInstance().getPanel().repaint();
		}

		else if (components[0] instanceof PosibleDiseasesPanel)
		{

				mf.getDisease().setName(mf.getPdp().getDiseases().getSelectedValue());

				mf.getPanel().removeAll();

		
				if(MainFrame.isCase==false) {
					mf.getData().fillMeds();
					mf.getData().fillProcedures();
					
					mf.getPmp().fillMeds();
					mf.getPmp().fillProcedures();
					
				@SuppressWarnings("unused")
				Graph gm = new Graph(mf.getPmp().getHashMeds(),1);
				mf.getPmp().graphInsert();
				@SuppressWarnings("unused")
				Graph gp = new Graph(mf.getPmp().getHashProcedures(),2);
				mf.getPmp().graphInsert();
				}
				else if(MainFrame.isCase==true) {
					CbrApplicationMedication cam=new CbrApplicationMedication();
					CbrApplicationMedication.main(null);
					CbrApplicationProcedure.main(null);
				
					mf.getPmp().fillMeds();
					mf.getPmp().fillProcedures();
					
					@SuppressWarnings("unused")
					Graph gm = new Graph(mf.getPmp().getHashMeds(),1);
					mf.getPmp().graphInsert();
					@SuppressWarnings("unused")
					Graph gp = new Graph(mf.getPmp().getHashProcedures(),2);
					mf.getPmp().graphInsert();
				}

				MainFrame.getInstance().getPanel().removeAll();
				ProcedureMedicationPanel view = MainFrame.getInstance().getPmp();
				MainFrame.getInstance().getPanel().add(view);
				MainFrame.getInstance().getPanel().revalidate();
				MainFrame.getInstance().getPanel().repaint();
		}
		
		else if (components[0] instanceof ProcedureMedicationPanel)
		{

			mf.getPanel().removeAll();
			
			HashMap<String, String> map = new HashMap<>();
			
			map.put("Patient:", MainFrame.getInstance().getPsp().getPatient().getFirstName()+" "+MainFrame.getInstance().getPsp().getPatient().getLastName());
			map.put("Reported symptoms:",MainFrame.getInstance().getPsp().getSelectedSymptoms().toString());
			map.put("Diagnosed with:", MainFrame.getInstance().getDisease().getName());
			map.put("Additional procedures recomended:", MainFrame.getInstance().getPmp().getSelProcedures().toString());
			map.put("Therapy prescribed:", MainFrame.getInstance().getPmp().getSelMeds().toString());
			

			MainFrame.getInstance().getPanel().removeAll();
			MainFrame.getInstance().setScp(new SubmitChartPanel(map));
			SubmitChartPanel view = MainFrame.getInstance().getScp();
			MainFrame.getInstance().getPanel().add(view);
			MainFrame.getInstance().getPanel().revalidate();
			MainFrame.getInstance().getPanel().repaint();
		}
		
		else if (components[0] instanceof SubmitChartPanel) {
			
			if(MainFrame.isCase==true) {MainFrame.isCase=false;}
			
			ArrayList<String> symptoms, meds, procedures;

			symptoms = new ArrayList<>();
			meds = new ArrayList<>();
			procedures = new ArrayList<>();
			String disease;
			
			disease=MainFrame.getInstance().getDisease().getName();
			
			for(int i=0; i<MainFrame.getInstance().getPsp().getSelectedSymptoms().size();i++) {
				symptoms.add(MainFrame.getInstance().getPsp().getSelectedSymptoms().get(i));
			}
			for(int i=0; i<MainFrame.getInstance().getPmp().getSelMeds().size();i++) {
				meds.add(MainFrame.getInstance().getPmp().getSelMeds().get(i));
			}
			for(int i=0; i<MainFrame.getInstance().getPmp().getSelProcedures().size();i++) {
				procedures.add(MainFrame.getInstance().getPmp().getSelProcedures().get(i));
			}
			Appointment appointment= new Appointment(procedures, disease,meds,symptoms);

			SubmitChartPanel scp = (SubmitChartPanel) components[0];

			appointment.setChart(scp.getLabel().getText());
			
			DefaultMutableTreeNode element = (DefaultMutableTreeNode) mf.getTreeModel().getRoot();

			for (int i = 0; i < element.getChildCount(); i++)
			{
				DefaultMutableTreeNode patient = (DefaultMutableTreeNode) element.getChildAt(i);
				Patient p = (Patient) patient.getUserObject();

				if (p.toString().equals(mf.getPsp().getPatient().toString()))
				{
					mf.getTreeModel().insertNodeInto(new DefaultMutableTreeNode(appointment), patient,
							patient.getChildCount());

					for (Patient iterPat : Collections.getInstance().getPatientList())
					{
						if (iterPat.getFirstName().equals(p.getFirstName()) && iterPat.getLastName().equals(p.getLastName()))
						{
							iterPat.getAppointments().add(appointment);
						}
					}

				}
			}
			
			mf.getPanel().removeAll();

			mf.getPanel().revalidate();
			mf.getPanel().repaint();
			int reply = JOptionPane.showConfirmDialog(mf, "Are you sure you want to submit the chart?", "Submit",
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION)
			{
				try
				{
					String filename = "data/cases_symptoms.csv";
					FileWriter fw = new FileWriter(filename, true); // the true will append the new data
					fw.write(mf.getDisease().stringForCase());// appends the string to the file
					fw.close();
				}
				catch (IOException ioe)
				{
					System.err.println("IOException: " + ioe.getMessage());
				}
			
			}

		}
	}

}

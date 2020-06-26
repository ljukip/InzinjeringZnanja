package controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import view.MainFrame;
import view.PatientsSymptomsPanel;
import view.PosibleDiseasesPanel;
import view.ProcedureMedicationPanel;
import view.SubmitChartPanel;

public class BackAL implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainFrame mf = MainFrame.getInstance();
		Component[] components = mf.getPanel().getComponents();

		if (components[0] instanceof PatientsSymptomsPanel)
		{
			if(MainFrame.isCase==true) {MainFrame.isCase=false;}
			
			mf.getPanel().removeAll();
			
			mf.getPanel().revalidate();
			mf.getPanel().repaint();

		}
		else if (components[0] instanceof PosibleDiseasesPanel)
		{
			mf.getPanel().removeAll();
			mf.getPanel().add(mf.getPsp(), BorderLayout.CENTER);
			mf.getPdp().Clear();

			mf.getPsp().getReport().setText(mf.getPdp().getReport().getText());
			mf.getPsp().getReport().revalidate();
			mf.getPsp().getReport().repaint();

			String text = mf.getPsp().getReport().getText();

			JLabel newReport = new JLabel(text);
			mf.getPsp().setReport(newReport);

			mf.getPanel().revalidate();
			mf.getPanel().repaint();


		}
		
		else if (components[0] instanceof ProcedureMedicationPanel)
		{
			mf.getPanel().removeAll();
			mf.getPanel().add(mf.getPdp(), BorderLayout.CENTER);

			mf.getPanel().revalidate();
			mf.getPanel().repaint();

		}
		else if (components[0] instanceof SubmitChartPanel)
		{
			mf.getPanel().removeAll();
			mf.getPanel().add(mf.getPmp(), BorderLayout.CENTER);

			mf.getPanel().revalidate();
			mf.getPanel().repaint();

		}
		
	}

}

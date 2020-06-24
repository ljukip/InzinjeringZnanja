package controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.MainFrame;
import view.PatientsSymptomsPanel;
import view.PosibleDiseasesPanel;


public class NextAL implements ActionListener{
	

	public NextAL() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainFrame mf = MainFrame.getInstance();
		Component[] components = mf.getPanel().getComponents();
		//String selectedSymptoms=LoadData.symptomsS;
		
		
		if (components[0] instanceof PatientsSymptomsPanel)
		{

			for (int i = 0; i < mf.getPsp().getSelectedSymptoms().getSize(); i++)
				{
					String s = mf.getPsp().getSelectedSymptoms().get(i);

				}

				mf.getPanel().removeAll();

				mf.getData().getDiseases();
				mf.getPdp().fillHasDiseases();
				mf.getPdp().getScrollReport().revalidate();
				mf.getPdp().getScrollReport().repaint();

				MainFrame.getInstance().getPanel().removeAll();
				PosibleDiseasesPanel view = MainFrame.getInstance().getPdp();
				MainFrame.getInstance().getPanel().add(view);
				MainFrame.getInstance().getPanel().revalidate();
				MainFrame.getInstance().getPanel().repaint();
		}

		
	}

}

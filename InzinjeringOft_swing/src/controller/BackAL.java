package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;
import view.PatientsSymptomsPanel;

public class BackAL implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainFrame mf = MainFrame.getInstance();
		Component[] components = mf.getPanel().getComponents();

		if (components[0] instanceof PatientsSymptomsPanel)
		{
			mf.getPanel().removeAll();
			
			mf.getPanel().revalidate();
			mf.getPanel().repaint();

		}
		
	}

}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;

public class NewCaseAppointment implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//notify its case
		MainFrame.isCase=true;
		//kad se case zavrsi, vrati na false
		NewAppointment np=new NewAppointment();
		np.actionPerformed(e);
	}

}

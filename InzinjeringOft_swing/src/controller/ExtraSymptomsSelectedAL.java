package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import view.MainFrame;


public class ExtraSymptomsSelectedAL implements MouseListener {
	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getClickCount() == 2)
		{
			BackAL bal=new BackAL(); //odemo panel nazad, da bi se u nextal poslala komponenta psp
			NextAL nal= new NextAL();
			MainFrame.getInstance().disable();
			
			if (MainFrame.getInstance().getPdp().getSymptoms().getSelectedValue() != null)
			{

				MainFrame.getInstance().getPsp().addSelectedSymptom(MainFrame.getInstance().getPdp().getSymptoms().getSelectedValue());

				
				bal.actionPerformed(null);
				nal.actionPerformed(new ActionEvent(nal, 0, null));
				MainFrame.getInstance().enable();
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

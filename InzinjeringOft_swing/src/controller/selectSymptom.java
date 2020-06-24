package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Patient;
import view.MainFrame;


public class selectSymptom implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getClickCount() == 2)
		{
			//saljemo selektovanu vrednost da se doda
			MainFrame.getInstance().getPsp().addSelectedSymptom(MainFrame.getInstance().getPsp().getListAllSymptoms().getSelectedValue());
			
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

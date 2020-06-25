package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import view.MainFrame;


public class SelectMedications implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getClickCount() == 2)
		{
			if(MainFrame.getInstance().getPmp().getSelMeds().contains(MainFrame.getInstance().getPmp().getListMeds().getSelectedValue())==false)

				MainFrame.getInstance().getPmp().getSelMeds()
						.addElement(MainFrame.getInstance().getPmp().getListMeds().getSelectedValue());

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

package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Appointment;
import model.Medication;
import view.MainFrame;

public class SelectProcedures implements MouseListener {
	private Appointment app;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getClickCount() == 2)
		{
			if(MainFrame.getInstance().getPmp().getSelProcedures().contains(MainFrame.getInstance().getPmp().getListProcedures().getSelectedValue())==false)

				MainFrame.getInstance().getPmp().getSelProcedures().addElement(MainFrame.getInstance().getPmp().getListProcedures().getSelectedValue());
		
			app = new Appointment(MainFrame.getInstance().getDisease().getName(),
					MainFrame.getInstance().getPmp().getListProcedures().getSelectedValue(),
					MainFrame.getInstance().getPmp().getHashProcedures().get(MainFrame.getInstance().getPmp().getListProcedures().getSelectedValue()));
			MainFrame.getInstance().getApp().add(app);
			
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
